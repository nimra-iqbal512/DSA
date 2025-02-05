public class StackUsingArrays {
    int size;
    int top;
    int[] stack;

    public StackUsingArrays(int size){
        this.size = size;
        stack = new int[size];
        top = -1;

        // TC = 0(1), SC = 0(N)
    }
    
    public boolean isEmpty(){
        return top == -1;
        // TC = 0(1), SC = 0(1)
    }
    
    public boolean isFull(){
        return top+1 == size;
        // TC = 0(1), SC = 0(1)
    }
    
    public void push(int num){
        if(isFull()){
            System.out.println("Can't push " + num + ", Stack Overflow");
            return;
        }
        
        System.out.println("Pushed: " + num);
        stack[++top] = num;
        // TC = 0(1), SC = 0(1)
    }
    
    public int pop(){
        if(isEmpty()){
            System.out.println("Can't pop. Stack Underflow");
            return -1;
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
        
        int max = stack[top];
        for(int i=top-1; i>=0; i--){
            max = Math.max(max, stack[i]);
        }
        return max;
        // TC = 0(N), SC = 0(1)
    }
    
    public static void main(String[] args) {
        StackUsingArrays s = new StackUsingArrays(5);
        
        s.push(2);
        s.push(1);
        s.push(5);
        s.push(6);
        s.display();
        System.out.println("Max element in stack: " + s.getMax());
        
        s.push(7);
        s.push(4);
        s.display();
        System.out.println("Max element in stack: " + s.getMax());
        
        int pop;
        pop = s.pop();
        if(pop != -1){
            System.out.println("Popped element: " + pop);
        }
        pop = s.pop();
        if(pop != -1){
            System.out.println("Popped element: " + pop);
        }
        
        s.push(12);
        s.push(14);
        int top = s.peek();
        if(top != -1){
            System.out.println("Top: " + top);
        }
        
        s.display();
        
        System.out.println("size of stack: " + s.getSize());
        
        System.out.println("Max element in stack: " + s.getMax());

        
        // TC = 0(N), SC = 0(1)
    }
}
