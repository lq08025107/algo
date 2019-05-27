package C08Stack;

public class StackBasedonLinkedList {
    public class Node {
        public int data;
        public Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    public Node top = null;

    public void push(int value) {
        Node newNode = new Node(value, null);
        if(top == null) {
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
    }
    public int pop() {
        if(top == null){
            return -1;
        }
        Node temp = top;
        top = top.next;
        return temp.data;
    }
}
