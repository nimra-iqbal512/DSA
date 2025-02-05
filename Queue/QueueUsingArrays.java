public class QueueUsingArrays {
    int size;
    int front, rear;
    int[] queue;

    public QueueUsingArrays(int size) {
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
        return rear == size-1;
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
            rear++;
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
        if(front < rear){
            front++;
        }else if(front == rear){
            front = rear = -1;
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
        while(temp <= rear){
            System.out.print(queue[temp] + " ");
            temp++;
        }
        System.out.println();
        // TC = 0(n), SC = 0(1)
    }   
    
    public static void main(String[] args) {
        QueueUsingArrays que = new QueueUsingArrays(5);

        que.enqueue(2);
        que.enqueue(1);
        que.enqueue(5);
        que.enqueue(6);
        que.display();
        
        que.enqueue(7);
        que.enqueue(4);

        int top;
        top = que.peek();
        if(top != -1){
            System.out.println("Top: " + top);
        }
        
        int pop;
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

        // TC = 0(n), SC = 0(1)

    }
}

