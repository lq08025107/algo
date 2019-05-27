package C09Queue;

public class CircleQueue {
    private String[] items;

    private int n = 0;
    private int head = 0;
    private int tail = 0;

    public CircleQueue(int capacity) {
        this.n = capacity;
        this.items = new String[capacity];
    }

    public boolean enqueue(String item) {
        if((tail + 1) % n == head){
            return false;
        }
        items[tail] = item;
        tail = (tail + 1) % n;
        return true;
    }

    public String dequeue() {
        if(head == tail) {
            return null;
        }
        String ret = items[head];
        head = (head + 1) % n;
        return ret;
    }

    public void printAll() {
        for(int i = head; i % n != tail; ++i) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
}