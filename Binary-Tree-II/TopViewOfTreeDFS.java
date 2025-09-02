import java.util.*;

public class TopViewOfTreeDFS {

    static class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

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
            System.out.println();
        }
    }

    // Helper class for map values
    static class Pair {
        int val;
        int level;
        Pair(int val, int level) {
            this.val = val;
            this.level = level;
        }
    }

    static void dfs(Node root, int hd, int level, Map<Integer, Pair> map) {
        if (root == null) return;

        // If hd not present OR found a node at smaller depth
        if (!map.containsKey(hd) || level < map.get(hd).level) {
            map.put(hd, new Pair(root.data, level));
        }

        // DFS left and right
        dfs(root.left, hd - 1, level + 1, map);
        dfs(root.right, hd + 1, level + 1, map);
    }

    static void topViewOfBinaryTreeDFS(Node root) {
        if (root == null) return;

        Map<Integer, Pair> map = new TreeMap<>(); // keeps keys sorted
        dfs(root, 0, 0, map);

        for (Map.Entry<Integer, Pair> entry : map.entrySet()) {
            System.out.print(entry.getValue().val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Example Tree 1
        Integer[] arr1 = { 1, 2, 3, 4, 5, 6, 7 };
        Node root1 = buildTree(arr1);
        System.out.println("Level Order (Tree 1):");
        levelOrder(root1);
        System.out.print("Top View DFS (Tree 1): ");
        topViewOfBinaryTreeDFS(root1);

        // Example Tree 2
        Integer[] arr2 = { 1, 2, 3, null, 4, null, null, null, 5, null, 6 };
        Node root2 = buildTree(arr2);

        System.out.println("\nLevel Order (Tree 2):");
        levelOrder(root2);
        System.out.print("Top View DFS (Tree 2): ");
        topViewOfBinaryTreeDFS(root2);
    }
}
