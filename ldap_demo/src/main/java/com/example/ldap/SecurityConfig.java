package com.example.ldap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.ldap.authentication.LdapAuthenticationProvider;
import org.springframework.security.ldap.authentication.BindAuthenticator;
import org.springframework.security.ldap.search.FilterBasedLdapUserSearch;
import org.springframework.security.ldap.userdetails.DefaultLdapAuthoritiesPopulator;
import org.springframework.security.ldap.userdetails.LdapAuthoritiesPopulator;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security 安全配置类。
 *
 * 核心职责：
 * 1. 告诉 Spring Security "去哪里认证用户" —— 对接 LDAP 服务器
 * 2. 告诉 Spring Security "认证成功后用户拥有什么角色" —— 从 LDAP 组映射
 * 3. 告诉 Spring Security "哪些接口需要什么权限" —— 定义 URL 级别的访问规则
 *
 * Spring Security 的工作方式（通俗理解）：
 * 用户发起请求 → 拦截 → 要求提供凭据 → 拿着凭据去认证 → 认证成功则加载角色 → 检查角色是否有权限访问该接口 → 放行或拒绝
 */
@Configuration
// 启用 Spring Security 的 Web 安全功能，相当于告诉 Spring"我要用安全框架"
@EnableWebSecurity
public class SecurityConfig {

    /**
     * LdapContextSource：连接到 LDAP 服务器的"通道"。
     * 由 Spring Boot 自动从 application.yml 的 spring.ldap.* 配置中创建并注入，
     * 包含 LDAP 地址、base DN、查询账号（cn=admin）和密码等信息。
     * 后续所有 LDAP 操作都通过这个通道进行。
     */
    private final LdapContextSource contextSource;

    public SecurityConfig(LdapContextSource contextSource) {
        this.contextSource = contextSource;
    }

    /**
     * 角色填充器（Authorities Populator）。
     *
     * 作用：认证成功后，从 LDAP 中查找用户所属的组，并把组名转换为 Spring Security 中的角色。
     *
     * 工作流程：
     * 1. 用户在 LDAP 认证成功之后，Spring Security 拿到用户的 DN（如 uid=zhangsan,ou=users,dc=example,dc=com）
     * 2. 用这个 DN 到 ou=groups 下面搜索，看看哪些组把该用户列为成员（通过组的 member 属性）
     * 3. 把找到的组的 cn 属性值提取出来，转换为角色名
     *
     * 举例：zhangsan 登录成功后，搜索发现 cn=admin 组的 member 属性包含 zhangsan 的 DN，
     *       于是提取 "admin"，加上 "ROLE_" 前缀，大写转换 → "ROLE_ADMIN"
     */
    @Bean
    public LdapAuthoritiesPopulator authoritiesPopulator() {
        DefaultLdapAuthoritiesPopulator populator =
                new DefaultLdapAuthoritiesPopulator(contextSource, "ou=groups");
        // 使用组的哪个属性作为角色名 → 用 cn（common name），即组名本身
        populator.setGroupRoleAttribute("cn");
        // 角色前缀：Spring Security 的 hasRole("ADMIN") 实际匹配的是 "ROLE_ADMIN"，所以必须加前缀
        populator.setRolePrefix("ROLE_");
        // 角色名统一转大写：cn=admin → ADMIN → ROLE_ADMIN
        populator.setConvertToUpperCase(true);
        return populator;
    }

    /**
     * Bind 认证器（Bind Authenticator）。
     *
     * 作用：负责在 LDAP 服务器上验证用户密码是否正确。
     *
     * "Bind" 是 LDAP 协议中的认证操作，可以理解为"绑定到某个身份"。
     * 工作原理：
     * 1. 先通过 userSearch 找到用户条目的完整 DN
     * 2. 用这个 DN + 用户输入的密码，向 LDAP 服务器发起 Bind 请求
     * 3. LDAP 服务器返回"成功"或"失败"
     *
     * 这就是 CISSP 中常说的"直接认证"——密码不是存储在应用本地，而是由 LDAP 服务器验证。
     *
     * FilterBasedLdapUserSearch 参数解释：
     * - "ou=users"：在哪个节点下搜索用户（用户条目的上级 OU）
     * - "(uid={0})"：搜索过滤器，{0} 会被替换为用户名
     *   比如用户输入 "zhangsan"，实际执行的搜索就是 (uid=zhangsan)
     * - contextSource：连接 LDAP 的通道（使用查询账号 cn=admin 来执行搜索）
     */
    @Bean
    public BindAuthenticator bindAuthenticator() {
        FilterBasedLdapUserSearch userSearch =
                new FilterBasedLdapUserSearch("ou=users", "(uid={0})", contextSource);
        BindAuthenticator authenticator = new BindAuthenticator(contextSource);
        authenticator.setUserSearch(userSearch);
        return authenticator;
    }

    /**
     * LDAP 认证提供者（Authentication Provider）。
     *
     * 作用：把上面定义的"认证器"（验证密码）和"角色填充器"（加载角色）组装在一起，
     * 告诉 Spring Security"用这套 LDAP 逻辑来处理认证请求"。
     *
     * Spring Security 的认证流程中可以有多个 Provider（比如 LDAP + 数据库），
     * 这里我们只注册一个 LDAP Provider，表示"所有认证都走 LDAP"。
     */
    @Bean
    public LdapAuthenticationProvider ldapAuthenticationProvider(
            BindAuthenticator bindAuthenticator,
            LdapAuthoritiesPopulator authoritiesPopulator) {
        return new LdapAuthenticationProvider(bindAuthenticator, authoritiesPopulator);
    }

    /**
     * 安全过滤链（Security Filter Chain）。
     *
     * 这是 Spring Security 的核心配置，定义了"什么 URL 需要什么权限"。
     *
     * Spring Security 通过一系列 Filter（过滤器）拦截 HTTP 请求，按顺序执行：
     * 检查 CSRF → 检查登录状态 → 验证凭据 → 加载角色 → 检查权限 → 放行
     *
     * 这个方法定义的就是最后一环"检查权限"的规则。
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 关闭 CSRF 保护。REST API 通常不需要 CSRF（因为没有 Cookie 中的 session 依赖），
                // 关闭后可避免 POST/PUT 请求被 403 拒绝
                .csrf(csrf -> csrf.disable())
                // 定义 URL 级别的访问规则（按书写顺序匹配，第一条命中即停止）
                .authorizeHttpRequests(auth -> auth
                        // /api/admin 接口要求用户必须有 ROLE_ADMIN 角色
                        .requestMatchers("/api/admin").hasRole("ADMIN")
                        // /api/dev 接口要求用户必须有 ROLE_DEV 角色
                        .requestMatchers("/api/dev").hasRole("DEV")
                        // /api/public 只要认证成功（任意认证用户）即可访问
                        .requestMatchers("/api/public").authenticated()
                        // 其他所有接口都要求认证（兜底规则）
                        .anyRequest().authenticated()
                )
                // 开启表单登录：浏览器访问受保护接口时，Spring Security 会自动展示一个登录页面
                .formLogin(form -> form.permitAll())
                // 开启 HTTP Basic 认证：允许通过 Authorization 请求头传递用户名密码（适合 curl/Postman 测试）
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }
}
