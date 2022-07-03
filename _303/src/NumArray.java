class NumArray {

  public static void main(String[] args) {
    NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
    System.out.println(numArray.sumRange(0,2));
    System.out.println(numArray.sumRange(2,5));
    System.out.println(numArray.sumRange(0,5));

    System.out.println("------------");
    NumArray numArray2 = new NumArray(
        new int[]{-8261,2300,-1429,6274,9650,-3267,1414,-8102,6251,-5979,-5291,-4616,-4703});
    System.out.println(numArray2.sumRange(0,8));
    System.out.println(numArray2.sumRange(4,5));
    System.out.println(numArray2.sumRange(9,11));
  }

  private int [] nums;

  public NumArray(int[] nums) {
    this.nums = nums;
  }

  /* public int sumRange(int left, int right) {
    return Arrays.stream(nums).skip(left).limit(right - left + 1).sum();
  }*/

  public int sumRange(int left, int right) {
    int result = 0;
    for (int i = left; i <= right; i++) {
      result += nums[i];
    }
    return result;
  }
}