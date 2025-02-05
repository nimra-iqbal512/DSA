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

class SinglyLinkedList {
	ListNode head;
	ListNode currNode;

	public void createNode(int currentVal){
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
}

public class MergeTwoSortedLists{
	public static void Solution1(SinglyLinkedList l1, SinglyLinkedList l2){
		// // Approach:
		// Store values of both linked lists in an array list in ascending order
		// Create a new linked list from that array list

		ListNode temp1 = l1.head;
		ListNode temp2 = l2.head;
		List<Integer> arrList = new ArrayList<>();
		
		// Store values from both linkedLists in an arrayList
		while (temp1 != null && temp2 != null) {
			if(temp1.val <= temp2.val){
				arrList.add(temp1.val);
				temp1 = temp1.next;
			}else{
				arrList.add(temp2.val);
				temp2 = temp2.next;
			}
		}
		if(temp1 == null){
			while (temp2 != null) {
				arrList.add(temp2.val);
				temp2 = temp2.next;
			}
		}else if(temp2 == null){
			while (temp1 != null) {
				arrList.add(temp1.val);
				temp1 = temp1.next;
			}
		}

		// Create a new linked list from arrayList
		SinglyLinkedList newList = new SinglyLinkedList();
		for(int i = 0; i < arrList.size(); i++){
			newList.createNode(arrList.get(i));
		}

		newList.traverseList();
	}

	public static void Solution2(SinglyLinkedList l1, SinglyLinkedList l2){

		// // Approach:
		// Create a new linkedList, and store values from the given two linked lists into the newly created linked list

		ListNode temp1 = l1.head;
		ListNode temp2 = l2.head;
		
		// Creating new Linked List
		SinglyLinkedList newList = new SinglyLinkedList();

		// Store values in new LinkedList
		while (temp1 != null && temp2 != null) {
			if(temp1.val <= temp2.val){
				newList.createNode(temp1.val);
				temp1 = temp1.next;
			}else{
				newList.createNode(temp2.val);
				temp2 = temp2.next;
			}
		}
		if(temp1 == null){
			while (temp2 != null) {
				newList.createNode(temp2.val);
				temp2 = temp2.next;
			}
		}else if(temp2 == null){
			while (temp1 != null) {
				newList.createNode(temp1.val);
				temp1 = temp1.next;
			}
		}

		newList.traverseList();
	}

	public static void Solution3(SinglyLinkedList l1, SinglyLinkedList l2){

		ListNode list1 = l1.head;
		ListNode list2 = l2.head;

		if(list1 == null) return;
        if(list2 == null) return;

        ListNode head, tail;
        // Initializing head and tail
        if(list1.val <= list2.val){
            head = tail = list1;
            list1 = list1.next;
        }else{
            head = tail = list2;
            list2 = list2.next;
        }
        head.next = null;
		
		while (list1 != null && list2 != null) {
			if(list1.val <= list2.val){
                tail.next = list1;
                list1 = list1.next;
			}else{
                tail.next = list2;
                list2 = list2.next;
			}
            tail = tail.next;
            tail.next = null;
		}

		if(list1 == null){
			tail.next = list2;
		}else if(list2 == null){
			tail.next = list1;
		}

        return;
	}

	public static void Solution4(SinglyLinkedList l1, SinglyLinkedList l2){

		if(l1.head == null) return;
		if(l2.head == null) return;

		ListNode index1 = (l1.head.val <= l2.head.val) ? l1.head : l2.head;
		ListNode index2 = (l1.head.val <= l2.head.val) ? l2.head : l1.head;
		ListNode head = index1;

		while(index2 != null){
			if(index1.next == null || index1.next.val >= index2.val){
				ListNode old1Successor = index1.next;
				ListNode old2Successor = index2.next;
				index1.next = index2;
				index2.next = old1Successor;
				index2 = old2Successor;
			}
			index1 = index1.next;
		}
		// return head;
		
	}


	// public void createList(ListNode newHead, ListNode newTail, ListNode currNode){
	// 	if(newHead == null && newTail == null){
	// 		newHead = newTail = new ListNode(currNode.val);
	// 	}else{
	// 		newTail.next = new ListNode(currNode.val);
	// 		newTail = newTail.next;
	// 	}
	// }

	public static void main(String[] args) {
		SinglyLinkedList list1 = new SinglyLinkedList();
		list1.createNode(1);
		list1.createNode(2);
		list1.createNode(4);

		SinglyLinkedList list2 = new SinglyLinkedList();
		list2.createNode(0);
		// list2.createNode(3);
		// list2.createNode(4);

		Solution1(list1, list2);
		Solution2(list1, list2);
		Solution3(list1, list2);
	}
}