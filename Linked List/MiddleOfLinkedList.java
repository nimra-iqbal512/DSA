
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

public class MiddleOfLinkedList {
    listNode head, tail;

    public MiddleOfLinkedList() {
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

    public listNode solution1(){
        if(head == null || head.next == null){
            return head;
        }

        // // Method 1:
        // // Traverse the whole list to find the size, then find the middle element
        listNode temp = head;
        int size = 0;
        while(temp != null){
            size++;
            temp = temp.next;
        }
        System.out.println("Size: " + size);

        temp = head;
        for(int i = 1; i <= size/2 ; i++){
            temp = temp.next;
        }
        System.out.println("Middle element :" + temp.val);
        return temp;
        // TC = 0(n + n/2) n for finding size, n/2 to reach the middle elemen
        // SC = 0(1)
    }

    public listNode solution2(){
        if(head == null || head.next == null){
            return head;
        }

        // Method 2:
        // Use Two Pointers (Hare and Tortoise Approach), slow pointer will move one step and fast pointer will move two step
        // If the length of linked list is odd, then when fast reaches the last node (fast.next == null), then slow will be at the middle node
        // If the length of linked list is even, then when fast reaches the null(next of last node) (fast == null), then slow will be at the middle node
        listNode slow = head, fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Middle: " + slow.val);
        return slow;
    }

    public static void main(String[] args) {
        MiddleOfLinkedList l = new MiddleOfLinkedList();
        l.insertNode(3);
        l.insertNode(9);
        l.insertNode(4);
        l.insertNode(6);
        // l.insertNode(10);

        l.display();
        l.solution1();
        l.solution2();
    }
}
