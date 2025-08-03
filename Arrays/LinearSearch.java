import java.util.Arrays;

public class LinearSearch {

  public static void main(String[] args) {
    int[] nums = { 1, 2, 4, 6, 7, 5, 7, 85, 45 };

    int key = 55;
    for (int n : nums) {
        if (n == key) {
            System.out.println("Got It..!");
        }
    }
  }
}
