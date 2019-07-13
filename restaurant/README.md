46restaurant
=

### 介绍
MISP：西餐厅

### 软件架构
软件架构说明
* 开发工具 idea vscode
* 开发环境 jdk8 + mysql5.7
* 框架 spring boot2 + mybatis

---
### 迭代一
* 构建核心架构
> #### 要求 
> 三项数据的增删改查
> * 分析员： 迭代一需求（字段）
> * 架构师： 数据库（迭代一）、开发规范与命名规则
> * 程序员： 数据项或前端的开发
> * 测试员（项目经理）： 测试报告、2000分配

#### 命名规则
1. 代码中的命名均不能以下划线或美元符号开始，也不能以下划线或美元符号结束。
反例： _name / __name / $name / name_ / name$ / name__

2. 代码中的命名严禁使用拼音与英文混合的方式，更不允许直接使用中文的方式。
说明：正确的英文拼写和语法可以让阅读者易于理解，避免歧义。注意，即使纯拼音命名方式
也要避免采用。
正例： alibaba / taobao / youku / hangzhou 等国际通用的名称，可视同英文。
反例： DaZhePromotion [ 打折 ] / getPingfenByName() [ 评分 ] / int 某变量 = 3

3. 类名使用 UpperCamelCase 风格，但以下情形例外： DO / BO / DTO / VO / AO /
PO / UID 等。
正例： MarcoPolo / UserDO / XmlService / TcpUdpDeal / TaPromotion
反例： macroPolo / UserDo / XMLService / TCPUDPDeal / TAPromotion

4. 方法名、参数名、成员变量、局部变量都统一使用 lowerCamelCase 风格，必须遵从
驼峰形式。
正例： localValue / getHttpMessage() / inputUserId

5. 常量命名全部大写，单词间用下划线隔开，力求语义表达完整清楚，不要嫌名字长。
正例： MAX _ STOCK _ COUNT
反例： MAX _ COUNT

6. 抽象类命名使用 Abstract 或 Base 开头 ； 异常类命名使用 Exception 结尾 ； 测试类
命名以它要测试的类的名称开始，以 Test 结尾。

7. 类型与中括号紧挨相连来表示数组。
正例：定义整形数组 int[] arrayDemo;
反例：在 main 参数中，使用 String args[]来定义。

8. POJO 类中布尔类型的变量，都不要加 is 前缀 ，否则部分框架解析会引起序列化错误。
反例：定义为基本数据类型 Boolean isDeleted 的属性，它的方法也是 isDeleted() ， RPC
框架在反向解析的时候，“误以为”对应的属性名称是 deleted ，导致属性获取不到，进而抛
出异常。

9. 包名统一使用小写，点分隔符之间有且仅有一个自然语义的英语单词。包名统一使用
单数形式，但是类名如果有复数含义，类名可以使用复数形式。
正例：应用工具类包名为 com . alibaba . ai . util 、类名为 MessageUtils（ 此规则参考 spring
的框架结构 ）

10. 杜绝完全不规范的缩写，避免望文不知义。
反例： AbstractClass “缩写”命名成 AbsClass；condition “缩写”命名成 condi ，此类随
意缩写严重降低了代码的可阅读性。

11. 为了达到代码自解释的目标，任何自定义编程元素在命名时，使用尽量完整的单词
组合来表达其意。
正例：在 JDK 中，表达原子更新的类名为：AtomicReferenceFieldUpdater。
反例：变量 int a 的随意命名方式。

12. 如果模块、接口、类、方法使用了设计模式，在命名时需体现出具体模式。
说明：将设计模式体现在名字中，有利于阅读者快速理解架构设计理念。
正例： public class OrderFactory;
public class LoginProxy;
public class ResourceObserver;

13. 接口类中的方法和属性不要加任何修饰符号 （public 也不要加 ） ，保持代码的简洁
性，并加上有效的 Javadoc 注释。尽量不要在接口里定义变量，如果一定要定义变量，肯定是
与接口方法相关，并且是整个应用的基础常量。
正例：接口方法签名 void commit();
接口基础常量 String COMPANY = " alibaba " ;
反例：接口方法定义 public abstract void f();
说明： JDK 8 中接口允许有默认实现，那么这个 default 方法，是对所有实现类都有价值的默
认实现。

14. 接口和实现类的命名有两套规则：
  对于 Service 和 DAO 类，基于 SOA 的理念，暴露出来的服务一定是接口，内部
的实现类用 Impl 的后缀与接口区别。
正例： CacheServiceImpl 实现 CacheService 接口。
  如果是形容能力的接口名称，取对应的形容词为接口名 （ 通常是– able 的形式 ） 。
正例： AbstractTranslator 实现 Translatable 接口 。

15. 枚举类名建议带上 Enum 后缀，枚举成员名称需要全大写，单词间用下划线隔开。
说明：枚举其实就是特殊的类，域成员均为常量，且构造方法被默认强制是私有。
正例：枚举名字为 ProcessStatusEnum 的 成员名称： SUCCESS / UNKNOWN _ REASON 。

16. 各层命名规约：
* Service / DAO 层方法命名规约
> 1. 获取单个对象的方法用 get 做前缀。
> 2. 获取多个对象的方法用 list 做前缀，复数形式结尾如：listObjects。
> 3. 获取统计值的方法用 count 做前缀。
> 4. 插入的方法用 save/insert 做前缀。
> 5. 删除的方法用 remove/delete 做前缀。
> 6. 修改的方法用 update 做前缀。
* 领域模型命名规约
> 1. 数据对象： xxxDO ， xxx 即为数据表名。
> 2. 数据传输对象： xxxDTO ， xxx 为业务领域相关的名称。
> 3. 展示对象： xxxVO ， xxx 一般为网页名称。
> 4. POJO 是 DO / DTO / BO / VO 的统称，禁止命名成 xxxPOJO 。
    
