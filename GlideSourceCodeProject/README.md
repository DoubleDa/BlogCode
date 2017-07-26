## 说明文档



### 策略模式

[策略模式](https://github.com/simple-android-framework/android_design_patterns_analysis/tree/master/strategy/gkerison)的使用

### Builder模式

[Builder模式](https://github.com/DoubleDa/android_design_patterns_analysis/tree/master/builder/mr.simple)的使用

- 为什么要使用Builder模式？
- 创建对象与直接使用new关键字有什么差别？

### 适配器模式

[适配器模式](https://github.com/simple-android-framework-exchange/android_design_patterns_analysis/blob/master/adapter/mr.simple/readme.md)的使用

220V电压-->5V电压

### 装饰模式

[装饰模式]()的使用

### 模版方法模式

[模版方法模式](https://github.com/simple-android-framework/android_design_patterns_analysis/tree/master/template-method/mr.simple)的使用

执行结果：

```json
***start***
---进入考场---
---签到---
---需要领取计算器&尺子---
---完成答题---
---走出考场---
***end***
***start***
---进入考场---
---签到---
---需要领取听力耳机---
---完成答题---
---走出考场---
***end***
```
### 观察者模式

- 定义对象间的一种一对多的依赖关系,当一个对象的状态发生改变时,所有依赖于它的对象都得到通知并被自动更新。

适用性：

- 当一个抽象模型有两个方面,其中一个方面依赖于另一方面。将这二者封装成独立的对象中以使它们可以各自独立地改变和复用。
- 当对一个对象的改变需要同时改变其它对象,而不知道具体需要多少对象有待改变。
- 当一个对象必须通知其它对象，而它又不能假定其它对象是谁。

参与者：

- **Subject(目标)** 目标知道它的观察者。可以有任意多个观察者观察同一个目标。 提供注册和删除观察者对象的接口。
- **Observer(观察者)** 为那些在目标发生改变时需获得已知的对象定义一个更新接口。
- **ConcreteSubject(具体目标)** 将有关状态存入各ConcreteObserver对象。当它的状态发生改变时,向它的各个观察者发出通知。
- **ConcreteObserver(具体观察者)** 维护一个指向ConcreteSubject对象的引用。 存储有关状态，这些状态应与目标的状态保持一致。实现Observer的更新接口即使自身状态与目标的状态保持一致。

### 责任链模式

使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。将这些对象连成一责任链，并沿着这条链传递该请求，直到有一个对象处理它为止。
这一模式的想法是，给多个对象处理一个请求的机会，从而解耦发送者和接受者.

适用性：

- 有多个的对象可以处理一个请求，哪个对象处理该请求运行时刻自动确定
- 你在不明确指定接收者的情况下，向多个对象中的一个提交一个请求
- 可处理一个请求的对象集合应被动态指定

参与者：

- Handler 定义一个处理请求的接口。 (可选)实现后继链
- ConcreteHandler 处理它所负责的请求。可访问它的后继者。如果可处理该请求，就处理它；否则将该请求转发给它的后继者
- Client 向链上的具体处理者(ConcreteHandler)对象提交请求

