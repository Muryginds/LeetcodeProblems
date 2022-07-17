//https://leetcode.com/problems/reverse-linked-list/

import java.util.ArrayDeque;
import java.util.Queue;

public class Solution {

  public static void main(String[] args) {
    Solution solution = new Solution();
    ListNode n1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
    printList(solution.reverseList(n1));
  }

  public ListNode reverseList(ListNode head) {
    Queue<Integer> queue = new ArrayDeque<>();
    if (head == null) {
      return null;
    }
    do {
      queue.add(head.val);
      head = head.next;
    }
    while (head != null);
    ListNode lastNode = new ListNode(queue.poll());
    ListNode answer = lastNode;
    while (!queue.isEmpty()) {
      answer = new ListNode(queue.poll(), lastNode);
      lastNode = answer;
    }
    return answer;
  }
  static class ListNode {
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