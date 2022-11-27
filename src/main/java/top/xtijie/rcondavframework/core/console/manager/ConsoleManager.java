package top.xtijie.rcondavframework.core.console.manager;

import top.xtijie.rcondavframework.core.console.AbstractConsole;
import top.xtijie.rcondavframework.exception.ConsoleDestroyException;
import top.xtijie.rcondavframework.exception.ConsoleInitException;

public interface ConsoleManager {

    /**
     * <p>初始化Console</p>
     * <p>在执行此initConsole方法之前, Console已经进行了一些必要操作, 如生成代理对象, 加载相应的检查器等</p>
     * <p>initConsole方法只为Console提供其他初始化</p>
     *
     * @param tClass 被打开的Console类型
     * @param t      已经被打开的Console实例,
     * @param <T>    Console类型
     * @return 进行完初始化方法后的Console实例
     * @throws Exception 初始化过程中可能会发生的异常
     */
    public abstract <T extends AbstractConsole> T initConsole(Class<T> tClass, T t) throws Exception;

    /**
     * <p>Console销毁方法</p>
     * <p>执行此方法之前, Console类在close方法已经进行了必要的前置操作</p>
     * <p>destroyConsole方法只为提供关闭Console过程中的其他自定义操作</p>
     *
     * @param consoleClass 被关闭的Console类型
     * @param t            即将被被关闭的Console实例
     * @param <T>          即将被被关闭的Console类型
     * @throws Exception 销毁过程中可能会发生的异常
     */
    public abstract <T extends AbstractConsole> void destroyConsole(Class<T> consoleClass, T t) throws Exception;

    /**
     * <p>获取Console方法</p>
     * <p>ConsoleManager中可能存在类似缓存机制, 因此需要Manager自行提供获取Console的方法</p>
     * <p>如果没办法返回Console, 请返回null, 尽量不要在此方法中抛异常, 否则会导致Console.open()加载失败</p>
     *
     * @param consoleClass 需要的Console类型
     * @param <T>          需要的Console泛型
     * @return 需要的Console实例
     * @throws Exception 获取过程中可能出现的异常
     */
    public abstract <T extends AbstractConsole> T getConsole(Class<T> consoleClass) throws Exception;
}
