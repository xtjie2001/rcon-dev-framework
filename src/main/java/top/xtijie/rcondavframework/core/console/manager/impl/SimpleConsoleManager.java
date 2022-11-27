package top.xtijie.rcondavframework.core.console.manager.impl;

import top.xtijie.rcondavframework.core.console.AbstractConsole;
import top.xtijie.rcondavframework.core.console.manager.ConsoleManager;

public class SimpleConsoleManager implements ConsoleManager {

    @Override
    public <T extends AbstractConsole> T initConsole(Class<T> tClass, T t) throws Exception {
        return t;
    }

    @Override
    public <T extends AbstractConsole> void destroyConsole(Class<T> consoleClass, T t) throws Exception {

    }

    @Override
    public <T extends AbstractConsole> T getConsole(Class<T> consoleClass) throws Exception {
        return consoleClass.getConstructor().newInstance();
    }
}
