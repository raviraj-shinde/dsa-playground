import java.util.Arrays;

public class SelectionSort {

  public static void swap(int[] nums, int turn, int j) {
    int temp = nums[turn];
    nums[turn] = nums[j];
    nums[j] = temp;
  }

  public static void selectionSort(int[] nums) { //one slow and one fast pointer (minIndex/turn, j);
    int minIndex;
    for (int turn = 0; turn <= nums.length - 2; turn++) {
      minIndex = turn;
      for (int j = turn + 1; j <= nums.length - 1; j++) {
        if (nums[minIndex] < nums[j]) {
          swap(nums, turn, j);
        }
      }
    }
  }

  public static void main(String[] args) {
    int[] nums = { 1, 36, 54, 75, 4, 52, 1, 2, 0 };
    int[] arr = { 1, 36, 54, 75, 4, 52, 1, 2, 0 };
    int curr;
    int end;

    curr = (int) System.currentTimeMillis();
    Arrays.sort(arr);
    end = (int) System.currentTimeMillis();
    System.out.println(end - curr );

    curr = (int) System.currentTimeMillis();
    selectionSort(nums);
    end = (int) System.currentTimeMillis();
    System.out.println( end - curr);




    for (int num : nums) {
      System.out.print(num + " ");
    }
  }
}
