import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;


//面试题：写一个固定容量同步容器，拥有put和get方法，以及getCount方法，
//能够支持，2个生产者线程及10个消费者线程的阻塞调用（经常问！）
//最简单的使用synchronized wait notify 实现
public class MyContainer<T> {
    private final LinkedList<T> list = new LinkedList<>();
    private final int MAX = 10;
    private int count = 0;

    public synchronized void put(T t) throws InterruptedException {
        /*
         * 解释下面的while
         * 如果while换成if的话，假如if后面的条件为真，this.wait执行，交出锁，别的线程（消费者线程）消费后唤醒put之前，可能唤醒了另一个put，而这个put将count加到了最大
         * 此时最初的put被唤醒，从this.wait后面开始执行，如果是if的话，会直接执行lists.add(t),而此时lists.size()是满的，所以会报异常
         * 而使用while就不会出现这种情况
         */
        while(list.size() == MAX) {
            this.wait();
        }
        list.add(t);
        ++count;
        this.notifyAll();
    }

    public synchronized T get() throws InterruptedException {
        T t = null;
        while(list.size() == 0) {
            this.wait();
        }
        t = list.removeFirst();
        count --;
        this.notifyAll();
        return t;
    }

    public static void main(String[] args) {
        MyContainer container = new MyContainer();
        // 10个消费者线程
        for(int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0; j < 4; j++) {
                        try {
                            System.out.println(Thread.currentThread().getName() + "--->" + container.get());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }, "consumer" + i).start();
        }

        System.out.println("等待2s开始生产");
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for(int i = 0; i < 2; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 8 ;j++) {
                        try {
                            container.put(Thread.currentThread().getName()+" "+j );
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("生产者:"+Thread.currentThread().getName()+" "+j );
                    }

                }
            }, "producer" + i).start();
        }
    }
}
