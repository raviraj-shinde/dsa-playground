import java.util.*;

public class TopViewOfTree {

  // Node definition
  static class Node {

    int data;
    Node left, right;

    Node(int data) {
      this.data = data;
      left = right = null;
    }
  }

  // Tree Builder (from array with nulls for missing children)
  // Example: [1, 2, 3, null, 5]
  static Node buildTree(Integer[] arr) {
    if (arr.length == 0 || arr[0] == null) return null;

    Node root = new Node(arr[0]);
    Queue<Node> q = new LinkedList<>();
    q.add(root);

    int i = 1;
    while (!q.isEmpty() && i < arr.length) {
      Node curr = q.poll();

      if (i < arr.length && arr[i] != null) {
        curr.left = new Node(arr[i]);
        q.add(curr.left);
      }
      i++;

      if (i < arr.length && arr[i] != null) {
        curr.right = new Node(arr[i]);
        q.add(curr.right);
      }
      i++;
    }
    return root;
  }

  // Level Order Traversal (for checking structure)
  static void levelOrder(Node root) {
    if (root == null) return;
    Queue<Node> q = new LinkedList<>();
    q.add(root);

    while (!q.isEmpty()) {
      int size = q.size();
      for (int i = 0; i < size; i++) {
        Node curr = q.poll();
        System.out.print(curr.data + " ");
        if (curr.left != null) q.add(curr.left);
        if (curr.right != null) q.add(curr.right);
      }
      System.out.println(); // next level
    }
  }

  static class Info {

    Node node;
    int hd;

    public Info(Node node, int hd) {
      this.node = node;
      this.hd = hd;
    }
  }

  static void topViewOfBinaryTree(Node root) {
    Queue<Info> queue = new LinkedList<>();
    Map<Integer, Node> map = new HashMap<>();

    queue.offer(new Info(root, 0));
    int min = 0, max = 0;

    while (!queue.isEmpty()) {
      Info currInfo = queue.poll();

      if (currInfo == null) {
        if (queue.isEmpty()) break;
        queue.offer(null);
      }

      if (!map.containsKey(currInfo.hd)) map.put(currInfo.hd, currInfo.node);

      if (currInfo.node.left != null) {
        min = Math.min(min, currInfo.hd-1);
        queue.offer(new Info(currInfo.node.left, currInfo.hd - 1));
      }
      if (currInfo.node.right != null) {
        max = Math.max(max, currInfo.hd+1);
        queue.offer(new Info(currInfo.node.right, currInfo.hd + 1));
      }
    }


    for(int i = min; i <= max; i++){
        System.out.print(" " + map.get(i).data);
    }
  }

  public static void main(String[] args) {
    // Example Tree 1
    Integer[] arr1 = { 1, 2, 3, 4, 5, 6, 7 };
    Node root1 = buildTree(arr1);
    System.out.println("Level Order (Tree 1):");
    levelOrder(root1);

    // Example Tree 2
    Integer[] arr2 = { 1, 2, 3, null, 4, null, null, null, 5, null, 6 };
    Node root2 = buildTree(arr2);

    System.out.println("\nLevel Order (Tree 2):");
    levelOrder(root2);

    topViewOfBinaryTree(root2);
  }
}
