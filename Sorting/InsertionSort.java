public class InsertionSort {


    public static void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int curr = arr[i];
            int prev = i-1;

            //find out the correct position of ele
            while (prev >= 0 && arr[prev] > curr) {
                arr[prev+1] = arr[prev]; //shift
                prev--;
            }

            //insertion
            arr[prev+1] = curr;
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
