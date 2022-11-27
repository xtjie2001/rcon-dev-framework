package top.xtijie.rcondavframework.core.enhancer.check;

import top.xtijie.rcondavframework.core.enhancer.check.anno.Check;

public interface CheckLoader {

    /**
     * <h3>检查器加载器</h3>
     * <p>用于加载检查器, 他会读取@Check中的reCla和paCla值</p>
     * <p>@Check中value的值会作为被加载的检查器, 对检查器进行加载</p>
     *
     * @param check 当前参数的Check注解对象
     * @param cla   当前参数的类型
     * @param obj   当前参数的值
     * @return 被处理后的参数
     * @throws Exception 参数处理过程中可能发生的异常
     */
    public Object load(Check check, Class<?> cla, Object obj) throws Exception;

}
