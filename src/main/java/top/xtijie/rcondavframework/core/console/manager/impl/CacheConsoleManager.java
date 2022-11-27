package top.xtijie.rcondavframework.core.console.manager.impl;

import top.xtijie.rcondavframework.core.console.AbstractConsole;
import top.xtijie.rcondavframework.core.console.manager.ConsoleManager;
import top.xtijie.rcondavframework.exception.ConsoleDestroyException;
import top.xtijie.rcondavframework.exception.ConsoleInitException;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CacheConsoleManager implements ConsoleManager {

    private static final Map<Class<? extends AbstractConsole>, AbstractConsole> consoleCache = new LinkedHashMap<>();

    /**
     * <h3>Console对象初始化方法</h3>
     *
     * @param tClass 进行初始化的Console对象
     * @param t      指定的Console对象类型
     * @throws ConsoleInitException 初始化过程中可能出现的异常
     */
    @Override
    public <T extends AbstractConsole> T initConsole(Class<T> tClass, T t) throws Exception {
        synchronized (ConsoleManager.class) {
            try {
                consoleCache.put(tClass, t);
            } catch (Exception e) {
                throw new ConsoleInitException(e);
            }
        }
        return t;
    }


    /**
     * <h3>Console注销方法</h3>
     *
     * @param consoleClass 被关闭的Console类型
     * @param t            即将被被关闭的Console实例
     * @param <T>          被注销的Console泛型
     * @throws Exception 注销过程中可能出现的异常
     */
    @Override
    public <T extends AbstractConsole> void destroyConsole(Class<T> consoleClass, T t) throws Exception {
        synchronized (ConsoleManager.class) {
            try {
                consoleCache.remove(consoleClass);
            } catch (Exception e) {
                throw new ConsoleDestroyException(e);
            }
        }
    }

    /**
     * <h3>获取Console方法</h3>
     *
     * @param consoleClass 需要的Console类型
     * @param <T>          指定是Console泛型
     * @return 获取到的Console
     * @throws Exception 获取过程中可能遇到的泛型
     */
    @Override
    public <T extends AbstractConsole> T getConsole(Class<T> consoleClass) throws Exception {
        return getConsoleFromCache(consoleClass);
    }


    /**
     * 判断缓存中是否有此Console对象
     *
     * @param tClass 添加的Console类型
     * @param <T>    Console泛型
     * @return 存在则返回ture, 不存在则返回false
     */
    <T extends AbstractConsole> boolean isEmptyCache(Class<T> tClass) {
        AbstractConsole console = consoleCache.get(tClass);
        return console == null;
    }

    /**
     * 从缓存中获取指定对象
     *
     * @param tClass 指定的Console对象类型
     * @param <T>    Console泛型
     * @return 缓存中的Console对象
     */
    @SuppressWarnings("unchecked")
    <T extends AbstractConsole> T getConsoleFromCache(Class<T> tClass) {
        return (T) consoleCache.get(tClass);
    }

    /**
     * 清空缓存
     */
    void clearCache() {
        consoleCache.clear();
    }


}



