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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode oddH = head;
        ListNode evenH = head.next;
        
        ListNode odd = oddH;
        ListNode even = evenH;
        ListNode temp = head.next.next;
        
        oddH.next = null;
        evenH.next = null;
        
        int counter = 1;
        while(temp != null){
            ListNode next = temp.next;
            
            temp.next = null;
            if(counter % 2 == 1){
                odd.next = temp;
                odd = temp;
            } else {
                even.next = temp;
                even = temp;
            }
            
            counter++;
            temp = next;
        }
        
        odd.next = evenH;
        return oddH;
    }
}