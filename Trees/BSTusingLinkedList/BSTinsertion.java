// Note: BST is an example of Binary Tree. Here we are implementing BST
// In BST, duplicate elements are not allowed.

// Insertion(Time and Space compexity): 
// Time complexity of insertion is same as the height of BST
// For balanced BST(AVL, Red Black tree), the height h is O(log N), and for skewed BST(where elements are in sorted order), the height h is O(N)
// So, for balanced BST, TC = O(log N), For skewed BST, TC = O(N)

// SC = depth of recursion = height of BST
// So, for balanced BST, SC = O(log N), For skewed BST, SC = O(N)
// SC will be O(1), if we use iterative approach instead of recursive approach

class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val = val;
        left = right = null;
    }
}

public class BSTinsertion {
    Node root;

    BSTinsertion(){
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

    public static void main(String[] args) {
        BSTinsertion bst = new BSTinsertion();

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
    }
}
