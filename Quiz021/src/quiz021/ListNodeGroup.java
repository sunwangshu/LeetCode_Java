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
public class ListNodeGroup {
    ListNode head;
    ListNode[] nodes;
    ListNodeGroup (int[] x) {
        if (x.length > 0) {
            nodes = new ListNode[x.length];
            for (int i = 0; i < x.length ; i++) {
                nodes[i] = new ListNode(x[i]);
            }
            for (int i = 0; i < x.length-1; i++) {
                nodes[i].next = nodes[i+1];
            }
            head = nodes[0];
            head.print();
        }
    }
}
