
// // Method 1: When TC for push is 0(n)
// import java.util.Stack;

// class MyQueue {

//     Stack<Integer> s;
//     Stack<Integer> aux_s;

//     public MyQueue() {
//         s = new Stack<>();
//         aux_s = new Stack<>();

//         // TC = 0(1), SC = 0(n);

//         // Space Complexity (SC): O(1) + O(n)
//         // The auxiliary space required for creating the stacks is negligible at initialization (O(1)), but the overall space depends on the elements stored in s, which can hold up to n elements.

//         // So, TC = O(1), SC = O(1) + O(n) for stack storage
//     }
    
//     public void push(int x) {       
//         // Move all elements from stack to aux_stack
//         while(!s.isEmpty()){
//             aux_s.push(s.pop());
//         }
        
//         // Push element to stack
//         s.push(x);
        
//         // Bring elements back from aux stack to stack
//         while(!aux_s.isEmpty()){
//             s.push(aux_s.pop());
//         }
//         System.out.println("Enqueue: " + x);

//         // TC = 0(n), SC = 0(1);
//     }
    
//     public int pop() {
//         if(s.isEmpty()){
//             throw new IllegalStateException("Underflow");
//         }
        
//         return s.pop();

//         // TC = 0(1), SC = 0(1);
//     }
    
    
//     public int peek() {
//         if(s.isEmpty()){
//             throw new IllegalStateException("Queue Empty");
//         }
        
//         return s.peek();

//         // TC = 0(1), SC = 0(1);
//     }
    
//     public void display(){
//         System.out.print("Queue:  ");
//         for(int i=s.size()-1; i>=0; i--){
//             System.out.print(s.get(i) + " ");
//         }
//         System.out.println();
//         System.out.println();

//         // TC = 0(n), SC = 0(1);
//     }
    
//     public boolean empty() {
//         return s.isEmpty();

//         // TC = 0(1), SC = 0(1);
//     }

//     public static void main(String[] args) {
//         MyQueue que = new MyQueue();
//         que.push(8);
//         que.push(9);
//         que.push(10);
//         que.display();

//         int pop;
//         pop = que.pop();
//         System.out.println("Dequeue: " + pop);

//         pop = que.pop();
//         System.out.println("Dequeue: " + pop);
//         que.display();
        
//         que.push(5);
//         que.push(12);
//         int top = que.peek();
//         System.out.println("Top: " + top);
//         que.display();

//         // TC = 0(n), due to display()
//         // SC = 0(n), due to stack creation when we make object of MyQue class
//     }
// }




// Method 2: When each opertaion (push(), pop(), peek(), empty()) is amortized 0(1) Time complexity
import java.util.Stack;

class MyQueue {

    Stack<Integer> s;
    Stack<Integer> aux_s;

    public MyQueue() {
        s = new Stack<>();
        aux_s = new Stack<>();

        // TC = 0(1), SC = 0(n);

        // Space Complexity (SC): O(1) + O(n)
        // The auxiliary space required for creating the stacks is negligible at initialization (O(1)), but the overall space depends on the elements stored in s, which can hold up to n elements.

        // So, TC = O(1), SC = O(1) + O(n) for stack storage
    }
    
    public void push(int x) {       
        s.push(x);
        System.out.println("Enqueue: " + x);
        // TC = 0(1), SC = 0(1);
    }
    
    public int pop() {
        if(aux_s.isEmpty()){
            if(!s.isEmpty()){
                while(!s.isEmpty()){
                    aux_s.push(s.pop());
                }
            }else{
                throw new IllegalStateException("Underflow");
            }
        }
        return aux_s.pop();
        // TC = Amortized 0(1), 

        // Amortized O(1), Worst-case O(n). In the worst case scenario when stack s2 is empty, the algorithm pops n elements from stack s1 and pushes n elements to s2, where n is the queue size. This gives 2n operations, which is O(n). But when stack s2 is not empty the algorithm has O(1) time complexity
        
        // SC = 0(1);
    }
    
    
    public int peek() {
        if(aux_s.isEmpty()){
            if(!s.isEmpty()){
                while(!s.isEmpty()){
                    aux_s.push(s.pop());
                }
            }else{
                throw new IllegalStateException("Underflow");
            }
        }
        return aux_s.peek();

        // TC = Amortized 0(1), SC = 0(1);

        // Amortized O(1), Worst-case O(n). In the worst case scenario when stack s2 is empty, the algorithm pops n elements from stack s1 and pushes n elements to s2, where n is the queue size. This gives 2n operations, which is O(n). But when stack s2 is not empty the algorithm has O(1) time complexity
    }
    
    public void display(){
        System.out.print("Queue:  ");
        for(int i=aux_s.size()-1; i>=0; i--){
            System.out.print(aux_s.get(i) + " ");
        }
        for(int i=0; i<s.size(); i++){
            System.out.print(s.get(i) + " ");
        }
        System.out.println();
        System.out.println();

        // TC = 0(n), SC = 0(1);
    }
    
    public boolean empty() {
        // returns true when queue is empty()
        return s.isEmpty() && aux_s.isEmpty();

        // TC = 0(1), SC = 0(1);
    }

    public static void main(String[] args) {
        MyQueue que = new MyQueue();
        que.push(8);
        que.push(9);
        que.push(10);
        que.display();

        int pop;
        pop = que.pop();
        System.out.println("Dequeue: " + pop);

        pop = que.pop();
        System.out.println("Dequeue: " + pop);
        que.display();
        
        que.push(5);
        que.push(12);
        int top = que.peek();
        System.out.println("Top: " + top);
        que.display();

        // TC = 0(n), due to display()
        // SC = 0(n), due to stack creation when we make object of MyQue class
    }
}
