// Note: BST is an example of Binary Tree. Here we are implementing BST
// In BST, duplicate elements are not allowed.

// Insertion: TC = 0(lgN), SC = 0(1)

class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val = val;
        left = right = null;
    }
}

public class Search {
    Node root;

    Search(){
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

    public boolean searchElement(int num){
        return search(root, num);

        // TC = O(log N), SC = O(1)
    }

    private boolean search(Node root, int num){
        if(root == null) return false;

        if(root.val == num) return true;

        if(num < root.val){
            return search(root.left, num);
        }else{
            return search(root.right, num);
        }
    }

    public static void main(String[] args) {
        Search bst = new Search();

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

        System.out.println("\n== Search Element: ");
        System.out.println(bst.searchElement(13));
        System.out.println(bst.searchElement(4));
        System.out.println(bst.searchElement(16));
        System.out.println();

    }
}
