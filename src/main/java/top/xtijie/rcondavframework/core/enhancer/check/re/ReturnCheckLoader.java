package top.xtijie.rcondavframework.core.enhancer.check.re;

import top.xtijie.rcondavframework.core.enhancer.check.CheckLoader;
import top.xtijie.rcondavframework.core.enhancer.check.anno.Check;

public class ReturnCheckLoader implements CheckLoader {
    @Override
    public Object load(Check check, Class<?> cla, Object obj) throws Exception {
        ReturnCheck instance = check.reCla().getConstructor().newInstance();
        if (instance.returnCheck(cla, obj))
            return instance.returnFilter(obj);
        return obj;
    }
}
