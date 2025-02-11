class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val = val;
        left = right = null;
    }
}

public class BSTdeletion {
    Node root;

    BSTdeletion(){
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

    public void deleteNode(int num){
        root = delete(root, num);

        // TC = 0(h), SC = 0(h), where h is the height of BST
        
    }

    private Node delete(Node root, int num){
        if(root == null) return root;   // Base case

        if(num < root.val){
            root.left = delete(root.left, num);
        }else if(num > root.val){
            root.right = delete(root.right, num);
        }else{  //If node to deleted found

            // if the deleted node has no child, or right child
            if(root.left == null) return root.right;
            
            // if the deleted node has left child
            if(root.right == null) return root.left;

            // If the deleted node has both child
            Node successor = getSuccessor(root);
            root.val = successor.val;
            root.right = delete(root.right, successor.val);
        }

        return root;
    }

    private Node getSuccessor(Node curr){
        curr = curr.right;      // Move to right subtree

        while(curr.left != null){   // Find left most node
            curr = curr.left;
        }
        return curr;
    }

    public static void main(String[] args) {
        BSTdeletion bst = new BSTdeletion();

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
        
        bst.deleteNode(10);
        bst.deleteNode(8);
        bst.deleteNode(20);
        
        System.out.print("\n== After deletion   : ");
        bst.inorderTraversal();
        System.out.println();
    }
}
