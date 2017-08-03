/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz027;

/**
 *
 * @author sunwangshu
 * Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.
* 
 */
public class Quiz027 {

    public static int removeElement1_1(int[] nums, int val) {
        /** a slower runner and a faster runner, just like #026
         * if anything other than val then store it
         * nums can be empty?
         */
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;   // not return i+1
    }
    
    public static int removeElement1_2(int[] nums, int val) {
        /** oh someone point out that the element to be removed could be sparse
         *  then I can just switch it with last element and decrease the length by 1
         */
        if (nums.length == 0) return 0;
        int l = nums.length;        // could use n
        for (int j = 0; j < l; j++) {       // could use i
            if (nums[j] == val) {
                nums[j] = nums[l-1];
                l--;
            }
        }
        return l;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums = {1, 1, 2, 4, 5, 6, 6, 7, 8, 9, 9, 9, 9, 9};
        int length = removeElement1_2(nums, 6);
        System.out.println(length);
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
    
}
