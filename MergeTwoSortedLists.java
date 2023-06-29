
 // Definition for singly-linked list.
 class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }


public class MergeTwoSortedLists {
    public static void main(String[] args) {

    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode mergedList = null;   // setting up new merged list

        // base case, if any of the lists are empty
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // to save head of merged list, determine the start of the list before iterating through
        if (list1.val < list2.val) {
            mergedList = list1;
            list1 = list1.next;
        } else {
            mergedList = list2;
            list2 = list2.next;
        }

        ListNode head = mergedList;     // saving this value to return later

        while (list1 != null && list2 != null) {
            ListNode temp = null;   // going to store value of listnode temporarily
            if (list1.val < list2.val) {        // whichever value is greater, add to new mergedlist
                temp = list1;
                list1 = list1.next;     // only traverse through the list that node has been added, other list may still have values that are greater
            } else {
                temp = list2;
                list2 = list2.next;
            }
            mergedList.next = temp;     // setting the smaller of the two as the next node up
            mergedList = mergedList.next;   // make sure to iterate to end of list
        }

        if (list1 != null) {        // if one list finishes, add the rest of the nodes to the end
            mergedList.next = list1;
        } else if (list2 != null) {
            mergedList.next = list2;
        }

        return head;
    }
}



