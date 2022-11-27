package top.xtijie.rcondavframework.core.enhancer.check.pe.impl;


import top.xtijie.rcondavframework.core.enhancer.check.pe.ParameterCheck;
import top.xtijie.rcondavframework.exception.ParameterFormatException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <h3>邮箱检查器</h3>
 * <p>作用: 判断参数是否符合邮箱格式</p>
 */
public class EmailParamCheck implements ParameterCheck {

    @Override
    public boolean paramCheck(Class<?> paramClass, Object arg) throws Exception {
        if (arg == null || !paramClass.equals(String.class))
            throw new ParameterFormatException("The parameter is null or not is String type");

        String pattern = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$";
        Matcher matcher = Pattern.compile(pattern)
                .matcher(arg.toString());

        if (!matcher.find())
            throw new ParameterFormatException("The parameter does not conform to the email format");

        return true;
    }

    @Override
    public Object paramFilter(Object arg) throws Exception {
        return arg;
    }
}
