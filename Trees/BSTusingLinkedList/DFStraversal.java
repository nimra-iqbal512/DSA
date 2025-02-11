// The inorder traversal always return values in ascending order
// Root is always the first elment in preorder traversal
// Root is always the last elment in postorder traversal

// Traversal(inorder, preOrder, postOrder, usingExplicitStack): TC = 0(n), SC = 0(log N) for balanced BST, SC = 0(N) for skewed BST
// DFS --> inorder, preorder, postorder (recursive approach that use implicit stack)
// DFS --> implemented dfsUsingstack gives same output as preorder (iterative approach that use explicit stack)

import java.util.Stack;

class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val = val;
        left = right = null;
    }
}

public class DFStraversal {
    Node root;

    DFStraversal(){
        root = null;
    }

    public void insertNode(int val){
        root = insert(root, val);

        // TC = 0(log n), SC = 0(1)
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

    public void inorderTraversal(){
        inOrder(root);

        // TC = 0(n), SC = 0(logn)
    }

    private void inOrder(Node root){ //(left, root, right)
        if(root != null){
            inOrder(root.left);
            System.out.print(root.val + " ");
            inOrder(root.right);
        }
    }

    public void preorderTraversal(){
        preOrder(root);

        // TC = 0(n), SC = 0(logn)
    }

    private void preOrder(Node root){ //(root, left, right)
        if(root != null){
            System.out.print(root.val + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postorderTraversal(){
        postOrder(root);

        // TC = 0(n), SC = 0(logn)
    }

    private void postOrder(Node root){ //(left, right, root)
        if(root != null){
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + " ");
        }
    }

    public void dfsUsingStack(){   
        if(root == null) return;

        Stack<Node> s = new Stack<>();
        s.add(root);

        while(!s.isEmpty()){
            Node temp = s.pop();
            System.out.print(temp.val + " ");

            if(temp.right != null){
                s.push(temp.right);
            }

            if(temp.left != null){
                s.push(temp.left);
            }
        }

        // TC = 0(n), 
        // SC = 0(log n) --> due to stack. It is determined by the maximum number of elements in the stack at any given time.
    }

    public static void main(String[] args) {
        DFStraversal bst = new DFStraversal();

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
        bst.inorderTraversal();
        System.out.println();

        System.out.print("\n== PreOrder Traversal: ");
        bst.preorderTraversal();
        System.out.println();

        System.out.print("\n== PostOrder Traversal: ");
        bst.postorderTraversal();
        System.out.println();

        System.out.println("\n== DFS Traversal(Iterative Approach)");
        bst.dfsUsingStack();
        System.out.println();
        
    }
}
