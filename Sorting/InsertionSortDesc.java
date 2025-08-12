public class InsertionSortDesc {

    public static void insertionSort(int[] nums){
        for(int i = 1; i < nums.length; i++){
            int curr = nums[i];
            int prev = i - 1;

            //finding the correct position and shifting
            while(prev >= 0 && nums[prev] < curr){
                nums[prev + 1] = nums[prev];
                prev--;
            }

            //insert
            nums[prev + 1] = curr;
        }
    }

  public static void main(String[] args) {
    int[] nums = { 1, 5, 7, 8, -1, 1, 2, 15, 10 };
    insertionSort(nums);
    for (int i : nums) {
      System.out.print(i + " ");
    }
  }
}
