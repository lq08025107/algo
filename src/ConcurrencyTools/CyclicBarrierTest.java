package ConcurrencyTools;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    static CyclicBarrier c = new CyclicBarrier(3);

    public static void main(String[] args){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    c.await();
                } catch (Exception ex){

                }
                System.out.println(1);
            }
        }).start();

        try {
            c.await();
        } catch (Exception ex){

        }
        System.out.println(2);
    }
}
