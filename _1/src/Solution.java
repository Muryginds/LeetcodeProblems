//https://leetcode.com/problems/two-sum/

import java.util.Arrays;

class Solution {

  public static void main(String[] args) {
    int[] n1 = {2,7,11,15};
    int t1 = 9;
    int[] n2 = {3,2,4};
    int t2 = 6;
    int[] n3 = {3,3};
    int t3 = 6;
    Solution solution = new Solution();
    System.out.println(Arrays.toString(solution.twoSum(n1, t1)));
    System.out.println(Arrays.toString(solution.twoSum(n2, t2)));
    System.out.println(Arrays.toString(solution.twoSum(n3, t3)));
  }
  public int[] twoSum(int[] nums, int target) {
    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[] {i, j};
        }
      }
    }
    return new int [] {0,0};
  }
}