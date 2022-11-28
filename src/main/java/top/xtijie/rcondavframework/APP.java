package top.xtijie.rcondavframework;

import nl.vv32.rcon.Rcon;
import top.xtijie.rcondavframework.core.console.Console;
import top.xtijie.rcondavframework.core.console.impl.DefaultConsole;
import top.xtijie.rcondavframework.core.console.manager.impl.CacheConsoleManager;
import top.xtijie.rcondavframework.rcon.SimpleRconSource;
import top.xtijie.rcondavframework.utils.ConsoleBuilder;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class APP {
    public static void main(String[] args) throws Exception {

        ConsoleBuilder.build(new CacheConsoleManager(),
                new SimpleRconSource("124.221.224.42", 25575, "Xw_1790063649").open());

        DefaultConsole console = Console.open(DefaultConsole.class);

        String x = console.sendCommand("list");

        System.out.println("/////////////////////////");
        System.out.println(x);
        System.out.println("/////////////////////////");

    }
}
