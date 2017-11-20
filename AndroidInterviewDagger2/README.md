# 使用Dagger2

## 添加依赖

- 在Project级别的build.gradle中添加以下代码：

```java
classpath 'com.neenbedankt.gradle.plugins:android-apt:1.8'
```

- 在Application级别的build.gradle中添加以下代码：

```java
apply plugin: 'com.neenbedankt.android-apt'

compile 'com.google.dagger:dagger:2.7'
apt 'com.google.dagger:dagger-compiler:2.7'
```

## Dagger2注解方法详解

### @Inject和@Component

- @Inject

用于标记需要注入的依赖，Inject有两种注入方式：成员变量注入和构造方法注入

- @Component

完成依赖注入，需要定义一个接口，接口命名建议为：目标类名+Component，在编译后Dagger2会生成Dagger+目标类名+Component的辅助类

### @Module和@Provides

- @Module

标注在类上，用来告诉Component可以从这个类中获取依赖对象

- @Provides

标注在方法上，表示可以通过这个方法来获取依赖对象的实例

### @Named和@Qualifier

- @Named

是@Qualifier的一种实现

- @Qualifier

限定符，可以用于自定义属性

### @Singleton和@Scope

- @Singleton

用来配合实现局部单例和全局单例

- @Scope

用来自定义注解

### @Component的dependencies

依赖其它Component

### 懒加载

```java
@Inject
Lazy<FootBaller> footBallerLazy;
```

懒加载模式，在@Inject的时候不初始化，而是在使用的时候才进行