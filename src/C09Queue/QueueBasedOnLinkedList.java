package C09Queue;

public class QueueBasedOnLinkedList {
    static class Node{
        private String data;
        private Node next;

        public Node(String data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node head = null;
    private Node tail = null;
    public QueueBasedOnLinkedList(){

    }

    public boolean enqueue(String item) {
        Node newNode = new Node(item, null);
        if(tail == null){
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        return true;
    }

    public String dequeue() {
        if(head == null)
            return null;
        String value = head.data;
        head = head.next;
        if(head == null) {
            tail = null;
        }
        return value;
    }

    public void printAll() {
        Node p = head;
        while(p != null) {
            System.out.print(p.data + " ");
            p = p.next;
        }
        System.out.println();
    }

    public static void main(String[] args){
        QueueBasedOnLinkedList queue = new QueueBasedOnLinkedList();
        queue.printAll();

        queue.enqueue("liuqiang");
        queue.enqueue("zhangxiao");
        queue.printAll();

        queue.dequeue();
        queue.printAll();
    }

}