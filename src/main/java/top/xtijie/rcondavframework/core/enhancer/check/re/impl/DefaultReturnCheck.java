package top.xtijie.rcondavframework.core.enhancer.check.re.impl;

import top.xtijie.rcondavframework.core.enhancer.check.re.ReturnCheck;

/**
 * <h3>默认返回值检查器</h3>
 * <p>作用: 无</p>
 */
public class DefaultReturnCheck implements ReturnCheck {

    @Override
    public boolean returnCheck(Class<?> returnClass, Object obj) throws Exception {
        return true;
    }

    @Override
    public Object returnFilter(Object obj) throws Exception {
        return obj;
    }
}
