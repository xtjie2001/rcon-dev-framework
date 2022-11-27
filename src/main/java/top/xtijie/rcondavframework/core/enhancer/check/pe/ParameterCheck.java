package top.xtijie.rcondavframework.core.enhancer.check.pe;

public interface ParameterCheck {

    /**
     * <h3>参数检查</h3>
     * <p>此方法会对被@Check标记的参数进行检查</p>
     * <p>此方法通过true和false对此参数的合法性进行判断, 只有当返回值为true时才会执行filter方法</p>
     * <p>当返回值为false时, 则不会执行filter方法</p>
     * <p>此方法时参数检查方法的入口</p>
     *
     * @param paramClass 当前参数的类型
     * @param arg        当前参数的值
     * @return boole类型, 告诉加载器此参数是否合法, 默认返回true
     * @throws Exception 检查过程中可能出现的异常
     */
    public default boolean paramCheck(Class<?> paramClass, Object arg) throws Exception {
        return true;
    }

    /**
     * <h3>参数过滤器</h3>
     * <p>此方法主要用来过滤参数</p>
     * <p>要求返回值的参数类型一定要与当前参数的参数类型一致, 否则会报异常: java.lang.IllegalArgumentException: argument type mismatch</p>
     * <p>此方法只会在check方法返回为true时执行</p>
     *
     * @param arg 当前参数值
     * @return 过滤后的参数值
     * @throws Exception 过滤过程中可能产生的异常
     */
    public default Object paramFilter(Object arg) throws Exception {
        return arg;
    }

}
