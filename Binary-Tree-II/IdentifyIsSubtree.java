import java.util.LinkedList;
import java.util.Queue;

public class IdentifyIsSubtree {

  static class Node {

    int data;
    Node left;
    Node right;

    public Node() {}

    public Node(int data) {
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
      nums[idx++], // consume current index
      preOrderTree(nums), // build left subtree
      preOrderTree(nums) // build right subtree
    );
    return node;
  }

  // By BFS - Queue (Null - Val), for DFS - recursion (int Level)
  public static void levelOrderTraversal(Node root) {
    // offer-poll-peek()
    Queue<Node> queue = new LinkedList<>();
    queue.offer(root);
    queue.offer(null);

    while (!queue.isEmpty()) {
      Node node = queue.poll();
      if (node != null) {
        System.out.print(" " + node.data);
        if (node.left != null) queue.offer(node.left);
        if (node.right != null) queue.offer(node.right);
      } else {
        System.out.println();
        if (queue.isEmpty()) return;
        queue.offer(null);
      }
    }
  }


  public static boolean isIdentical(Node root, Node subRoot){
    if (root == null && subRoot == null) return true;
    if (root == null || subRoot == null || root.data != subRoot.data) return false;
  

    return isIdentical(root.left, subRoot.left) && isIdentical(root.right, subRoot.right);
  }

  public static boolean isSubTree(Node root, Node subRoot){
    if (root == null) return false;

    if (root.data == subRoot.data) {
      if (isIdentical(root, subRoot)) {
        return true;
      }
    }

    return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
  }
  public static void main(String[] args) {
    int[] tree = { 3, 4, 1, -1, -1, 2, -1, -1, 5, -1, -1 };
    int[] tree2 = { 4, 1, -1, -1, 2 };

    idx = 0; // reset before building
    Node root = preOrderTree(tree);
    idx = 0; // reset before building
    Node root2 = preOrderTree(tree2);

    levelOrderTraversal(root);
    System.out.println("*************************");

    levelOrderTraversal(root2);
    System.out.println("*************************");

    System.out.println("isSubTree:- " + isSubTree(root, root2));
  }
}
