
package top.xtijie.rcondavframework.core.enhancer.check.pe.impl;

import top.xtijie.rcondavframework.core.enhancer.check.pe.ParameterCheck;

/**
 * <h3>默认参数检查器</h3>
 * <p>作用: 无</p>
 */
public class DefaultParamCheck implements ParameterCheck {

    @Override
    public boolean paramCheck(Class<?> paramClass, Object arg) throws Exception {
        return true;
    }

    @Override
    public Object paramFilter(Object arg) throws Exception {
        return arg;
    }
}
