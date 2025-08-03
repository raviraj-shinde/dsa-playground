import java.util.*;

public class JobSequencingWithDisjointSet {
    /*
     * ✅ 2. Greedy + Disjoint Set (Union-Find)
     * This is faster than heap, especially for large n (like 10^5).
     * 
     * 🛠 Steps:
     * Sort jobs by profit descending.
     * 
     * For each job, find the latest available day ≤ its deadline.
     * 
     * Use Disjoint Set (Union-Find) to efficiently find and mark available slots.
     */
    
    static int find(int[] parent, int x) {
        if (parent[x] == x)
            return x;
        return parent[x] = find(parent, parent[x]);
    }

    static void union(int[] parent, int u, int v) {
        parent[u] = v; // mark u as taken by pointing to v (next available day)
    }

    public static int jobScheduling(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> b[1] - a[1]); // Sort by profit descending

        int maxDeadline = 0;
        for (int[] job : jobs) {
            maxDeadline = Math.max(maxDeadline, job[0]);
        }

        int[] parent = new int[maxDeadline + 1];
        for (int i = 0; i <= maxDeadline; i++)
            parent[i] = i;

        int profit = 0;

        for (int[] job : jobs) {
            int available = find(parent, job[0]);
            if (available > 0) {
                profit += job[1];
                union(parent, available, available - 1); // mark day as used
            }
        }

        return profit;
    }

    public static void main(String[] args) {
        int[][] jobs = {
                { 4, 20 },
                { 1, 10 },
                { 1, 40 },
                { 1, 30 }
        };

        System.out.println(jobScheduling(jobs)); // Output: 60
    }
}
