import java.util.LinkedList;
import java.util.Queue;

public class Tree {

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

  public static void preOrderTraversal(Node root) {
    //base condition
    if (root == null) {
      System.out.print("-1 ");
      return;
    }
    //work
    System.out.print("" + root.data + " ");
    preOrderTraversal(root.left);
    preOrderTraversal(root.right);
  }

  public static void inOrderTraversal(Node root) {
    //base condtion
    if (root == null) {
      //System.out.print(" -1");
      return;
    }
    //work

    inOrderTraversal(root.left);
    System.out.print(" " + root.data);
    inOrderTraversal(root.right);
  }

  public static void postOrderTraversal(Node root) {
    //base condition
    if (root == null) return;

    //work
    postOrderTraversal(root.left);
    postOrderTraversal(root.right);
    System.out.print(" " + root.data);
  }

  //By BFS - Queue (Null - Val), for DFS - recursion (int Level)
  public static void levelOrderTraversal(Node root) {
    //offer-poll-peek()
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

  public static int findHeight(Node node) {
    if (node == null) {
      return 0;
    }

    return Math.max(findHeight(node.left), findHeight(node.right)) + 1; //self add +1
  }

  public static int countNodes(Node root) {
    if (root == null) return 0;

    return countNodes(root.left) + countNodes(root.right) + 1;
  }

  public static void main(String[] args) {
    int[] tree = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
    idx = 0; // reset before building
    Node root = preOrderTree(tree);
    System.out.println(root.data); // should print 1
    preOrderTraversal(root);
    System.out.println("*************************");

    inOrderTraversal(root);
    System.out.println();
    postOrderTraversal(root);
    System.out.println("*************************");

    levelOrderTraversal(root);
    System.out.println("*************************");

    System.out.println("Height of Tree Root:- " + findHeight(root));
    System.out.println("*************************");

    System.out.println("Total Nodes in a Tree:- " + countNodes(root));
    System.out.println("*************************");
  }
}
