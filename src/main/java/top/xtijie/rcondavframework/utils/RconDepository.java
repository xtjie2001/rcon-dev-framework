package top.xtijie.rcondavframework.utils;


import java.util.*;

public abstract class RconDepository {

    private static final Map<Class<?>, Object> lockers = new HashMap<>();


    /**
     * 存放对象, 如果对象已经存在则不进行存放
     *
     * @param i   被存放的对象
     * @param <I> 被存放的对象的泛型
     */
    public synchronized static <I> void deposit(Class<? super I> iClass, I i) {
        if (lockers.isEmpty() || lockers.get(iClass) == null)
            lockers.put(iClass, i);
    }

    /**
     * <p>获取对象, 如果对象不存在则报NullPointerException异常</p>
     * <p>获取对象后, 对象仍然存在与内存</p>
     *
     * @param iClass 获取的对象类型
     * @param <I>    指定获取对象的泛型
     * @return 获取到的对象
     * @throws NullPointerException 空指针异常
     */
    @SuppressWarnings("unchecked")
    public synchronized static <I> I fetch(Class<I> iClass) throws NullPointerException {
        if (lockers.isEmpty() || lockers.get(iClass) == null)
            throw new NullPointerException("depository is empty or " + iClass + " is null");
        return (I) lockers.get(iClass);
    }

}
