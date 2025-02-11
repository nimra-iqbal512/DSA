// BFS(Breadth First Serach)/orderLevelTraversal (using queue)

import java.util.LinkedList;
import java.util.Queue;

class Node{
    int val;
    Node left;
    Node right;

    Node(int val){
        this.val = val;
        left = right = null;
    }
}

public class BFStraversal {
    Node root;

    BFStraversal(){
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

    public void orderLevelTraversal(){
        if(root == null) return;

        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            Node temp = q.poll();
            System.out.print(temp.val + " ");

            if(temp.left != null){
                q.add(temp.left);
            }

            if(temp.right != null){
                q.add(temp.right);
            }
        }

        // TC = 0(n), 
        // SC = 0(n) due to queue, The queue can hold maximum half of the nodes(i.e. last level), O(N/2) ~~ O(N)
    }

    public static void main(String[] args) {
        BFStraversal bst = new BFStraversal();

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

        System.out.println("\n== OrderLevel Traversal");
        bst.orderLevelTraversal();
        System.out.println();
    }
}
