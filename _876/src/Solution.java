
class Solution {

  public static void main(String[] args) {
    ListNode n1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    ListNode n2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
    Solution solution = new Solution();
    printList(solution.middleNode(n1));
    printList(solution.middleNode(n2));
  }
  public ListNode middleNode(ListNode head) {
    ListNode fastNode = head;
    while (fastNode != null) {
      if (fastNode.next == null) {
        break;
      }
      fastNode = fastNode.next.next;
      head = head.next;
    }
    return head;
  }

  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

  private static void printList(ListNode result) {
    var currentNode = result;

    StringBuilder sb = new StringBuilder();
    while (currentNode != null) {
      sb.append(currentNode.val);
      currentNode = currentNode.next;
    }
    System.out.println(sb);
  }
}