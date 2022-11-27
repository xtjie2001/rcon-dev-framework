package top.xtijie.rcondavframework.core.enhancer;

import top.xtijie.rcondavframework.core.enhancer.pr.ParameterEnhance;
import top.xtijie.rcondavframework.core.enhancer.pr.ReturnEnhance;

import java.lang.reflect.Method;

public interface ConsoleEnhancer {

    /**
     * <h3>参数增强器方法</h3>
     * <p>此方法可以对方法的参数进行增强或扩展</p>
     * <p>增强时需要指定被增强的方法和其参数值</p>
     *
     * @param method 被增强的方法
     * @param args   当前方法中所有的参数值
     * @return 参数增强器
     * @throws Exception 增强过程中可能引发的所有异常
     */
    public abstract ParameterEnhance parameterEnhance(Method method, Object[] args) throws Exception;

    /**
     * <h3>返回值增强方法</h3>
     * <p>此方法可以对方法的返回值进行增强</p>
     * <p>增强前请指定被增强的方法,方法的返回值以及方法返回值的类型</p>
     *
     * @param method 被增强的方法
     * @param obj    被增强的返回值
     * @param cla    被增强的放回置类型
     * @return 返回值增强器
     * @throws Exception 增强过程中可能引发的所有异常
     */
    public abstract ReturnEnhance returnEnhance(Method method, Object obj, Class<?> cla) throws Exception;

}

