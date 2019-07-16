import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<String>> resultList = new ArrayList<Future<String>>();

        for(int i = 0; i < 10; i++) {
            Future<String> future = executorService.submit(new TaskWithResult(i));
            resultList.add(future);
        }

        for(Future<String> fs : resultList) {
            while(!fs.isDone());
            System.out.println(fs.get());
        }

    }
}

class TaskWithResult implements Callable<String> {
    private int id;

    public TaskWithResult(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        System.out.println("call 方法被调用 " + Thread.currentThread().getName());
        Thread.sleep(id*1000);
        return "call 方法被调用,任务的返回结果是：" + id + Thread.currentThread().getName();
    }
}
