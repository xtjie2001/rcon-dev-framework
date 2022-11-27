package top.xtijie.rcondavframework.core.enhancer.check.re.impl;

import top.xtijie.rcondavframework.core.enhancer.check.re.ReturnCheck;
import top.xtijie.rcondavframework.exception.ParameterFormatException;

/**
 * <h3>颜色代码消除器</h3>
 * <p>作用: 消除返回值中与颜色有关的标记,如:§c 等</p>
 */
public class DiscolorCodeReturnCheck implements ReturnCheck {

    @Override
    public boolean returnCheck(Class<?> returnClass, Object obj) throws Exception {
        if (returnClass.equals(String.class) || obj == null)
            throw new ParameterFormatException("return not is String type or return is empty");
        return true;
    }

    @Override
    public Object returnFilter(Object obj) throws Exception {
        String str = obj.toString();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == '§')
                i++;
            else
                sb.append(str.charAt(i));

        return sb.toString();
    }
}
