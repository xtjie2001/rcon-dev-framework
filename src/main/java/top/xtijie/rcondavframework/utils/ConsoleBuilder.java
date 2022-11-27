package top.xtijie.rcondavframework.utils;

import nl.vv32.rcon.Rcon;
import top.xtijie.rcondavframework.core.console.manager.ConsoleManager;
import top.xtijie.rcondavframework.core.console.manager.impl.CacheConsoleManager;
import top.xtijie.rcondavframework.core.enhancer.ConsoleEnhancer;
import top.xtijie.rcondavframework.core.enhancer.MethodEnhancer;
import top.xtijie.rcondavframework.core.enhancer.check.pe.ParameterCheckLoader;
import top.xtijie.rcondavframework.core.enhancer.check.re.ReturnCheckLoader;
import top.xtijie.rcondavframework.rcon.RconSource;

import java.io.IOException;

public abstract class ConsoleBuilder {


    public static void build(ConsoleManager manager, RconSource rconSource) throws IOException {

        RconDepository.deposit(Rcon.class, rconSource.getRcon());

        RconDepository.deposit(ConsoleManager.class, manager);

        RconDepository.deposit(ParameterCheckLoader.class, new ParameterCheckLoader());

        RconDepository.deposit(ReturnCheckLoader.class, new ReturnCheckLoader());

        RconDepository.deposit(ConsoleEnhancer.class, new MethodEnhancer());
    }
}
