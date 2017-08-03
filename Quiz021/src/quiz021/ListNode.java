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
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    public void print() {
        if (this != null) {
            ListNode head = this;
            while (head!= null) {
                System.out.print(head.val + " ");
                head = head.next;
            }
            System.out.println();
        }
    }
}
