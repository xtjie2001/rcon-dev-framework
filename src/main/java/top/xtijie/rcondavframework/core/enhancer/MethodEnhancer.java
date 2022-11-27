package top.xtijie.rcondavframework.core.enhancer;

import top.xtijie.rcondavframework.core.enhancer.check.CheckLoader;
import top.xtijie.rcondavframework.core.enhancer.check.pe.ParameterCheckLoader;
import top.xtijie.rcondavframework.core.enhancer.check.anno.Check;
import top.xtijie.rcondavframework.core.enhancer.check.re.ReturnCheckLoader;
import top.xtijie.rcondavframework.core.enhancer.pr.ParameterEnhance;
import top.xtijie.rcondavframework.core.enhancer.pr.ReturnEnhance;
import top.xtijie.rcondavframework.utils.RconDepository;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

public class MethodEnhancer implements ConsoleEnhancer {

    private final CheckLoader paramCheckLoader;
    private final CheckLoader returnCheckLoader;

    {
        paramCheckLoader = RconDepository.fetch(ParameterCheckLoader.class);
        returnCheckLoader = RconDepository.fetch(ReturnCheckLoader.class);
    }


    @Override
    public ParameterEnhance parameterEnhance(Method method, Object... args) throws Exception {
        return new ParameterEnhance() {
            @Override
            public boolean enabled() {
                Parameter[] parameters = method.getParameters();
                if (parameters.length != 0)
                    for (Parameter parameter : parameters)
                        if (parameter.getAnnotation(Check.class) != null)
                            return true;
                return false;
            }

            @Override
            public Object[] enhance() throws Exception {
                Parameter[] parameters = method.getParameters();
                if (parameters.length != 0)
                    for (int i = 0; i < parameters.length; i++) {
                        Check annotation = parameters[i].getAnnotation(Check.class);
                        if (annotation != null)
                            args[i] = paramCheckLoader.load(
                                    annotation, parameters[i].getType(), args[i]);
                    }
                return args;
            }
        };
    }

    @Override
    public ReturnEnhance returnEnhance(Method method, Object obj, Class<?> cla) throws Exception {
        return new ReturnEnhance() {
            @Override
            public boolean enabled() {
                return method.getAnnotation(Check.class) != null;
            }

            @Override
            public Object enhance() throws Exception {
                Check annotation = method.getAnnotation(Check.class);
                if (annotation != null)
                    return returnCheckLoader.load(annotation, cla, obj);
                return obj;
            }
        };
    }
}
