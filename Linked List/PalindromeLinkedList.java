
import java.util.ArrayList;
import java.util.Stack;


class listNode{
    int val;
    listNode next;

    public listNode() {}
    public listNode(int val) { this.val = val; }
    public listNode(int val, listNode next) { 
        this.val = val; 
        this.next = next;
    }
}

public class PalindromeLinkedList {
    listNode head, tail;

    public PalindromeLinkedList() {
        head = tail = null;
    }

    public boolean empty(){
        return head == null && tail == null;
    }

    public void insertNode(int val){
        listNode temp = new listNode(val);
        if(empty()){
            head = tail = temp;
            return;
        }
        tail.next = temp;
        tail = temp;
    }

    public void display(){
        if(empty()){
            throw new IllegalStateException("List is empty");
        }
        listNode temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public boolean solution1(){
        // Method 1:
        // Traverse list and keep elements pushing in the stack
        // Then start comparing stack from top, and traverse the list again
        if(head == null || head.next == null){
            return true;
        }

        Stack<Integer> s = new Stack<>();
        listNode temp = head;
        while(temp != null){
            s.push(temp.val);
            temp = temp.next;
        }

        temp = head;
        while(temp != null){
            if(temp.val != s.pop()){
                return false;
            }
            temp = temp.next;
        }
        return true;

        // TC = 0(2n), SC = 0(n)
    }


    public boolean solution2(){
        // Method 2:
        // Traverse list and keep elements adding in the arrayList
        // Start comparing the arrayList from start and last
        if(head == null || head.next == null){
            return true;
        }

        ArrayList<Integer> arr = new ArrayList<>();
        listNode temp = head;
        while(temp != null){
            arr.add(temp.val);
            temp = temp.next;
        }

        int start = 0, end = arr.size()-1;
        while(start < end){
            if(arr.get(start) != arr.get(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;

        // TC = 0(n + n/2), SC = 0(n)
    }

    public void solution3(){
        // Method 3:
        // 1) Find the middle of linked list (for even length, the middle should be the first of two middle nodes)
        // 2) Reverse the second half linkedList
        // 3) Start comparing linkedList from start and middle(reversed) OR start comparing head with new head
        // 4) Reverse the newHead again so the linked may get back to its original shape(not requirement, but necessary)

        // 1) Find middle of Linked List  -- TC=0(n/2)
        listNode slow = head, fast = head;
        // using (fast.next.next != null) to get the first middle in even linked list
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle: " + slow.val);

        // 2) Reverse the remaining linkedList -- TC = 0(n/2)
        listNode newHead = reverseList(slow.next);

        // 3) Compare head with newHead -- TC = 0(n)
        listNode first = head, second = newHead;
        while (second != null) {
            if(first.val != second.val){
                reverseList(slow.next);
                System.out.println("Not a palindrom");
                return;
            }
            first = first.next;
            second = second.next;
        }
        reverseList(slow.next);
        System.out.println("palindrom");

        // TC = 0(n/2 + n/2 + n) = 0(2n) = 0(n), SC = 0(1)
    }

    public listNode reverseList(listNode head){
        if(head == null || head.next == null)
            return head;

        listNode prev = null, curr = head;
        while(curr != null){
            listNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public static void main(String[] args) {
        PalindromeLinkedList l = new PalindromeLinkedList();
        l.insertNode(1);
        l.insertNode(2);
        l.insertNode(3);
        // l.insertNode(4);
        l.insertNode(3);
        l.insertNode(2);
        l.insertNode(1);
        l.display();

        // System.out.println(l.solution1());
        // System.out.println(l.solution2());
        l.solution3();
    }
}
