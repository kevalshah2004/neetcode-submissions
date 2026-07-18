/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list1 == null) return list2;
        else if(list2 == null) return list1;

        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        ListNode p = list1;
        ListNode q = list2;

        while(p!=null && q!=null){
            if(p.val <= q.val){
                temp.next = p;
                p = p.next;
                temp = temp.next;
            }
            else{
                temp.next = q;
                q = q.next;
                temp = temp.next;
            }
        }

        while(p!=null){
            temp.next = p;
            p = p.next;
            temp = temp.next;
        }

        while(q!=null){
            temp.next = q;
            q = q.next;
            temp = temp.next;
        }

        return dummy.next;

    }
}