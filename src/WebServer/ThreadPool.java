package WebServer;

public interface ThreadPool<Job extends Runnable> {
    void execute(Job job);
    void shutdown();
    void addWorks(int num);
    void removeWorks(int num);
    int getJobSize();
}
