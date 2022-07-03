
class Solution {

  public static void main(String[] args) {
    ListNode n1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
    ListNode n2 = new ListNode(1, new ListNode(2));
    Solution solution = new Solution();
    System.out.println(solution.isPalindrome(n1));
    System.out.println(solution.isPalindrome(n2));
  }
  public boolean isPalindrome(ListNode head) {
    StringBuilder builder = new StringBuilder();
    while (head.next != null) {
      builder.append(head.val);
      head = head.next;
    }
    builder.append(head.val);

    for (int i = 0; i < builder.length() / 2; i++) {
      if (builder.charAt(i) != builder.charAt(builder.length() - i - 1)) {
        return false;
      }
    }
    return true;
  }

  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}