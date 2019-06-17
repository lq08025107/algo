package WebServer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class DefaultThreadPool<Job extends Runnable> implements ThreadPool {

    private static final int MAX_WORKER_NUMBERS = 10;

    private static final int DEFAULT_WORKER_NUMBERS = 5;

    private static final int MIN_WORKER_NUMBERS = 1;
    //工作列表
    private final LinkedList<Job> jobs = new LinkedList<>();
    //工作者列表
    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());


    @Override
    public void execute(Runnable runnable) {

    }

    @Override
    public void shutdown() {

    }

    @Override
    public void addWorks(int num) {

    }

    @Override
    public void removeWorks(int num) {

    }

    @Override
    public int getJobSize() {
        return 0;
    }

    class Worker implements Runnable{
        @Override
        public void run() {

        }
    }
}
