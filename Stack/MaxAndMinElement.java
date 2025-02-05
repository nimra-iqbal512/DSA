// / Here we find the max and min element in O(1) using 3 stacks(Main stack, max stack, min stack)

/*
Concept:
    Push Operation:
        Push the element onto the main stack.
        If the element is greater than or equal to the current maximum, push it onto the auxiliary "max stack."

    Pop Operation:
        Pop the element from the main stack.
        If the popped element is equal to the top of the max stack, pop it from the max stack as well.

    Finding Maximum:
        Simply return the top element of the max stack in O(1) time.
*/


// NOTE:
// Also we can use this stack technique, to find max or min element in other problems (like, find max elememt in queue)


// Benefit:
// In 'StackUsingArrays.java', we were accessing the max/min elm in 0(n) time, here in 0(n) space. Then why this is consider optimal?
// Suppose we need to find the max element again and again in the program. So instead of time 0(n) each time, it is better to allocate the space 0(n) only access, and access the max/min element in time 0(1)



public class MaxAndMinElement {
    int size;
    int top;
    int maxTop;
    int minTop;
    int[] stack;
    int[] maxStack;
    int[] minStack;

    public MaxAndMinElement(int size){
        this.size = size;
        stack = new int[size];
        maxStack = new int[size];
        minStack = new int[size];
        top = maxTop = minTop = -1;
        // TC = 0(1), SC = 0(N)
    }
    
    public boolean isEmpty(){
        return top == -1;
        // TC = 0(1), SC = 0(1)
    }
    
    public boolean isFull(){
        return top == size-1;
        // TC = 0(1), SC = 0(1)
    }
    
    public void push(int num){
        if(isFull()){
            System.out.println("Can't push " + num + ", Stack Overflow");
            return;
        }
        
        System.out.println("Pushed: " + num);
        stack[++top] = num;
        
        if(maxTop == -1 || num >= maxStack[maxTop]){
            maxStack[++maxTop] = num;
        }

        if(minTop == -1 || num <= minStack[minTop]){
            minStack[++minTop] = num;
        }
        // TC = 0(1), SC = 0(1)
    }
    
    public int pop(){
        if(isEmpty()){
            System.out.println("Can't pop. Stack Underflow");
            return -1;
        }
        
        if(maxStack[maxTop] == stack[top]){
            maxTop--;
        }

        if(minStack[minTop] == stack[top]){
            minTop--;
        }
        return stack[top--];
        // TC = 0(1), SC = 0(1)
    }
    
    public int peek(){
        if(isEmpty()){
            System.out.println("Stack Empty");
            return -1;
        }
        
        return stack[top];
        // TC = 0(1), SC = 0(1)
    }

    public int getSize(){
        return top + 1;
        // TC = 0(1), SC = 0(1)
    }
    
    public void display(){
        if(isEmpty()){
            System.out.println("Stack Empty");
            return;
        }
        
        for(int i=top; i>=0; i--){
            System.out.print(stack[i] + " ");
        }
        System.out.println();
        // TC = 0(N), SC = 0(1)
    }
    
    public int getMax(){
        if(isEmpty()){
            System.out.println("Stack Empty");
            return -1;
        }
        
        return maxStack[maxTop];
        // TC = 0(1), SC = 0(1)
    }

    public int getMin(){
        if(isEmpty()){
            System.out.println("Stack Empty");
            return -1;
        }
        
        return minStack[minTop];
        // TC = 0(1), SC = 0(1)
    }

    public static void main(String[] args) {
        MaxAndMinElement s = new MaxAndMinElement(5);
        
        s.push(2);
        s.push(11);
        s.push(5);
        s.push(6);
        s.display();
        System.out.println("Max element in stack: " + s.getMax());
        System.out.println("Min element in stack: " + s.getMin());
        
        s.push(7);
        s.push(1);
        s.display();
        System.out.println("Max element in stack: " + s.getMax());
        System.out.println("Min element in stack: " + s.getMin());
        
        int pop;
        pop = s.pop();
        if(pop != -1){
            System.out.println("Popped element: " + pop);
        }
        pop = s.pop();
        if(pop != -1){
            System.out.println("Popped element: " + pop);
        }
        
        s.push(0);
        s.push(14);

        int top = s.peek();
        if(top != -1){
            System.out.println("Top: " + top);
        }
        
        s.display();
        
        System.out.println("size of stack: " + s.getSize());
        
        System.out.println("Max element in stack: " + s.getMax());
        System.out.println("Min element in stack: " + s.getMin());

        
        // TC = 0(N), SC = 0(1)
    }
}
