package Singleton;

public class Singleton1 {
    private Singleton1() {}
    // 如果不加volatile，这里的问题处在第二个if语句，因为instance = new Object() 分为三个阶段
    // 1 分配对象的内存空间  2 初始化对象  3 设置instance指向刚分配的内存地址
    // 2和3可能会指令重排 在多线程中，线程A执行了3之后，线程B判断instance不为null，但此时还没有执行
    // 对象的初始化，所以B引用不到对象。
    private volatile static Object instance;

    public Object getInstance() {
        if(instance == null) {
            synchronized (Singleton1.class) {
                if(instance == null)
                    instance = new Object();
            }
        }
        return instance;
    }
}
