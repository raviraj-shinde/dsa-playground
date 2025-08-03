public class SwapReverseArray {

    public static void swapArrElements(int[] nums){
        for (int first = 0; first <= Math.floor(nums.length/2); first++) {
            int end = (nums.length - 1) - first;

            int temp = nums[end];
            nums[end] = nums[first];
            nums[first] = temp;
        }
    }

    //Best way
        public static void swapArrElementsByWhile(int[] nums){
            int first = 0;
            int last = nums.length - 1;

            //same as first < last condition
            while (!(first > last)) {
                int temp = nums[first];
                nums[first] = nums[last];
                nums[last] = temp;
                first++; last--;
            }
    }


    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        swapArrElements(nums);
        swapArrElementsByWhile(nums);

        for(int n : nums){
            System.out.print(n + " ");

        }
    }
}