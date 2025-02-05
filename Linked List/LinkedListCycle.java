import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class ListNode{
	int val;
	ListNode next;
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
	ListNode storeAddress;

	public void createNode(int currentVal){

		ListNode tempNode;
		if(currentVal == -4){
			tempNode = new ListNode(currentVal, storeAddress);
		}else{
			tempNode = new ListNode(currentVal);
		}
		
		if(currentVal == 2){
			storeAddress = tempNode;	
		}

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
			int count = 0;
			while(count < 5 && tempNode != null){
				System.out.print(tempNode.val + " ");
				tempNode = tempNode.next;
				count++;
			}
			System.out.println();
		}
	}

	public boolean Solution1(){
		List<ListNode> addresses =new ArrayList<>();

		// Traverse the list, and keep adding the addresses in the arrList
		// If address already found in the arrList, means there is cycle.
		ListNode tempNode = head;
		while(!addresses.contains(tempNode) && tempNode != null){
			// System.out.println(tempNode.val);
			addresses.add(tempNode);
			tempNode = tempNode.next;
		}
		if(tempNode == null){
			return false;
		}
		return true;

		// TC = 0(n^2), TC for ArrayList.contains() is 0(n).
		// SC = 0(n)
	}

	public boolean Solution2(){
		// HashMap<ListNode, Integer> map = new HashMap<>();
		// ListNode tempNode = head;
		// while (!map.containsKey(tempNode) && tempNode != null) {
		// 	// System.out.println(tempNode.val);
		// 	map.put(tempNode, tempNode.val);
		// 	tempNode = tempNode.next;
		// }
		// if(tempNode == null){
		// 	return false;	//No cycle
		// }
		// return true;	//Contains cycle


		// // Version 2 of solution 2. Conceptually same but seems easier
		HashMap<ListNode, Integer> map = new HashMap<>();
		ListNode tempNode = head;
		while (tempNode != null) {
			if(map.containsKey(tempNode)){
				return true;
			}
			map.put(tempNode, 1);
			tempNode = tempNode.next;
		}
		return false;	
		// TC = 0(n), TC for HashMap.containsKey() and HashMap.put() is 0(1).
		// SC = 0(n)
	}

	public boolean Solution3(){
		ListNode fast = head, slow = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if(fast == slow){
				return true;
			}
		}
		return false;

		// TC = 0(n), SC = 0(1)
	}
}

public class LinkedListCycle {

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		list.createNode(3);
		list.createNode(2);
		list.createNode(0);
		list.createNode(-4);
		list.traverseList();
	
		// System.out.println(list.Solution1());
		System.out.println(list.Solution2());
		// System.out.println(list.Solution3());
	}
}
