import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/contains-duplicate/

class Solution {

  public static void main(String[] args) {
    int[] testArray1 = {1,2,3,1};
    int[] testArray2 = {1,2,3,4};
    int[] testArray3 = {1,1,1,3,3,4,3,2,4,2};
    Solution solution = new Solution();
    System.out.println(solution.containsDuplicate(testArray1));
    System.out.println(solution.containsDuplicate(testArray2));
    System.out.println(solution.containsDuplicate(testArray3));
  }

  public boolean containsDuplicate(int[] nums) {
    Set<Integer> numbers = new HashSet<>();
    for (int num : nums) {
      if (numbers.contains(num)) {
        return true;
      }
      numbers.add(num);
    }
    return false;
  }
}