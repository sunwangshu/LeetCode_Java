/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz021;

/**
 *
 * @author sunwangshu
 */
public class Quiz021 {
    /** 
     * Definition for singly-linked list.
     */
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode tail = head;
        while (l1!= null && l2!= null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            }
            else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 == null) tail.next = l2;
        if (l2 == null) tail.next = l1;
        return head.next;
    }
    
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        // from zwangbo
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        
        ListNode mergeHead;
        if(l1.val < l2.val){
            mergeHead = l1;
            mergeHead.next = mergeTwoLists(l1.next, l2);
        }
        else{
            mergeHead = l2;
            mergeHead.next = mergeTwoLists(l1, l2.next);
        }
        return mergeHead;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] x = {1,7};
        int[] y = {4,5,6,9,10};
        
        ListNodeGroup g1 = new ListNodeGroup(x);
        ListNodeGroup g2 = new ListNodeGroup(y);
        ListNode test = mergeTwoLists(g1.head, g2.head);
        if (test!= null) test.print();
    }
    
}
