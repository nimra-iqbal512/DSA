class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        next = null;

        // TC = 0(1), SC = 0(1);
    }
}

public class StackUsingLinkedList {
    private Node top;
    private int size;
    
    public StackUsingLinkedList(){
        top = null;
        size = 0;
        
        // TC = 0(1), SC = 0(1);
    }
 
    public boolean isEmpty(){
        return top == null;

        // TC = 0(1), SC = 0(1);
    }

    public void push(int data){
        Node temp = new Node(data);
        size++;

        if(isEmpty()){
            top = temp;
        }else{
            temp.next = top;
            top = temp;
        }
        System.out.println("Push: " + data);

        // TC = 0(1), 
        // SC = 0(1) per operation, but 0(N) overall;
    }

    public int pop(){
        if(isEmpty()){
            System.out.println("Can't pop. Stack Underflow");
            return -1;
        }

        int temp = top.data;
        top = top.next;
        size--;
        return temp;

        // TC = 0(1), SC = 0(1);
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack Empty.");
            return -1;
        }
        return top.data;

        // TC = 0(1), SC = 0(1);
    }

    public int getSize(){
        return size;

        // TC = 0(1), SC = 0(1)
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Stack Empty.");
            return;
        }

        Node temp = top;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();

        // TC = 0(N), SC = 0(1);
    }

    public static void main(String[] args) {
        StackUsingLinkedList s = new StackUsingLinkedList();
        
        s.push(2);
        s.push(1);
        s.push(5);
        s.push(6);
        s.display();
        
        s.push(7);
        s.push(4);
        s.display();
        
        int pop;
        pop = s.pop();
        if(pop != -1){
            System.out.println("Popped element: " + pop);
        }
        pop = s.pop();
        if(pop != -1){
            System.out.println("Popped element: " + pop);
        }
        s.display();

        s.push(12);
        s.push(14);
        int top = s.peek();
        if(top != -1){
            System.out.println("Top: " + top);
        }
        
        s.display();
        
        System.out.println("size of stack: " + s.getSize());        
        // // TC = 0(N), SC = 0(1)
    }
}