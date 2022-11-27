package top.xtijie.rcondavframework.core.enhancer.check.anno;


import top.xtijie.rcondavframework.core.enhancer.check.pe.ParameterCheck;
import top.xtijie.rcondavframework.core.enhancer.check.pe.impl.SimpleParamCheck;
import top.xtijie.rcondavframework.core.enhancer.check.re.ReturnCheck;
import top.xtijie.rcondavframework.core.enhancer.check.re.impl.DefaultReturnCheck;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.METHOD})
public @interface Check {

    /**
     * <p>指定当前参数所用的检查器类型,默认SimpleCheck.class</p>
     * <p>此检查器会检查参数中是否有空格,换行符[/r/n]和制表符[/t]</p>
     *
     * @return 检查器类型
     */
    Class<? extends ParameterCheck> paCla() default SimpleParamCheck.class;

    /**
     * <p>指定当前返回值检查器的类型,默认为SimpleReturnCheck.class</p>
     * <p>此检查器什么也不会做,只是在这里充数的</p>
     *
     * @return 检查器类型
     */
    Class<? extends ReturnCheck> reCla() default DefaultReturnCheck.class;

}
