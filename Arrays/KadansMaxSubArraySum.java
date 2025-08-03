class KadansMaxSubArraySum {

  public static int kadansAlgo(int[] nums) {
    int ms = Integer.MIN_VALUE, cs = 0;
    for (int n : nums) {
      cs += n;
      ms = Math.max(ms, cs);
      if (cs < 0) {
        cs = 0;
      }
    }

    return ms;
  }

  public static void main(String[] args) {
    int[] nums = { -2, -3, -4, -1, -2, -1, -5, -3 };
    System.out.println(kadansAlgo(nums));
  }
}
