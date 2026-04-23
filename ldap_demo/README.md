# LDAP 最小示例项目

本项目是一个基于 Spring Boot 的 LDAP 最小实验环境，用于演示 LDAP 核心原理及 Spring Security 角色映射实践。

## 项目目标

- 理解 LDAP 目录服务的基本原理（DIT、Entry、DN、Bind 认证流程）
- 验证"先搜索 DN，再 Bind 认证"的两步认证流程
- 演示 LDAP 组（groupOfNames）到 Spring Security Role 的映射关系
- 通过 REST API 验证基于角色的访问控制

## 环境要求

| 依赖 | 版本 |
|------|------|
| Java | 17+ |
| Maven | 3.8+ |
| Docker | 20.10+（运行 LDAP 服务器） |
| Docker Compose | 2.0+ |

## 快速启动

### 1. 启动 LDAP 服务器

```bash
docker compose up -d
```

容器启动后会自动通过 `init/init.ldif` 初始化目录数据（OU、用户、组）。等待约 5 秒让 LDAP 服务就绪：

```bash
docker logs ldap-server | grep "slapd starting"
```

### 2. 启动 Spring Boot 应用

```bash
mvn spring-boot:run
```

应用启动后监听 `8080` 端口。

### 3. 验证

```bash
# 验证 LDAP 数据是否正确加载
docker exec ldap-server ldapsearch -x -b "dc=example,dc=com" -D "cn=admin,dc=example,dc=com" -w admin "(uid=zhangsan)"

# 测试 Spring Boot 应用接口（使用 HTTP Basic Auth）
curl http://localhost:8080/api/public -u zhangsan:password123
```

## 关键配置

### 端口

| 服务 | 端口 | 说明 |
|------|------|------|
| LDAP Server | 389 | Docker 容器暴露端口，标准 LDAP 端口 |
| Spring Boot | 8080 | 应用 HTTP 端口 |

### LDAP 查询账号（Search User）

| 字段 | 值 |
|------|------|
| DN | `cn=admin,dc=example,dc=com` |
| 密码 | `admin` |
| 用途 | 用于搜索用户 DN，只读权限 |

### 测试用户

| 用户名 | 密码 | DN | 所属组 | 映射 Role |
|--------|------|-----|--------|-----------|
| `zhangsan` | `password123` | `uid=zhangsan,ou=users,dc=example,dc=com` | admin | `ROLE_ADMIN` |
| `lisi` | `password123` | `uid=lisi,ou=users,dc=example,dc=com` | dev | `ROLE_DEV` |
| `wangwu` | `password123` | `uid=wangwu,ou=users,dc=example,dc=com` | dev | `ROLE_DEV` |

## API 接口

所有接口使用 HTTP Basic Authentication，用户名/密码为 LDAP 用户凭据。

| 接口 | 方法 | 权限要求 | 说明 |
|------|------|----------|------|
| `/api/public` | GET | 任意认证用户 | 返回当前用户名和角色列表 |
| `/api/admin` | GET | `ROLE_ADMIN` | 管理员资源 |
| `/api/dev` | GET | `ROLE_DEV` | 开发者资源 |

### 测试示例

```bash
# zhangsan 查询自己的信息
curl http://localhost:8080/api/public -u zhangsan:password123
# 返回: {"user":"zhangsan","roles":["ROLE_ADMIN"]}

# zhangsan 访问管理员接口（通过）
curl -w "\n%{http_code}\n" http://localhost:8080/api/admin -u zhangsan:password123
# 200

# lisi 访问管理员接口（拒绝）
curl -w "\n%{http_code}\n" http://localhost:8080/api/admin -u lisi:password123
# 403

# 错误密码
curl -w "\n%{http_code}\n" http://localhost:8080/api/public -u zhangsan:wrongpassword
# 401
```

## 项目结构

```
├── docker-compose.yml          # LDAP 服务器容器配置
├── init/
│   └── init.ldif               # LDAP 初始数据（用户 zhangsan/lisi/wangwu、组 admin/dev）
├── pom.xml                     # Maven 项目配置
└── src/main/
    ├── java/com/example/ldap/
    │   ├── LdapDemoApplication.java   # Spring Boot 启动类
    │   ├── SecurityConfig.java        # Spring Security 配置（LDAP 认证 + 角色映射）
    │   └── TestController.java        # 测试接口
    └── resources/
        └── application.yml            # LDAP 连接配置
```

## 认证流程

```
客户端输入用户名 zhangsan + 密码 password123
    │
    ▼
① Spring Security 使用查询账号 (cn=admin) 搜索 LDAP
   base=dc=example,dc=com, filter=(uid=zhangsan)
    │
    ▼
② 获取用户 DN: uid=zhangsan,ou=users,dc=example,dc=com
    │
    ▼
③ 使用用户 DN + 密码执行 LDAP Bind 操作
    │
    ▼
④ Bind 成功后，搜索用户所属组 → cn=admin,ou=groups
    │
    ▼
⑤ 将组的 cn 属性映射为 Spring Security Role: ROLE_ADMIN
    │
    ▼
认证成功，携带 ROLE_ADMIN 进入业务接口
```

## 停止服务

```bash
docker compose down
```
