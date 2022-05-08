package LinkedList;

public class RemoveKthNodeFromEndOfList {

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
        public ListNode removeNthFromEnd(ListNode head, int n) {

            if (head == null) return null;

            int len = 0;
            for (ListNode cur = head; cur != null; cur = cur.next) {
                len++;
            }

            int nodeToBeDeleted = len - n; // 5 - 2 = 3

            if ( nodeToBeDeleted >= 0 ) {
                int i = 0;
                ListNode temp = head;
                ListNode left = head;
                while (i < nodeToBeDeleted && temp != null) {
                    temp = temp.next;
                    left = left.next;
                    i++;
                }

                if (temp.next == null) {
                    left.next = null;
                }else {
                    left.next = temp.next.next;
                }

            }

            return head;
        }
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        Solution solution = new Solution();
        System.out.println(":: delete 2nd node from last :: " + solution.removeNthFromEnd(listNode, 2));

        ListNode node = null;
        System.out.println(solution.removeNthFromEnd(node, 6));

        // o/p: 1-2-3
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(solution.removeNthFromEnd(head, 5));

        //o/p: null
        ListNode head2 = new ListNode(1);
        System.out.println(solution.removeNthFromEnd(head2, 1));

        //o/p:  2
        ListNode head3 = new ListNode(1, new ListNode(2));
        System.out.println(solution.removeNthFromEnd(head3, 2));
    }
}
