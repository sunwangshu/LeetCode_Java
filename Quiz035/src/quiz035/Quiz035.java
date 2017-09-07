/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz035;

/**
 *
 * @author sunwangshu
 * 
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0
 */
public class Quiz035 {
    public static int searchInsert1(int[] nums, int target) {
        // brutal way, O(n)
        int i = 0;
        for (i = 0; i < nums.length; i++) {
            if (nums[i] >= target) return i;
        }
        return nums.length;
    }
    
    public static int searchInsert2(int[] nums, int target) {
        // split half, O(log(n))
        if (nums.length == 0) return 0;     // can be grouped
        int head = 0;
        int tail = nums.length - 1;
        while(tail - head > 0) {
            int mid = (head + tail) / 2;
            if (target > nums[mid]) head = mid + 1;
            else tail = mid;    // not mid - 1
        }
        // tail = head
        if (target > nums[head]) return head + 1;
        else return head;
    }
    
    public static int searchInsert3(int[] nums, int target) {
        // split half, O(log(n)), simplified
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (target > nums[mid]) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] test = {1, 2, 5, 6};
        int result = searchInsert3(test, 5);
        System.out.println(result);
        
    }
    
}
