package Singleton;

public class Singleton2 {
    private Singleton2(){}

    private static class InstanceHolder{
        private static Object instance = new Object();
    }

    public Object getInstance() {
        return InstanceHolder.instance;
    }
}
