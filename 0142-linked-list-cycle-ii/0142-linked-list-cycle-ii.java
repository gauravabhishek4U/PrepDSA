/*
Approach : Fast and Slow Pointer
TC : O(N)
SC : O(1)
Solved : 1
*/
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        if(head == null){
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        // checking if cycle exists
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast)
            break;
        }

        if(fast == null || fast.next == null){
            return null;
        }

        ListNode ptr1 = head;
        ListNode ptr2 = slow;

        while(ptr1 != ptr2){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        return ptr1;
       
       
    }
}