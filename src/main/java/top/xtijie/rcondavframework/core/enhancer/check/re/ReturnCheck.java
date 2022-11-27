package top.xtijie.rcondavframework.core.enhancer.check.re;

public interface ReturnCheck {

    public default boolean returnCheck(Class<?> returnClass, Object obj) throws Exception {
        return true;
    }

    public default Object returnFilter(Object obj) throws Exception {
        return obj;
    }
}
