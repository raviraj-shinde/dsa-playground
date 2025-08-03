import java.util.Arrays;
import java.util.PriorityQueue;

public class JobSequencingProblem {

    public static int sequenceJobForMaxProfite(int[][] jobAndProfits) {
        // Sort jobs by deadline descending
        Arrays.sort(jobAndProfits, (a, b) -> Integer.compare(b[0], a[0])); // Desc
        // Find max Deadline
        int maxDeadline = jobAndProfits[0][0]; // maxLastDay


        // MaxHeap based On the #Profit
        // All arrays in Java — like int[], String[], Object[] — are objects.
        // The PriorityQueue is storing references to int[] object, not primitive ints directly.
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        int totalProfit = 0;
        int i = 0;

        for (int day = maxDeadline; day >= 1; day--) {
            // pick that day -> maxHeap based on Profit [add all jobs for that day]
            while (i < jobAndProfits.length && jobAndProfits[i][0] == day) {
                maxHeap.offer(jobAndProfits[i]);
                i++;
            }

            // pick a Job & make empty maxHeap
            if (!maxHeap.isEmpty()) {
                totalProfit += maxHeap.poll()[1];
                maxHeap.clear();
            }
            // go for next day
        }

        return totalProfit;
    }

    public static void main(String[] args) {
        int[][] jobAndProfits = {
                { 4, 20 },
                { 1, 10 },
                { 1, 40 },
                { 1, 30 }
        };

        System.out.println(sequenceJobForMaxProfite(jobAndProfits));

    }
}