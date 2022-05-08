package LinkedList;

/**
 * LC: 143
 */
public class ReorderList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    private static class Solution {
        public void reorderList(ListNode head) {

            // find the second half of the node using slow and fast pointer.
            ListNode slow = head;
            ListNode fast = head.next;

            while (fast != null && fast.next != null && slow != fast) {
                slow = slow.next;
                fast = fast.next.next;
            }

            // once we found the second half of the list, we should reverse the second half of the list

            ListNode prev = null;
            ListNode cur = slow.next;
            ListNode ahead = slow.next;
            while (ahead != null) {
                ahead = ahead.next;
                cur.next = prev;
                prev = cur;
                cur = ahead;
            }
            // update the slow node with the reversed second node which is last node in the first half of the list
            slow.next = null;

            ListNode secondHead = prev;

            ListNode newHead = null;
            ListNode support = null;
            int i = 0;

            while (head != null && secondHead != null) {
                if (i == 0) {
                    newHead = head;
                    support = newHead;
                    head = head.next;
                } else if (i % 2 == 0) {
                    support.next = head;
                    support = support.next;
                    head = head.next;
                } else {
                    support.next = secondHead;
                    support = support.next;
                    secondHead = secondHead.next;
                }
                i++;
            }

            while (head != null) {
                if (newHead == null) {
                    newHead = head;
                    support = newHead;
                }else {
                    support.next = head;
                    support = support.next;
                }
                head = head.next;
            }

            while (secondHead != null) {
                support.next = secondHead;
                support = support.next;
                secondHead = secondHead.next;
            }

        }
    }

    static void display(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "-->");
            head = head.next;
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        display(head);
        Solution solution = new Solution();
        solution.reorderList(head);
        System.out.println("Reordered list is :: ");
        display(head);

    }
}
