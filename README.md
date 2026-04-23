# CISSP 考试实战案例集

本项目为 **CISSP 认证考试** 准备，通过可运行的实际项目场景，将 CISSP 知识域中的关键概念具象化。

## 目标

CISSP 考试强调对安全概念的理解和场景化应用能力。本项目通过真实可运行的工程实践，将抽象的理论知识转化为可观察、可操作、可验证的具体案例，帮助加深理解并提升场景分析能力。

## 当前案例

### LDAP 身份认证与访问控制（[ldap_demo/](ldap_demo/)）

**关联 CISSP 知识域：**

- Domain 5: 身份和访问管理 (IAM)

**演示的关键概念：**

| CISSP 概念 | 项目中的体现 |
|-----------|------------|
| 身份（Identity） | LDAP 中的用户条目（uid, cn, mail） |
| 认证（Authentication） | LDAP Bind 操作验证凭据（用户名+密码） |
| 授权（Authorization） | 基于组的角色映射（admin/dev → ROLE_ADMIN/ROLE_DEV） |
| 访问控制模型（RBAC） | Spring Security 注解 `@PreAuthorize` 实现基于角色的接口级权限 |
| 最小权限原则（Least Privilege） | LDAP 查询账号仅授予只读搜索权限 |
| 目录服务（Directory Service） | OpenLDAP DIT 层级结构（dc → ou → uid/cn） |
| 认证流程 | 先搜索定位 DN，再 Bind 验证凭据的两步流程 |