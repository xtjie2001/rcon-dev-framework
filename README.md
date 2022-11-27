# rcon-dev-framework

## 简介

### Rcon

Rcon是一种协议,是被Source专用服务器使用的一个基于[TCP/IP协议](https://baike.baidu.com/item/TCP%2FIP协议/212915?fromModule=lemma_inlink)的通信协议,可以通过rcon向服务器发送控制台命令,rcon的作用最常见的用法是让服主在不接触服务器的情况下控制自己的[游戏服务器](https://baike.baidu.com/item/游戏服务器/4920614?fromModule=lemma_inlink).为了让命令能被接受，建立的连接必须先通过服务器的rcon密码验证.

来源：[RCON_百度百科 (baidu.com)](https://baike.baidu.com/item/RCON/23218655)

### 设计目的

帮助简化Rcon在Java应用程序中的开发，当然它可以不只用于Rcon，类似于Rcon之类的其他应用程序也可以通过此框架进行开发

在此非常感谢jobfeikens和jenrik为此项目提供的依赖：rcon，这是他们的仓库地址：[jobfeikens/rcon](https://github.com/jobfeikens/rcon)

### 此框架的作用

此框架主要提供了方法参数以及返回值的检查于修改，同时配备了对象的创建与管理的功能

其中，对象的管理方式，返回值及参数的检查与修改逻辑全都可以自定义，按照自己的需求进行开发



## 入门

### 安装(Java 11+)

要使用 MyBatis， 只需将[top.xtijie.rcondevframework-x.x.x.jar]()文件置于类路径（classpath）中即可。

如果使用 Maven 来构建项目，则需将下面的依赖代码置于 pom.xml 文件中：

```xml
<dependency>
    <groupId>top.xtijie.rcondevframework</groupId>
    <artifactId>rcon-dev-framework</artifactId>
    <version>x.x.x</version>
</dependency>
```

### 快速上手

```java
try {
    // 构建控制
    ConsoleBuilder.build(new CacheConsoleManager(),
            new SimpleRconSource("hostname", 25575, "password").open());
    // 打开控制台
    DefaultConsole console = Console.open(DefaultConsole.class);
    // 发送指令
    String s = console.sendCommand("help");
    // 输出返回
    System.out.println(s);

} catch (Exception e) {
    e.printStackTrace();
}
```

ConsoleBuilder.build(ConsoleManager manager, RconSource rconSource);

- 作用：方法主要负责初始化Console容器，为后续操作提供初始化对象
- 参数：
  - ConsoleManager manager：指定Console管理器对象，此类对象将用于负责管理Console对象，不同的ConsoleManager所用的管理Console的方式不一样，此处`new CacheConsoleManager()`管理器名为缓存Console管理器，其自带缓存功能，所有通过`Console.open()`方法创建的对象在此管理器中都将会被创建一次缓存
  - RconSource rconSource：指定Rcon连接源，本框架中自带一种连接源：`SimpleRconSource`其中自带三个参数，分别是：主机地址、服务器端口和rcon密码，最后的`.open()`是为了与Minecraft服务器进行连接

------

Console.open(Class\<T extends AbstractConsole\> conClass);

- 作用：打开自定义的Console类，框架中也自带了一个DefaultConsole控制器类
- 参数：
  - Class\<T extends AbstractConsole\> conClass：指定自定义的Console类型，要求尽量使用XxxConsole.class的方式加载，不要使用对象获取Class对象的方式，否则会出现不可预料的报错
