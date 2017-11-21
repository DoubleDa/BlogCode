# MVP、RxJava、Retrofit、Glide、Dagger2实战

## 创建数据源

```java
//1、安装json-server
npm install -g json-server
//2、在指定目录创建db.json文件
cd JsonServer/
touch db.json
//3、运行创建的db.json
json-server -w login.json -p 3003
```

db.json代码如下：

```java
{
    "login": {
        "status_msg": "登录成功",
        "status_code": 200,
        "data": {
            "username": "dayongxin",
            "id": 1,
            "password": "123456",
            "gender": "男"
        }
    }
}
```

## 技术栈优点

- 解耦，降低模块耦合度
- 可以更方便的写单元测试
- 减少Activity编码
- 提高团队协作的效率
- 提高编码的效率
- 提高代码的可读性