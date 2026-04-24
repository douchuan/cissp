
OSG 第 9 版书籍名词&缩写整理


CISSP: Certified Information Systems Security Professional
> 网络安全领域金牌认证，ISC<sup>2</sup> 1994年开始逐步推广
> CISSP 认证与 2013 年正式引入中国大陆，2014 年启用中文认证考试。
> CISSP 认证是掌握网络安全领域知识的黄金标注，它可向雇主证明，你在广泛的网络安全学科领域拥有丰富的知识和技能，并有能力构建和管理
> 组织安全运营的绝大部分内容

OSG: Official Study Guide

(ISC)<sup>2</sup>: 国际信息系统安全认证联盟
> 成立于 1989 年, 是全球最大的网络、信息、软件与基础设施安全认证会员制非营利组织。

CISSP-CAT: 计算机化自适应考试

## 第1章 实现安全治理的原则和策略

CIA: Confidentiality, Integrity, Availability

DAD: disclosure, alteration, destruction

AAA: Authentication, Authorization, and Accounting

CEO: Chief Executive Officer, 首席执行官

CISO: Chief Information Security Officer, 首席信息安全官

ISO: 信息安全官

CIO: Chief Information Officer, 首席信息官

CSO: Chief Security Officer, 首席安全官

> CSO 有时等同于 CISO，不过在很多组织中，CSO 是 CISO 的下属。
> 另一个可能替代 CISO 的术语是 ISO，但 ISO 也可以是 CISO 的下属 

ATO: 操作授权

ROI: Return on Investment, 投资回报率

AICPA: 美国注册会计师协会

SLA: Service Level Agreement, 服务等级协议

SLR: 服务级别需求

> 在使用外部服务时，一定要检查 SLA，确保服务合同中包含有关安全的规定

CIRT: Computer Incident Response Team, 计算机事件响应小组

COBIT: 信息和相关技术控制目标

NIST SP 800-53 Rev 5: 信息系统和组织的安全和隐私控制，包含了美国政府为组织安全提供的通用性建议

CIS: 互联网安全中心, 提供针对操作系统、应用程序和硬件的安全配置指引

RMF: NIST 风险管理框架, 对联邦机构制定了强制性要求

CSF: NIST 网络安全框架

ISO/IEC 27000, 国际标准，可作为实施组织信息安全及相关管理实践的基础

ITIL: Information Technology Infrastructure Library, 信息技术基础设施库, 最初英国政府制定，是一套被推荐的优化 IT 服务以支持业务增长、转型和变革的最佳实践

due diligence: 尽职审查

due care: 应尽关心

SOP: Standard Operating Procedure, 标准操作程序

SDL: 安全开发生命周期

SD3+C

> 微软使用 SDL 过程在产品开发的每个阶段考虑和实现安全。这种做法支持 “设计安全，默认安全，部署和通信安全” 的座右铭，也被称为 SD3+C

STRIDE
- Spoofing, 欺骗
- Tampering， 篡改
- Repudiation，否认
- Information Disclosure，信息泄露
- DoS， 拒绝服务
- Elevation of Privilege，特权提升

PASTA: Process for Attack Simulation and Threat Analysis

VAST: Visual, Agile, and Simple Threat

SCRM: 供应链风险管理

## 第2章 人员安全和风险管理的概念

job responsibilities: 岗位职责

IAM: identity and access management, 身份和访问管理

NDA: non-disclosure agreement, 保密协议

collusio: 串通

VMS: 供应商管理系统

PII: personally identifiable information, 个人身份信息

PCI DSS: Payment Card Industry Data Security Standard, 支付卡行业数据安全标准

HIPAA: Health Insurance Portability and Accountability Act, 《健康保险流通与责任法案》

SOX: Sarbanes-Oxley Act, 《萨班纳斯-奥克斯利法案》

FERPA: Family Educational Rights and Privacy Act,《家庭教育权利和隐私法案》

GDPR: General Data Protection Regulation, 通用数据保护条例

Delphi: Delphi 技术是一个匿名的反馈和响应过程

AV: asset value, 资产价值

EF: exposure factor 暴露因子

SLE: single loss expectancy, 单一损失期望值

ARO: annualized rate of occurrence, 年度发生率

ALE: annualized loss expectancy, 年度损失期望

ACS: annualized cost of safeguard, 年度成本

DLP: Data Loss Prevention, 数据丢失预防

IPS: Intrusion Prevention System, 入侵预防系统

IDS: Intrusion Detection System, 入侵检测系统

DRP: 灾难恢复计划

SCA: security controls assessment, 安全控制评估

RMM: risk maturity model, 风险成熟度模型

ERM: enterprise risk management, 企业风险管理

EOL: end-of-life, 生产期终止

EOS: end-of-support, 支持终止

EOSL: end-of-service life, 服务期终止

OCTAVE: Operationally Critical Threat, Asset and Vulnerability Evaluation, 可操作的关键威胁、资产和脆弱性评估

FAIR: Factor Analysis of Information Risk, 信息风险因素分析

TARA: Threat Agent Risk Assessment, 威胁代理风险评估

BHO: 浏览器辅助对象

spear phishing: 鱼叉式网络钓鱼

BEC: Business Email Compromise, 商业电子邮件泄露

whaling: 网络钓鲸，针对高级管理人员

smishing: 短信钓鱼

vishing: 语音钓鱼

SpIT: 互联网电话垃圾邮件

VoIP: IP 语音

spam: 垃圾邮件

SPF: Sender Policy Framework, 发送者策略框架

DKIM: DomainKeys Identified Mail, 域密钥识别邮件

DMARC: 域消息身份认证报告和一致性，可用于过滤虚假消息

USENET: 网络新闻传输协议

shoulder surfing: 肩窥

hoax: 恶作剧

impersonation: 假冒

masquerading: 伪装

tailgating: 尾随

piggybacking: 捎带

dumpster diving: 垃圾箱搜寻

identity fraud: 身份欺诈

typo squatting: 误植域名

SEO: 搜索引擎优化

influence campaign: 影响力运动

Doxing: 收集有关个人或组织的信息，以便公开披露收集的数据

hybrid warfare: 混合战争

social media: 社交媒体

AUP: Acceptable Use Policy, 可接受使用政策

CBT: 基于计算机的培训

ROSI: 安全投资回报



