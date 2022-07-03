//https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.HashSet;
import java.util.Set;

class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    String s1 = "abcabcbb";
    String s2 = "bbbbb";
    String s3 = "pwwkew";
    String s4 = " ";

    System.out.println(solution.lengthOfLongestSubstring(s1));
    System.out.println(solution.lengthOfLongestSubstring(s2));
    System.out.println(solution.lengthOfLongestSubstring(s3));
    System.out.println(solution.lengthOfLongestSubstring(s4));
  }
  public int lengthOfLongestSubstring(String s) {
    int longest = 0;
    int current = 0;
    char c;
    Set<Character> chars = new HashSet<>();
    for (int i = 0; i < s.length(); i++) {
      c = s.charAt(i);
      if (chars.contains(c)) {
        longest = Math.max(longest, current);
        i = s.indexOf(c, i - current);
        chars.clear();
        current = 0;
      } else {
        chars.add(c);
        current++;
      }
    }
    return Math.max(longest, current);
  }
}