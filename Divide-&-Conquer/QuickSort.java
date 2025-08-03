public class QuickSort {

    public static void quickSort(int[] arr, int si, int ei) {
        if (si >= ei) return;

        int pivot = partition(arr, si, ei);
        quickSort(arr, si, pivot-1);
        quickSort(arr, pivot+1, ei);
    }

    //fix the pivot(here last element)  position in array each time when it called
    public static int partition(int[] arr, int si, int ei) {
        int pivot = arr[ei];
        int i = si - 1;

        for (int j = si; j < ei; j++) {
            if (arr[j] <= arr[ei]) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        i++;
        int temp = arr[i];
        arr[i] = arr[ei];
        arr[ei] = temp;
        return i;
    }

    public static void main(String[] args) {
        int[] arr = { -5, 2, -7, 5, 6, -2, -10, 0 };
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
