class Node{
    int data;
    Node next;

    public Node(int data){
        this.data = data;
        next = null;

        // TC = 0(1), SC = 0(1);
    }
}

public class QueueUsingLinkedList {
    private Node front, rear;
    private int size;
    
    public QueueUsingLinkedList(){
        front = rear = null;
        size = 0;
        
        // TC = 0(1), SC = 0(1);
    }
    
    public boolean isEmpty(){
        return front == null && rear == null;

        // TC = 0(1), SC = 0(1);
    }

    public void enqueue(int data){
        Node temp = new Node(data);
        size++;

        if(isEmpty()){
            front = rear = temp;
        }else{
            rear.next = temp;
            rear = rear.next;
        }
        System.out.println("Enqueue: " + data);

        // TC = 0(1), 
        // SC = 0(1) per operation, but 0(N) overall;
    }

    public int dequeue(){
        if(isEmpty()){
            System.out.println("Can't dequeue. Underflow");
            return -1;
        }

        int temp = front.data;
        front = front.next;

        // When all elemnts are dequeued, rear is set null to represent empty queue
        if(front == null){
            rear = null;
        }
        size--;
        return temp;

        // TC = 0(1), SC = 0(1);
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Queue Empty.");
            return -1;
        }

        return front.data;

        // TC = 0(1), SC = 0(1);
    }

    public int getSize(){
        return size;

        // TC = 0(1), SC = 0(1)
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Queue Empty.");
            return;
        }

        Node temp = front;
        while(temp != null){
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();

        // TC = 0(N), SC = 0(1);
    }

    public static void main(String[] args) {
        QueueUsingLinkedList que = new QueueUsingLinkedList();

        que.enqueue(2);
        que.enqueue(1);
        que.enqueue(5);
        que.enqueue(6);
        que.display();

        int pop;
        pop = que.dequeue();
        if(pop != -1){
            System.out.println("Popped element: " + pop);
        }
        pop = que.dequeue();
        if(pop != -1){
            System.out.println("Popped element: " + pop);
        }
        pop = que.dequeue();
        if(pop != -1){
            System.out.println("Popped element: " + pop);
        }
        pop = que.dequeue();
        if(pop != -1){
            System.out.println("Popped element: " + pop);
        }
        
        que.enqueue(7);
        que.enqueue(4);
        que.display();

        int top;
        top = que.peek();
        if(top != -1){
            System.out.println("Top: " + top);
        }
        
        pop = que.dequeue();
        if(pop != -1){
            System.out.println("Popped element: " + pop);
        }
        pop = que.dequeue();
        if(pop != -1){
            System.out.println("Popped element: " + pop);
        }
        
        top = que.peek();
        if(top != -1){
            System.out.println("Top: " + top);
        }
        que.display();

        // TC = 0(N), SC = 0(1)
    }
    
}
