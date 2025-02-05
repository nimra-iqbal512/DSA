import java.util.*;

class ListNode{
	int val;
	ListNode next;

	ListNode(){}
	ListNode(int val){
		this.val = val; 
	}
	ListNode(int val, ListNode next){
		this.val = val; 
		this.next = next; 
	}
}

public class ReverseLinkedList {
	ListNode head;
	ListNode currNode;

	public void createList(int currentVal){
		ListNode tempNode = new ListNode(currentVal);

		// If it is the first node of list
		if (head == null) {
			head = currNode = tempNode;
			return;
		}

		currNode.next = tempNode;
		currNode = tempNode;
	}

	public void traverseList(){
		if(head != null){
			ListNode tempNode = head;
			while(tempNode.next != null){
				System.out.print(tempNode.val + " ");
				tempNode = tempNode.next;
			}
			System.out.println(tempNode.val);
		}
	}

	public void solution1(){
		// Reverse by shifting values iteratively

		if(head == null || head.next == null){
			return;
		}

		List<Integer> list = new ArrayList<>();
		ListNode temp = new ListNode();
		temp = head;
		// Strong values from linkedList to arrayList
		while(temp != null){
			list.add(temp.val);
			temp = temp.next;
		}
		// Copying values from arrayList to linkedList(last value of arrayList will be the first value in linkedList)
		temp = head;
		for(int i=list.size()-1; i>=0; i--){
			temp.val = list.get(i);	
			temp = temp.next;
		}

		traverseList();

		// TC = 0(n), SC = 0(n)

		// Note: //TC for .get() is 0(1)
		// In java, ArrayList.get(index) has a time complexity of 0(1) because it provides random access to elements by index, using an internal array.
	}


	public void solution2(){
		// Reverse by shifting values recursively

		if(head == null || head.next == null){
			return;
		}

		List<Integer> list = new ArrayList<>();
		recursive_reverse_1(head, list);
		traverseList();


		// TC = 0(n^2), n times recursive_reverse_1() is called, and in each call list.removeFirst() takes 0(n) TC
		// SC = 0(n), 0(n) because recursive depth is n, so recursive calls require 0(n) space, 0(n) for list. 0(n) + 0(n) = 0(n)
	}

	public void recursive_reverse_1(ListNode node, List<Integer> list){
		if(node == null){
			return;
		}

		list.add(node.val);
		recursive_reverse_1(node.next, list);
		node.val = list.removeFirst();

		// Note:  
		// ArrayList.removeFirst() is an 0(n) operation.
		// LinkedList.removeFirst() is an 0(1) operation.
	}

	public void solution3(){
		// Reverse by shifting nodes iteratively

		// // No need for this condition here
		// if(head == null || head.next == null){
		// 	return;
		// }

		ListNode prev = null;
		ListNode curr = head;

		while(curr != null){
			ListNode next = curr.next;
			curr.next = prev;

			prev = curr;
			curr = next;
		}
		head = prev;
		traverseList();

		// TC = 0(n), SC = 0(1)
	}

	public void solution4(){
		// Reverse by shifting nodes recursively

		recursive_reverse_2(null);
		traverseList();

		// TC = 0(n) --> n times recursive fn() call, SC = 0(n) --> n is the recursion depth
	}


	public void recursive_reverse_2(ListNode prev){
		if(head == null){
			head = prev;
			return;
		}

		ListNode next = head.next;
		head.next = prev;

		prev = head;
		head = next;
		recursive_reverse_2(prev);
	}

	public void reverseList(){

		// // // Reverse by shifting nodes (Logic 1)
		// if(head == null || head.next == null){	//If there is no node, or If there is only one node in a linked list
		// 	return;
		// }
		// ListNode prevNode = head;
		// ListNode currNode = head.next;
		// while (currNode != null) {
		// 	prevNode.next = currNode.next;
		// 	currNode.next = head;
		// 	head = currNode;

		// 	// Update current Node
		// 	currNode = prevNode.next;
		// }


		// // Reverse by shifting nodes (Logic 2)
		ListNode prev = null;
		ListNode curr = head;
		while(curr != null){
			ListNode next = curr.next;
			curr.next = prev;

			prev = curr;
			curr = next;
		}
		head = prev;

	}


	public static void main(String[] args) {
		ReverseLinkedList list = new ReverseLinkedList();

		// list.reverseList();

		list.createList(1);
		list.createList(2);
		list.createList(3);
		list.createList(4);
		list.createList(5);
		System.out.println("List...");
		list.traverseList();
		
		// System.out.println("\n\nReversed.. Solution 1...");
		// list.solution1();

		System.out.println("\n\nReversed.. Solution 2...");
		list.solution2();

		// System.out.println("\n\nReversed.. Solution 3...");
		// list.solution3();

		// System.out.println("\n\nReversed.. Solution 4...");
		// list.solution4();
	}
}