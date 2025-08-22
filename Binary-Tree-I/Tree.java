import java.lang.reflect.Array;
import java.util.ArrayList;
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
    // base condition
    if (root == null) {
      System.out.print("-1 ");
      return;
    }
    // work
    System.out.print("" + root.data + " ");
    preOrderTraversal(root.left);
    preOrderTraversal(root.right);
  }

  public static void inOrderTraversal(Node root) {
    // base condtion
    if (root == null) {
      // System.out.print(" -1");
      return;
    }
    // work

    inOrderTraversal(root.left);
    System.out.print(" " + root.data);
    inOrderTraversal(root.right);
  }

  public static void postOrderTraversal(Node root) {
    // base condition
    if (root == null) return;

    // work
    postOrderTraversal(root.left);
    postOrderTraversal(root.right);
    System.out.print(" " + root.data);
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

  public static int findHeight(Node node) {
    if (node == null) {
      return 0;
    }

    return Math.max(findHeight(node.left), findHeight(node.right)) + 1; // self add +1
  }

  public static int countNodes(Node root) {
    if (root == null) return 0;

    return countNodes(root.left) + countNodes(root.right) + 1;
  }

  public static int sumOfNodes(Node root) {
    if (root == null) return 0;
    return sumOfNodes(root.left) + sumOfNodes(root.right) + root.data; // self
  }

  //My Way - may be contains bugs - it's right I checked (-+-)
  //Approch -> store dia = (left + right height) each time
  //there is a same approach also like making static dia = Math.max(dia, lHeight, rHeight + 1); for each node
  public static int diameterOfTree(Node root, ArrayList<Integer> diameters) {
    if (root == null) return 0;

    int left = diameterOfTree(root.left, diameters);
    int right = diameterOfTree(root.right, diameters);

    // diameter passing through this node
    int dia = left + right;
    diameters.add(dia);

    // return height of this subtree
    return Math.max(left, right) + 1;
  }

  public static int mainDiameterOfTree(Node root) {
    ArrayList<Integer> diameters = new ArrayList<>();
    diameterOfTree(root, diameters);

    // get max diameter across all nodes
    return (
      diameters.stream().reduce(Integer.MIN_VALUE, (a, b) -> Math.max(a, b))
    ) + 1; //self
  }

  //Good Way -- It's was all about height of left - right each time
  static class Info {

    int diameter;
    int height;

    public Info(int d, int h) {
      this.diameter = d;
      this.height = h;
    }
  }

  //Imagine you are at last node - DFS
  public static Info diameter(Node node) {
    if (node == null) {
      return new Info(0, 0);
    }

    //Get Left & right info
    Info lInfo = diameter(node.left);
    Info rInfo = diameter(node.right);

    //build my Info
    int diameter = Math.max(
      Math.max(lInfo.diameter, rInfo.diameter),
      lInfo.height + rInfo.height + 1
    ); //for leaf (0, (0, (0 + 0 + 1)))

    int height = Math.max(lInfo.height, rInfo.height) + 1;

    return new Info(diameter, height);
  }

  public static void main(String[] args) {
    int[] tree = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };
    int[] tree2 = {
      1,
      2,
      4,
      9,
      10,
      -1,
      -1,
      -1,
      -1,
      5,
      -1,
      6,
      -1,
      7,
      -1,
      -1,
      3,
    };
    idx = 0; // reset before building
    Node root = preOrderTree(tree);
    idx = 0;
    Node root2 = preOrderTree(tree2);

    preOrderTraversal(root);
    System.out.println("\n *************************");

    inOrderTraversal(root);
    System.out.println("\n *************************");

    postOrderTraversal(root);
    System.out.println("\n *************************");

    levelOrderTraversal(root2);
    System.out.println("*************************");

    System.out.println("Height of Tree Root:- " + findHeight(root));
    System.out.println("*************************");

    System.out.println("Total Nodes in a Tree:- " + countNodes(root));
    System.out.println("*************************");

    System.out.println(
      "Total Sum  of a Nodes data in Tree:- " + sumOfNodes(root)
    );
    System.out.println("*************************");

    System.out.println("Diameter of a Tree:- " + mainDiameterOfTree(root2));
    System.out.println("*************************");

    System.out.println("Diameter of a Tree:- " + diameter(root2).diameter);
    System.out.println("*************************");
  }
}
