package top.xtijie.rcondavframework.core.enhancer.check.pe.impl;


import top.xtijie.rcondavframework.core.enhancer.check.pe.ParameterCheck;
import top.xtijie.rcondavframework.exception.ParameterFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h3>普通参数检查器</h3>
 * <p>作用: 检查参数中是否有空格[ ],换行符[\r\n],和制表符[\t]</p>
 */
public class SimpleParamCheck implements ParameterCheck {

    @Override
    public boolean paramCheck(Class<?> paramClass, Object arg) throws Exception {
        if (arg == null || !paramClass.equals(String.class))
            throw new ParameterFormatException("The parameter is null or not is String type");
        String pattern = " +|\\t|\\n|\\r";
        Matcher matcher = Pattern.compile(pattern)
                .matcher(arg.toString());
        if (!matcher.find())
            throw new ParameterFormatException("There can be no spaces, line breaks[\\r or \\n], and tabs[\\t] in the arguments");
        return true;
    }

    @Override
    public Object paramFilter(Object arg) throws Exception {
        return arg;
    }
}
