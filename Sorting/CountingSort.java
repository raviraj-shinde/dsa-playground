public class CountingSort {

    public static void countingSort(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            max = Math.max(max, n);
        }

        int[] count = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                nums[j] = i;
                j++;
                count[i]--;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = { 1, 36, 54, 75, 4, 52, 1, 2, 0 };

        countingSort(nums);

        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}