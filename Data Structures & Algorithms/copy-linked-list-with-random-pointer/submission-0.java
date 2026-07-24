/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        while(temp!=null){
            Node node = new Node(temp.val);
            node.next = temp.next;
            temp.next = node;
            temp = node.next;
        }

        Node curr = head;

        while(curr!=null){
            if(curr.random != null)
            {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        Node dummy = new Node(-1);
        Node currCopy = dummy;
        while(curr!=null){
            Node copy = curr.next;

            currCopy.next = copy;
            Node original = curr;
            curr = curr.next.next;
            if(curr!=null) copy.next = curr.next;
            original.next = curr;
            currCopy = copy;
        }
        return dummy.next;
    }
}
