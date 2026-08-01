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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode temp1 = l1;
        ListNode temp2 = l2;

        int carry = 0;

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while(temp1!=null && temp2 !=null){
            int value = temp1.val + temp2.val + carry;
            carry = value/10;
            ListNode node = new ListNode(value%10);
            curr.next = node;
            curr = curr.next;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        while(temp1!=null ){
            int value = temp1.val + carry;
            carry = value/10;
            ListNode node = new ListNode(value%10);
            curr.next = node;
            temp1 = temp1.next;
            curr = curr.next;
        }

        while(temp2 !=null){
            int value = temp2.val + carry;
            carry = value/10;
            ListNode node = new ListNode(value%10);
            curr.next = node;
            curr = curr.next;
            temp2 = temp2.next;
        }

        if(carry !=0){
            ListNode node = new ListNode(carry);
            curr.next = node;
        }

        return dummy.next;


    }
}
