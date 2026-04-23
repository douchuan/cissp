# LDAP 核心属性类型速记文档
## 一、基础概念
- **Attribute Type（属性类型）**：LDAP 中的“字段名/键名”，如 `cn`、`ou`、`dc`
- **RDN（Relative Distinguished Name）**：目录树的单个节点，格式：`属性=值`
- **DN（Distinguished Name）**：完整路径，唯一标识一个对象，多个 RDN 用逗号分隔

---

## 二、最常用 4 种属性（必背）
| 属性 | 全称 | 含义 | 用途 | 层级位置 |
|------|------|------|------|----------|
| **dc** | Domain Component | 域组件 | 对应域名拆分，如 `example.com` | **顶层**，根节点 |
| **ou** | Organizational Unit | 组织单元 | 部门、分组、目录容器 | 中间层 |
| **cn** | Common Name | 通用名称 | 用户、管理员、组、服务等具体对象 | 叶子节点居多 |
| **uid** | User ID | 用户账号 | Unix/Linux 风格用户标识 | 叶子节点 |

---

## 三、其他常见属性（了解即可）
| 属性 | 全称 | 含义 |
|------|------|------|
| sn | Surname | 姓 |
| givenName | Given Name | 名 |
| mail | Email | 邮箱地址 |
| userPassword | User Password | 密码 |
| o | Organization | 机构/公司 |
| c | Country | 国家（如 CN） |
| st | State/Province | 省份 |
| l | Location | 城市 |


## 四、层级从属规范（约定俗成）
```
dc=com
└── dc=example
    ├── ou=users
    │   └── cn=张三 / uid=zhangsan
    ├── ou=groups
    └── cn=admin
```

**固定顺序：**
**dc（顶层） → ou（中间容器） → cn / uid（具体对象）**