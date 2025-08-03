public class SearchInRotatedSortedArray {
    public static int searchInRotatedSortedArray(int[] arr, int target, int si, int ei) {
        // base condition
        if (si > ei) return -1;

        int mid = si + (ei - si) / 2;
        if (arr[mid] == target) return mid;

        // mid lie on line 1
        if (arr[si] <= arr[mid]) {
            // case 1 : left of mid
            if (arr[si] <= target && target <= arr[mid]) {
                return searchInRotatedSortedArray(arr, target, si, mid);
            }
            // case 2 : right of mid
            else {
                return searchInRotatedSortedArray(arr, target, mid + 1, ei);
            }
        }

        // mid lie on line 2
        else {
            // case 1 : righ of mid
            if (arr[mid] <= target && target <= arr[ei]) {
                return searchInRotatedSortedArray(arr, target, mid + 1, ei);
            }
            // case 2 : left of mid
            else {
                return searchInRotatedSortedArray(arr, target, si, mid);
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;

        System.out.println(searchInRotatedSortedArray(arr, target, 0, arr.length-1));
    }
}
