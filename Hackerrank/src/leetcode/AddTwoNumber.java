package leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode tail = new ListNode();
        ListNode res = tail;
        int carry = 0;
        while (l1!=null || l2!=null || carry == 1){
            int sum =0;
            if (carry==1) {
                sum++;
            }
            carry =0;
            if (l1!=null){
                sum+=l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                sum+=l2.val;
                l2 = l2.next;
            }
            if (sum>9){
                carry = 1;
                sum-=10;
            }
            tail.next = new ListNode(sum);
            tail= tail.next;
        }
        return res.next;
    }
}
