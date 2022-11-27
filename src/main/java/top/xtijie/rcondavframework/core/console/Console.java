package top.xtijie.rcondavframework.core.console;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import top.xtijie.rcondavframework.core.enhancer.ConsoleEnhancer;
import top.xtijie.rcondavframework.core.enhancer.pr.ParameterEnhance;
import top.xtijie.rcondavframework.core.enhancer.pr.ReturnEnhance;
import top.xtijie.rcondavframework.core.console.manager.ConsoleManager;

import top.xtijie.rcondavframework.utils.RconDepository;

import java.lang.reflect.Method;

public abstract class Console {

    private static ConsoleManager consoleManager;

    private static ConsoleEnhancer consoleEnhancer;

    static {
        try {
            consoleEnhancer = RconDepository.fetch(ConsoleEnhancer.class);
            consoleManager = RconDepository.fetch(ConsoleManager.class);
            if (consoleManager == null)
                throw new NullPointerException("ConsoleManager is null");
            if (consoleEnhancer == null)
                throw new NullPointerException("ConsoleEnhancer is null");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * <h3>开启自定义Console</h3>
     * <p>开启Console时尽量使用XxxConsole.class作为Class对象,不要使用对象的.getClass()方法,否则可能会发生不可预料的错误发生</p>
     * <p>传入的Console.class需要继承AbstractConsole抽象父类,否则无法加载,并在编译时引发异常</p>
     *
     * @param conClass 要进行加载的Console类型
     * @param <T>      被加载的Console对象的泛型
     * @return 被加载并创建出来的Console对象
     * @throws Exception 加载过程中可能引发的所有异常
     */
    public static <T extends AbstractConsole> T open(Class<T> conClass) throws Exception {

        T t = consoleManager.getConsole(conClass);
        if (t != null)
            return t;
        T console = getProxyConsole(conClass);
        console.init();
        T t1 = consoleManager.initConsole(conClass, console);
        if (t1 == null)
            throw new NullPointerException("open fail [init " + conClass + " object is null]");
        return t1;
    }

    /**
     * <h3>关闭自定义Console</h3>
     * <p>关闭Console时请直接使用XxxConsole.class的方式进行传参,尽量不要使用对象.getClass()方法进行传参,否则可能会发生不可预料的异常</p>
     * <p>关闭的Console.class需要继承AbstractConsole抽象父类,否则无法加载,并在编译时引发异常</p>
     *
     * @param conClass 被关闭的Console类型
     * @param <T>      被关闭的Console类型的泛型
     * @throws Exception 关闭过程中可能产生的异常
     */
    public static <T extends AbstractConsole> void close(Class<T> conClass) throws Exception {
        T console = consoleManager.getConsole(conClass);
        if (console == null)
            throw new NullPointerException("close fail [get " + conClass + " object is null]");
        consoleManager.destroyConsole(conClass, console);
        console.destroy();
    }

    /**
     * <h3>关闭自定义Console</h3>
     * <p>关闭Console时请直接使用XxxConsole.class的方式进行传参,尽量不要使用对象.getClass()方法进行传参,否则可能会发生不可预料的异常</p>
     * <p>关闭的Console.class需要继承AbstractConsole抽象父类,否则无法加载,并在编译时引发异常</p>
     *
     * @param conClass 被关闭的Console类型
     * @param console  被关闭的Console对象
     * @param <T>      被关闭的Console类型的泛型
     * @throws Exception 关闭过程中可能产生的异常
     */
    public static <T extends AbstractConsole> void close(Class<T> conClass, T console) throws Exception {
        consoleManager.destroyConsole(conClass, console);
        console.destroy();
    }


    /**
     * <h3>获取Console代理对象</h3>
     * <p>此方法使用的使cglib的动态代理,只要是对对象的方法就行代理</p>
     * <p>代理过程中会对当前对象的方法和返回值进行扩展</p>
     * <p>开发者可工具自己的要求检查或修改参数或返回值</p>
     * <p>但要求修改后的参数或返回值的类型与原本的类型一致</p>
     *
     * @param tClass 代理对象的类型
     * @param <T>    代理对象的泛型
     * @return 代理对象实例
     */
    @SuppressWarnings("unchecked")
    private static <T extends AbstractConsole> T getProxyConsole(Class<T> tClass) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(tClass);
        enhancer.setCallback((MethodInterceptor) (proxy, method, args, methodProxy) -> {
            args = before(proxy, method, args, methodProxy);
            Object obj = method.invoke(tClass.getConstructor().newInstance(), args);
            return after(method, obj, tClass);
        });
        return (T) enhancer.create();
    }

    /**
     * <h3>Console扩展方法的前置方法</h3>
     * <p>此方法主要是针对参数进行检查和扩展</p>
     * <p>其中,此方法会先进行参数的检查,只有当检查结果为true的参数才会进行扩展操作</p>
     * <p>此方法是私有方法,只是getProxyConsole方法中对Console增强方法的前置操作的抽离,目的只是为了能让代码更好看一点</p>
     *
     * @param proxy       代理对象
     * @param method      被代理方法
     * @param args        方法参数
     * @param methodProxy 代理后方法
     * @return 被扩展后生成的新参数
     * @throws Exception 参数扩展前可能遇到的所有异常
     */
    private static Object[] before(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Exception {
        ParameterEnhance enhance = consoleEnhancer.parameterEnhance(method, args);
        if (enhance.enabled())
            return enhance.enhance();
        else
            return args;
    }

    /**
     * <h3>Console增强方法的后置方法</h3>
     * <p>此方法主要是对返回值进行检查和扩展</p>
     * <p>其中,此方法会先进行返回值的检查,只有当检查结果为true使才会进行返回值的扩展</p>
     * <p>此方法是私有方法,只是getProxyConsole方法中对Console增强方法的后置操作的抽离,目的只是为了能让代码更好看一些</p>
     *
     * @param method 被代理的目标方法
     * @param obj    方法的参数
     * @param cla    方法返回值的类型
     * @return 进行返回值扩展后的新返回值
     * @throws Exception 扩展过程中可能引发的所有异常
     */
    private static Object after(Method method, Object obj, Class<?> cla) throws Exception {
        ReturnEnhance enhance = consoleEnhancer.returnEnhance(method, obj, cla);
        if (enhance.enabled())
            return enhance.enhance();
        else
            return obj;
    }

}