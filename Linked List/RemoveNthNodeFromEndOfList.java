import java.util.ArrayList;
import java.util.List;

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

	public void Solution1(int n) {
        // Store all values in an arrayList
		List<Integer> arrList = new ArrayList<>();
		ListNode temp = head;
		while(temp != null){
			arrList.add(temp.val);
			temp = temp.next;
		}

		// Create Linked List from Array List, except n from end
		SinglyLinkedList list = new SinglyLinkedList();
		for(int i=0; i<arrList.size(); i++){
			if(i != arrList.size()-n){
				list.createNode(arrList.get(i));
			}
		}

		list.traverseList();

		// TC = 0(n), SC = 0(n)
    }

	public void Solution2(int n) {
		// Get size of linkedList
		int size = 0;
		ListNode temp = head;
		while (temp != null) {
			size++;
			temp = temp.next;
		}
		System.out.println("Size: " + size);

        // Remove nth node from last
		if(n == size){
			head = head.next;
		}else{
			int count = 0;
			temp = head;
			while (temp != null) {
				if(count+1 == size-n){
					temp.next = temp.next.next;
					break;
				}
				count++;
				temp = temp.next;
			}
		}
		traverseList();

		// TC = 0(n) + 0(size-n) = 0(n), 
		// In worst case, if(n==1), TC = 0(2n), However 0(2n) ~~ = 0(n)
		// SC = 0(1)
    }

	public void Solution3(int n) {
		ListNode fast = head, slow = head;
		int count = 0;
		
		// Moving fast pointer n steps ahead
		while(count < n){	
			if(fast == null){	//if value of n is greater than the size of linked list
				System.out.println("n vaue is greater than size of linked list");
				return;
			}
			fast = fast.next;
			count++;
		}
		
		// To remove the first node
		if(fast == null){
			head = head.next;
			traverseList();
			return;
		}

		// Move fast and slow nodes together
		while (fast.next != null) {
			fast = fast.next;
			slow = slow.next;
		}
		slow.next = slow.next.next;
		traverseList();

		// TC = 0(n), Although there are two loops, but fast pointer traverse the whole linkedList only once. 
		// SC = 0(1)
		

		// // Not working when n points to the second node from starting
		// ListNode fast = head, slow = null;
		// int count = 0;
		// while(fast != null){
		// 	if(count < n){
		// 		count++;
		// 	}else if(count == n){
		// 		slow = head.next;
		// 		count++;
		// 	}else{
		// 		slow = slow.next;
		// 	}
		// 	fast = fast.next;
		// }

		// if(slow == null){
		// 	head = head.next;
		// }
		// else{
		// 	System.out.println(slow.val);
		// 	slow.next = slow.next.next;
		// }
		// traverseList();
    }
}

public class RemoveNthNodeFromEndOfList {

	public static void main(String[] args) {
		SinglyLinkedList list1 = new SinglyLinkedList();
		list1.createNode(1);
		list1.createNode(2);
		list1.createNode(3);
		// list1.createNode(4);
		// list1.createNode(5);
		list1.traverseList();
		
		// list1.Solution1(2);
		// list1.Solution2(1);

		// list1.Solution3(1);
		// list1.Solution3(2);
		// list1.Solution3(3);
		list1.Solution3(4);
		
	}

}
