package C07LinkedList;

import java.util.List;

/**
 *1）单链表的反转
 *2）链表中的环的检测
 *3）两个有序链表的合并
 *4）删除链表中倒数第n个节点
 *5）求链表的中间节点
*/
public class LinkedListAlgo {
	public static class Node {
		public int data;
		public Node next;

		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}

	public static Node createNode(int value) {
		return new Node(value, null);
	}

	public static void printAll(Node list) {
		Node p = list;
		while(p != null) {
			System.out.print(p.data + " ");
			p = p.next;
		}
		System.out.println();
	}
	//单链表反转
	public static Node reverseLinkedList(Node list) {
		Node pre = null;
		Node cur = list;
		while(cur != null) {
			Node next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}

	//链表中环的检测
	public static Boolean checkCircle(Node list) {
		if(list == null) return false;

		Node fast = list.next;
		Node slow = list;

		while(fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;

			if(slow == fast) return true;
		}
		return false;
	}
	//两个有序链表的合并
	public static Node mergeSortedLists(Node la, Node lb) {
		if(la == null) return lb;
		if(lb == null) return la;

		Node p = la;
		Node q = lb;
		Node head;
		if(p.data < q.data) {
			head = p;
			p = p.next;
		} else {
			head = q;
			q = q.next;
		}
		Node r = head;
		while(p != null && q != null) {
			if(p.data < q.data) {
				r.next = p;
				p = p.next;
			} else {
				r.next = q;
				q = q.next;
			}
			r = r.next;
		}
		if(p != null){
			r.next = p;
		} else {
			r.next = q;
		}
		return head;
	}
	//删除链表中倒数第n个节点
	public static Node deletelastKth(Node list, int k) {
		Node fast = list;
		int i = 1;
		while(fast != null && i < k) {
			fast = fast.next;
			i++;
		}
		//若list为空，直接返回
		if(fast == null) return list;

		Node slow = list;
		Node pre = null;
		while(fast.next != null) {
			fast = fast.next;
			pre = slow;
			slow = slow.next;
		}
		//list只有一个节点
		if(pre == null) {
			list = list.next;
		} else {
			pre.next = pre.next.next;
		}
		return list;
	}

	//求中间节点
	public static Node findMiddleNode(Node list) {
		if(list == null) return null;

		Node fast = list;
		Node slow = list;
		while(fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}


}

