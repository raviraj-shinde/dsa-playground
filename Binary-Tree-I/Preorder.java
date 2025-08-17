public class Preorder {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(){};
        public Node(int data){
            this.data = data;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    static int idx = 0; // shared index across recursion

    public static Node preOrderTree(int[] nums) {
        if (idx >= nums.length || nums[idx] == -1) { // base case
            idx++; // move index forward for parent call
            return null;
        }

        Node node = new Node(
            nums[idx++],               // consume current index
            preOrderTree(nums),        // build left subtree
            preOrderTree(nums)         // build right subtree
        );
        return node;
    }

    public static void preOrderTraversal(Node root){
        //base condition
        if(root == null){
            System.out.print("-1 ");
            return;
        }
        //work
        System.out.print("" + root.data + " ");
        preOrderTraversal(root.left); 
        preOrderTraversal(root.right);
        
    }

    public static void main(String[] args) {
        int[] tree = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
        idx = 0; // reset before building
        Node root = preOrderTree(tree);
        System.out.println(root.data); // should print 1
        preOrderTraversal(root);


    }
}
