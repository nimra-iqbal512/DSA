class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val = val;
        left = right = null;
    }
}

public class MaxMin {
    Node root;
    
    MaxMin(){
        root = null;
    }

    public void insertNode(int val){
        root = insert(root, val);
    }

    private Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }

        if(val < root.val){
            root.left = insert(root.left, val);
        }else if(val > root.val){
            root.right = insert(root.right, val);
        }

        return root;
    }

    public void inOrderTraversal(){
        inOrder(root);
    }

    private void inOrder(Node root){
        if(root != null){
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    public void findMinIterative(){
        if(root == null) return;

        Node temp = root;
        while(temp.left != null){
            temp = temp.left;
        }

        System.out.println("Min element: " + temp.val);

        // TC = 0(lg N) for balanced BST, but 0(n) for a skewed tree, 
        // SC = 0(1)
    }

    public int findMinRecursive(){
        if(root == null) throw new IllegalStateException("Tree is empty");

        return findMin(root);

        // TC = 0(log N) for balanced BST, but 0(n) for a skewed tree, 
        // SC = 0(log N)
    }

    private int findMin(Node root){
        if(root.left == null){
            return root.val;
        }

        return findMin(root.left);
    }

    public void findMaxIterative(){
        if(root == null) return;

        Node temp = root;
        while(temp.right != null){
            temp = temp.right;
        }

        System.out.println("Max element: " + temp.val);

        // TC = 0(lg N) for balanced BST, but 0(n) for a skewed tree, 
        // SC = 0(1)
    }

    public int findMaxRecursive(){
        if(root == null) throw new IllegalStateException("Tree is empty");

        return findMax(root);

        // TC = 0(log N) for balanced BST, but 0(n) for a skewed tree, 
        // SC = 0(log N)
    }

    private int findMax(Node root){
        if(root.right == null){
            return root.val;
        }

        return findMax(root.right);
    }

    public static void main(String[] args) {
        MaxMin bst = new MaxMin();

        // bst.insertNode(50);
        // bst.insertNode(10);
        // bst.insertNode(40);
        // bst.insertNode(80);
        // bst.insertNode(60);
        // bst.insertNode(30);

        bst.insertNode(8);
        bst.insertNode(3);
        bst.insertNode(10);
        bst.insertNode(1);
        bst.insertNode(6);
        bst.insertNode(13);
        bst.insertNode(14);
        bst.insertNode(4);
        bst.insertNode(7);

        System.out.print("\n== InOrder Traversal: ");
        bst.inOrderTraversal();
        System.out.println();
        
        System.out.println("\n== Find minimum element");
        bst.findMinIterative();

        System.out.println("\n== Find minimum element");
        System.out.println(bst.findMinRecursive());
        
        System.out.println("\n== Find maximum element");
        bst.findMaxIterative();
        
        System.out.println("\n== Find maximum element");
        System.out.println(bst.findMaxRecursive());
    }
}

