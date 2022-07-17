//https://leetcode.com/problems/count-and-say/

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.countAndSay(5);
  }

  public String countAndSay(int n) {
    StringBuilder sb = new StringBuilder();
    String word = "";
    for (int i = 0; i < n; i++) {
      if (word.equals("")) {
        word = "1";
        continue;
      }
      int memo = -1;
      int num = -1;
      int pose = 0;
      int count = 0;
      sb.setLength(0);
      while (pose < word.length()) {
        num = word.charAt(pose) - '0';
        if (memo == -1) {
          memo = num;
        }
        if (memo == num) {
          count++;
        }
        if (memo != num) {
          sb.append(count);
          sb.append(memo);
          memo = num;
          count = 1;
        }
        pose++;
      }
      if (num != -1) {
        sb.append(count);
        sb.append(num);
      }
      word = sb.toString();
    }
    return word;
  }
}
