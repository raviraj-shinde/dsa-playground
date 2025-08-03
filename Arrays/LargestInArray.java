public class LargestInArray {

    public static void main(String[] args) {
        int[] nums = {55, 65, 45, 328, 75, 12};

        int max = Integer.MIN_VALUE;

        for (int n : nums) {
            max = Math.max(max, n);
        }

        System.out.println(max);
    }
}