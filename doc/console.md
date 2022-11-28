# 自定义Console

**Console的作用：**

主要负责通过Rcon执行minecraft的指令，其抽象父类为AbstractConsole

示例：

```java
public class AuthmeConsole extends AbstractConsole {

    /**
     * 发送指令的方法
     */
    @Check(reCla = DiscolorCodeReturnCheck.class)
    public String sendCommand(@Check String command) throws IOException {
        // rcon是父类AbstractConsole中提供的成员变量,当然也可以使用自定义的对象
        return rcon.sendCommand(command);
    }

    /**
     * 自定义Console初始化方法
     */
    @Override
    protected void init() {
        super.init();
    }

    /**
     * 自定义Console注销方法
     */
    @Override
    protected void destroy() {
        super.destroy();
    }
}
```

每一个重写了AbstractConsole的子类都可以使用父类提供的Rcon对象进行发送指令的操作

其中Console的生命周期为：创建->构建代理对象->初始化->执行->销毁

根据使用的Console管理器的不同，Console的生命周期可能会有所区别