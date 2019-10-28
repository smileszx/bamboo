# 异常

## 异常分类
JDK定义了一套完整的异常机制。

Throwable： 所有异常的父类

- Error 致命异常

系统发生不可控错误，如StackOverflowError、OutOfMemoryError，需要人工介入处理。

- Exception 非致命异常

**checked异常**

常见的checked异常，SQLException、ClassNotFoundException

checked异常细分2类：
- 无能为力、引起注意型。
举例：如字段超长导致SQLException，即使重试再多次也没有任何帮助，此类异常需要完整的保存异常现场，
供开发人员介入解决。

- 力所能及、坦然处置型。
如发生未授权异常（UnAuthorizedException），程序可以跳转至权限申请页面。


**unchecked异常**
运行时异常，都继承自RuntimeException，不需要程序进行显示捕捉和处理

unchecked异常细分为3类：
- 可预测异常
常见的可预测异常包括IndexOutOfBoundsException、NullPointerException等，基于对代码性能和稳定性要求，
此类异常不应该被产生或者抛出，需要提前做好边界检查、空指针判断等

- 需捕捉异常
如Dubbo框架进行RPC调用时产生的远程服务超时异常DubboTimeoutException，此类异常必须显示处理，
不能因服务端的异常导致客户端不可用，此时可以重试或者降级处理。

- 可透出异常
主要指框架或系统产生的且可以自行处理的异常，程序无需关心，如Spring框架抛出NoSuchRequestHandlingMethodException异常
Spring框架可以完成异常处理，默认将自身抛出的异常自动映射给合适的状态码。

## throw和throws区别
异常处理原则：
严禁捕获异常后什么都不做或打印一行日志了事。

 异常在当前方法处理能力范围内且没有必要对外透出，那么就直接捕获异常并做相应处理
 
 超出异常处理能力，向上抛出，由上层方法或者框架处理。

- throw
方法内部抛出具体异常类对象的关键字

- throws
用在方法signature上，表示方法调用者可通过此方法声明向上抛出异常对象。

