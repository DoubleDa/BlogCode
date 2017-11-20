# 错误类型

- java.lang.IllegalArgumentException: Service Intent must be explicit: Intent { act=com.dyx.ais.service1.MY_SERVICE1 }

问题代码：
```java
final Intent intent = new Intent();
intent.setAction("com.dyx.ais.service1.MY_SERVICE1");
```

正确代码：
```java
final Intent intent = new Intent(this, MyService1.class);
intent.setAction("com.dyx.ais.service1.MY_SERVICE1");
```

- java.lang.IllegalArgumentException: Service not registered: com.dyx.ais.service1.Service2Act$1@8fafcc3

问题代码：
```java
unbindService(connection);
```

正确代码：
```java
if (isBind) {
    unbindService(connection);
    isBind = false;
}
```