// // Using 2 Queues

// import java.util.LinkedList;
// import java.util.Queue;

// class MyStack {
//     Queue<Integer> q1;
//     Queue<Integer> q2;

//     public MyStack(){
//         q1 = new LinkedList<>();
//         q2 = new LinkedList<>();
//     }
    
//     public void push(int x){
//         // // Add to q2
//         // q2.add(x);
//         // // Dequeue all from q1, and enqueue them to q2
//         // while(!q1.isEmpty()){
//         //     q2.add(q1.remove());
//         // }
//         // // Dequeue all from q2, and enqueue them to q1
//         // while(!q2.isEmpty()){
//         //     q1.add(q2.remove());
//         // }
//         // System.out.println("Pushed: " + x);

        
//         // Add to q2
//         q2.add(x);
//         // Dequeue all from q1, and enqueue them to q2
//         while(!q1.isEmpty()){
//             q2.add(q1.remove());
//         }
//         // Swap the references q1 and q2, so that q1 becomes the main stack
//         Queue<Integer> temp = q1;
//         q1 = q2;
//         q2 = temp;

//         System.out.println("Pushed: " + x);

//          // TC = 0(N), SC = 0(1)
//     }

//     public int pop(){
//         if(empty()){
//             throw new IllegalStateException("Underflow");
//         }

//         return q1.remove();
//     }

//     public int top(){
//         if(empty()){
//             throw new IllegalStateException("Underflow");
//         }

//         return q1.peek();   // Just remove the first element of q1
//     }

//     public boolean empty(){
//         return q1.isEmpty();
//     }

//     public void display(){
//         for (Integer num : q1) {
//             System.out.print(num + " ");
//         }
//         System.out.println();
//     }

//     public static void main(String[] args) {
//         MyStack s = new MyStack();
        
//         s.push(2);
//         s.push(1);
//         s.push(5);
//         s.push(6);
//         s.display();
        
//         s.push(7);
//         s.push(4);
//         s.display();
        
//         int pop;
//         pop = s.pop();
//         System.out.println("Popped element: " + pop);
//         pop = s.pop();
//         System.out.println("Popped element: " + pop);
//         s.display();

//         s.push(12);
//         s.push(14);
//         int top = s.top();
//         System.out.println("Top: " + top);
        
//         s.display();
//     }
// }


// Using 1 Queue

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> q1;

    public MyStack(){
        q1 = new LinkedList<>();
    }
    
    public void push(int x){
        q1.add(x);

        for(int i = q1.size(); i > 1; i--){
            q1.add(q1.remove());
        }

        System.out.println("Pushed: " + x);

        // TC = 0(N), SC = 0(1)

    }

    public int pop(){
        if(empty()){
            throw new IllegalStateException("Underflow");
        }

        return q1.remove();
    }

    public int top(){
        if(empty()){
            throw new IllegalStateException("Underflow");
        }

        return q1.peek();   // Just remove the first element of q1
    }

    public boolean empty(){
        return q1.isEmpty();
    }

    public void display(){
        System.out.print("Stack: ");
        for (Integer num : q1) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyStack s = new MyStack();
        
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
        System.out.println("Popped element: " + pop);
        pop = s.pop();
        System.out.println("Popped element: " + pop);
        s.display();

        s.push(12);
        s.push(14);
        int top = s.top();
        System.out.println("Top: " + top);
        
        s.display();
    }
}