public class CircularQueue {
    int size;
    int front, rear;
    int[] queue;

    public CircularQueue(int size) {
        this.size = size;
        queue = new int[size];
        front = rear = -1;
        // TC = 0(1), SC = 0(n)
    }
    
    public boolean isEmpty(){
        return front == -1 && rear == -1;
        // TC = 0(1), SC = 0(1)
    }
    
    public boolean isFull(){
        return (rear+1)%size == front;
        // TC = 0(1), SC = 0(1)
    }
    
    public void enqueue(int num){
        if(isFull()){
            System.out.println("Can't enqueue " + num + ", Overflow");
            return;
        }
        
        // If queue is empty
        if(isEmpty()){
            front = rear = 0;
        }else{
            rear = (rear+1)%size;
        }
        
        queue[rear] = num;
        System.out.println("Enqueue: " + num);
        // TC = 0(1), SC = 0(1)
    }
    
    public int dequeue(){
        if(isEmpty()){
            System.out.println("Underflow");
            return -1;
        }
        
        int temp = queue[front];
        if(front == rear){
            front = rear = -1;
        }else{
            front= (front+1)%size;
        }
        
        return temp;
        // TC = 0(1), SC = 0(1)
    }
    
    public int peek(){
        if(isEmpty()){
            System.out.println("Queue empty");
            return -1;
        }

        return queue[front];
        // TC = 0(1), SC = 0(1)
    }
    
    public void display(){
        if(isEmpty()){
            System.out.println("No element is the queue");
            return;
        }
        
        int temp = front;
        while (temp != rear) {
            System.out.print(queue[temp] + " ");
            temp = (temp + 1) % size;
        }
        System.out.print(queue[rear]);  // Print the last element
        System.out.println();
        // TC = 0(n), SC = 0(1)
    }   
    
    public static void main(String[] args) {
        CircularQueue que = new CircularQueue(5);

        que.enqueue(2);
        que.enqueue(1);
        que.enqueue(5);
        que.enqueue(6);
        que.display();
        
        que.enqueue(7);
        que.enqueue(4);
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

        que.enqueue(12);
        que.enqueue(14);
        int top = que.peek();
        if(top != -1){
            System.out.println("Top: " + top);
        }

        que.display();

        // // TC = 0(n), SC = 0(1)

    }
}

