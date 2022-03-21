package LinkedList;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

public class MergeTwoSortedLists {

     static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

         ListNode mergedList = null;
         ListNode nextMerged = mergedList;

         while (list1 != null) {
             ListNode temp = null;
             if (list2 == null) break;
             if (list1.val <= list2.val) {
                 temp = new ListNode(list1.val);
                 list1 = list1.next;
             }else {
                 temp = new ListNode(list2.val);
                 list2 = list2.next;
             }
             if (mergedList == null) {
                 mergedList = temp;
                 nextMerged = mergedList;
             }else if (nextMerged.next == null) {
                 nextMerged.next = temp;
                 nextMerged = nextMerged.next;
             }
         }

         while (list1 != null) {
             if (mergedList == null) {
                 mergedList = list1;
                 nextMerged = mergedList;
             }else if (nextMerged.next == null) {
                 nextMerged.next = list1;
                 nextMerged = nextMerged.next;
             }
             list1 = list1.next;
         }

         while (list2 != null) {
             if (mergedList == null) {
                 mergedList = list2;
                 nextMerged = mergedList;
             }else if (nextMerged.next == null) {
                 nextMerged.next = list2;
                 nextMerged = nextMerged.next;
             }
             list2 = list2.next;
         }

         return mergedList;
     }

    public static void main(String[] args) {

         ListNode list1 = new ListNode(1);
         list1.next = new ListNode(2);
         list1.next.next = new ListNode(4);

         ListNode list2 = new ListNode(1);
         list2.next = new ListNode(3);
         list2.next.next = new ListNode(4);

        System.out.println(mergeTwoLists(list1, list2));

    }

}
