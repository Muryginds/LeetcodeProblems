//https://leetcode.com/problems/first-bad-version/

import java.util.HashSet;
import java.util.Set;

public class Solution extends VersionControl {

  public static void main(String[] args) {
    Solution solution = new Solution();
    System.out.println(solution.firstBadVersion(2));
  }

  public int firstBadVersion(int n) {
    Set<Integer> checked = new HashSet<>();
    int bad = 1;
    int first = 0;
    int last = n;
    int mid = 0;
    while (first <= last) {
      mid = (last - first) / 2 + first;
      if (checked.contains(mid)) {
        break;
      }
      if (isBadVersion(mid)) {
        bad = mid;
        last = mid - 1;
      } else {
        first = mid + 1;
      }
      checked.add(mid);
    }
    return bad;
  }
}

class VersionControl {
  boolean isBadVersion(int version) {
    return version >= 2;
  }
}
