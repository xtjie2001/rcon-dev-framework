package top.xtijie.rcondavframework.core.enhancer.pr;

public interface ParameterEnhance {


    /**
     * <h3>开启增强器</h3>
     * <p>通过返回值true或false来判断是否要开启增强</p>
     *
     * @return 是否开启增强
     */
    public abstract boolean enabled();

    /**
     * <h3>增强操作</h3>
     * <p>具体的增强逻辑需要在此方法中执行</p>
     *
     * @return 进行增强后的新参数
     * @throws Exception 增强过程中可能出现的所有异常
     */
    public abstract Object[] enhance() throws Exception;

}
