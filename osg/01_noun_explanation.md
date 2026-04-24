
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

# 第1章 实现安全治理的原则和策略

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

# 第2章 人员安全和风险管理的概念

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
> 通常，联邦机构基于 NIST SP 800-53 Rev 5 "信息系统和组织的安全和隐私控制" 实施 SCA 流程。然而，虽然 SCA 被定义为一个**政府流程**，但对于每个致力于维持成功的安全成果的组织来说，评估安全控制的可靠性和有效性的概念都应该被采纳。

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

NIST: 美国国家标准与技术研究院

# 第3章 业务连续性计划

BCP: business continuity plan, 业务连续性计划

DRP: disaster recovery plan, 灾难恢复计划

BIA: business impact analysis, 业务影响分析

MTD: maximum tolerable downtime, 最大允许中断时间

MTO: maximum tolerable outage, 最大容忍中断时间

MTD 两者等价 MTO

RTO: recovery time objective, 恢复时间目标

RPO: recovery point objective, 恢复点目标

SOC: service organization control, 服务组织控制

> 第三方审计公司可按 SOC 报告的形式提供评估结果, 参见 第 15 章 ”第三方审计“

USGS：美国地质勘探局

FEMA: 美国联邦应急管理署

Flood Factor：洪水因子

COOP：连续运营计划

# 第4章 法律、法规和合规

CFR: Code of Federal Regulations, 美国联邦法规

GDPR: General Data Protection Regulation, 通用数据保护条例

CFAA: 计算机欺诈和滥用法案

FISMA: 联邦信息安全管理管理法案

NIST: 美国国家标准与技术研究院

NIST SP 800-53: 联邦信息系统和组织的安全和隐私控制

NIST SP 800-171: 保护非联邦信息系统和组织中的受控的非分类信息

NIST CSF: 网络安全框架

IP: 知识产权

DMCA: 数字千年版权法

ITAR: 国际武器贸易条例

USML: 美国军需品清单

EAR: 出口管理条例

CCL: 美国商务部维护的商务控制清单

ECPA: 电子通信隐私法案

CALEA: 通信执法协助案

HIPAA: 《健康保险流通与责任法案》

HMO: 医疗保险和健康维护组织

HITECH: 健康信息技术促进经济和临床健康法案

BAA: 商业伙伴协议

COPPA: 《儿童在线隐私保护法》

GLBA: Gramm-Leach-Bliley 法案

DPD: Data Protection Directive, 欧盟数据保护指令

PIPEDA: 个人信息保护和电子文件法, 加拿大隐私法

CCPA: 加州消费者隐私法案

PCI DSS: 付卡行业数据安全标准

# 第 5 章 保护资产安全

PHI: protected health information, 受保护的健康信息

FOIA: 信息自由法

FOUO: for official use only, 仅用于官方用途

SBU: sensitive but unclassified, 敏感但未分类

ITRC: 身份盗取中心，定期跟踪数据泄露事件

HVAC: heating, ventilation, and air conditioning, 供暖、通风和空调系统系统

数据销毁方法:
- erasing
- clearing
- purging
- degaussing
- destruction

declassification: 解除分类

DRM: digital rights management, 数字版权管理

CASB: cloud access security broker, 云访问安全代理

DH: 部门主管

AUP: Acceptable Use Policy, 可接受使用策略

custodian: 数据托管员

# 第 6 章 密码学和对称密钥算法

symmetirc cryptosystem

asymmetric cryptosystem

- data at rest
- data in motion
- data in use

Kerchhoffs's principle: 只要密钥，那么即便有关密码系统的一切都是公开的，密码系统仍然是安全的。

nonce

zero-knowledge proof

split knowledge

key escrow: 密钥托管

work funciton: 代价函数

transposition cipher 移位密码

columnar transposition 列移位

substituion cipher 替换密码

Caesar cipher 凯撒密码

frequency analysis 频率分析

one-time pad 单次密本，也叫 Vernam 密码

running key cipher, 运动密钥密码，也叫 book cipher

block cipher

stream cipher

confussion,diffusion: 密码算法2种基本运算

密码运行模式
- ECB: electronic codebook, 电子密码本
- CBC: cipher block chaining, 密码块链接
- CFB: cipher feedback, 密码反馈
- OFB: output feedback, 输出反馈
- CTR: counter, 计数器
- GCM: Galois/Counter Mode, Galois/计数器模式
- CCM: 带密码块链接消息验证码的计数器模式

PGP: Pretty Good Privacy

Blowfish

FIPS: 联邦信息处理标注

EES: FIPS 185 托管加密标准

Skipjack, Clipper: 不受密码界欢迎 

RSA: Rivest-Shamir-Adleman


# 第 15 章

DAST: dynamic application security testing, 动态应用安全测试

# 第 16 章

CAB: change advisory board, 变更咨询委员会