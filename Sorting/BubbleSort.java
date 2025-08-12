public class BubbleSort {

  public static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void bubbleSort(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = 0; j < ((nums.length - 1) - i); j++) {
        if (nums[j] > nums[j + 1]) {
          swap(nums, j, j+1);
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = { 5, 7, 4, 2, 1, 6, 95, 0 };
    //int[] nums = {0};

    bubbleSort(nums);
    for (int n : nums) {
      System.out.print(n + " ");
    }
  }
}
