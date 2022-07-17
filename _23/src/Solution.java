public class Solution {
  public ListNode mergeKLists(ListNode[] lists) {
    ListNode first = null;
    ListNode previous = null;
    ListNode current;
    int index = 0;
    while (index > -1) {
      index = getIndexOfListWithMinNumber(lists);
      if (index < 0) {
        continue;
      }
      current = new ListNode(lists[index].val);
      if (first == null) {
        first = current;
        previous = first;
        lists[index] = lists[index].next;
        continue;
      }
      previous.next = current;
      previous = current;
      lists[index] = lists[index].next;
    }
    return first;
  }

  private int getIndexOfListWithMinNumber(ListNode[] lists) {
    int number = Integer.MAX_VALUE;
    int index = -1;
    int current;
    for (int i = 0; i < lists.length; i++) {
      if (lists[i] == null) {
        continue;
      }
      current = lists[i].val;
      if (current < number) {
        number = current;
        index = i;
      }
    }
    return index;
  }
}

class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}