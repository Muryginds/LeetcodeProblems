//https://leetcode.com/problems/longest-palindromic-substring/solution/

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.longestPalindrome("babad"));
    System.out.println(solution.longestPalindrome("cbbd"));
    System.out.println(solution.longestPalindrome("cb"));
    System.out.println(solution.longestPalindrome(""));
    System.out.println(solution.longestPalindrome("a"));
    System.out.println(solution.longestPalindrome("aacabdkacaa"));
  }

  public String longestPalindrome(String s) {
    int lastIndex = s.length() - 1;
    int revIndex;
    char first;
    char last;
    String maxLengthWord = "";
    String current;
    for (int i = 0; i <= lastIndex; i++) {
      if ((lastIndex - i) < maxLengthWord.length()) {
        break;
      }
      revIndex = lastIndex;
      first = s.charAt(i);
      last = s.charAt(revIndex);
      while (i < revIndex) {
        if (first == last) {
          current = s.substring(i, revIndex + 1);
          if (isPallindrome(current) && maxLengthWord.length() < current.length()) {
            maxLengthWord = current;
          }
        }
        last = s.charAt(--revIndex);
      }
      if (i == revIndex) {
        current = s.substring(i, revIndex + 1);
        if (maxLengthWord.length() < current.length()) {
          maxLengthWord = current;
        }
      }
    }
    return maxLengthWord;
  }

  private boolean isPallindrome(String s) {
    int lastIndex = s.length() - 1;
    for (int i = 0; i < s.length() / 2; i++) {
      if (s.charAt(i) != s.charAt(lastIndex - i)) {
        return false;
      }
    }
    return true;
  }

}