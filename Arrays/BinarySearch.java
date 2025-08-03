import java.util.Arrays;

public class BinarySearch {

    public static int binarySearch(int[] nums, int key) {
        int mid;
        int first = 0, last = nums.length-1;

        while (first <= last) {
             mid = (first + last)/2;
             if(nums[mid] == key){
                return mid;
             } else if (key < nums[mid]) {
                last = mid - 1;
             } else{
                first = mid + 1;
             }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 65, 45, 23, 15, 75, 96, 45, 43};
        int[] arr = {1, 65, 45, 23, 75, 96};

        //binary search requires sorting array
        Arrays.sort(nums);
        int i = Arrays.binarySearch(nums, 43);

        i = binarySearch(nums, 43);
        System.out.println(i);

    }
}