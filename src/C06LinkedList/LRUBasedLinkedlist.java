package C06LinkedList;

import java.util.Scanner;

public class LRUBasedLinkedlist<T> {

	//默认容量
	private final static Integer DEFAULT_CAPACITY = 10;

	private SNode<T> headNode;

	private Integer length;

	private Integer capacity;

	public LRUBasedLinkedlist(){
		this.headNode = new SNode<>();
		this.capacity = DEFAULT_CAPACITY;
		this.length = 0;
	}

	public LRUBasedLinkedlist(Integer capacity) {
		this.headNode = new SNode<>();
		this.capacity = capacity;
		this.length = 0;
	}

	public void add (T data) {
		SNode preNode = findPreNode(data);

		if(preNode != null) {
			deleteElemOptim(preNode);
			insertElemAtBegin(data);
		} else {
			if (length >= this.capacity) {
				deleteElemAtEnd();
			}
			insertElemAtBegin(data);
		}
	}

	private void deleteElemOptim(SNode preNode) {
		SNode temp = preNode.getNext();
		preNode.setNext(temp.getNext());
		temp = null;
		length--;
	}

	private void insertElemAtBegin(T data) {
		SNode next = headNode.getNext();
		headNode.setNext(new SNode(data, next));
		length++;
	}

	private SNode findPreNode(T data) {
		SNode node = headNode;
		while(node.getNext() != null) {
			if (data.equals(node.getNext().getElement())) {
				return node;
			}
			node = node.getNext();
		}
		return null;
	}

	private void deleteElemAtEnd() {
		SNode node = headNode;
		if(headNode.getNext() == null){
			return;
		}
		while(node.getNext().getNext() != null) {
			node = node.getNext();
		}

		//SNode temp = node.getNext();
		node.setNext(null);
		//temp = null;
		length--;
	}

	private void printAll() {
		SNode node = headNode.getNext();
		while(node != null) {
			System.out.print(node.getElement() + ",");
			node = node.getNext();
		}
		System.out.println();
	}

	public class SNode<T> {
		private T element;

		private SNode next;

		public SNode() {
			this.next = null;
		}

		public SNode(T element) {
			this.element = element;
		}

		public SNode(T element, SNode next) {
			this.element = element;
			this.next = next;
		}

		public T getElement() {
			return element;
		}

		public void setElement(T element) {
			this.element = element;
		}

		public SNode getNext() {
			return next;
		}

		public void setNext(SNode next) {
			this.next = next;
		}
	}

	public static void main(String[] args) {
		LRUBasedLinkedlist list = new LRUBasedLinkedlist();
		Scanner sc = new Scanner(System.in);
		while(true) {
			list.add(sc.nextInt());
			list.printAll();
		}
	}
}
