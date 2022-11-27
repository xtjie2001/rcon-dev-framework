package top.xtijie.rcondavframework.core.enhancer.check.pe;

import top.xtijie.rcondavframework.core.enhancer.check.CheckLoader;
import top.xtijie.rcondavframework.core.enhancer.check.anno.Check;

public class ParameterCheckLoader implements CheckLoader {

    @Override
    public Object load(Check check, Class<?> paramClass, Object arg) throws Exception {
        ParameterCheck instance = check.paCla().getConstructor().newInstance();
        if (instance.paramCheck(paramClass, arg))
            arg = instance.paramFilter(arg);
        return arg;
    }
}
