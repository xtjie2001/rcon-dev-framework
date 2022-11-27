package top.xtijie.rcondavframework;

import top.xtijie.rcondavframework.core.console.Console;
import top.xtijie.rcondavframework.core.console.impl.DefaultConsole;
import top.xtijie.rcondavframework.core.console.manager.impl.CacheConsoleManager;
import top.xtijie.rcondavframework.rcon.SimpleRconSource;
import top.xtijie.rcondavframework.utils.ConsoleBuilder;

import java.io.IOException;

public class APP {
    public static void main(String[] args) {

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

    }
}
