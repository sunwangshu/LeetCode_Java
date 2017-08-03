/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz026;

/**
 * LeetCode #026 
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
     * Do not allocate extra space for another array, you must do this in place with constant memory.
     * For example, Given input array nums = [1,1,2],
     * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
     *
 * @author sunwangshu
 */
public class Quiz026 {
    /**
     *  @param nums
     * @return removes duplicate in nums, and return the length of new array
     */
    public static int removeDuplicates1_1(int[] nums) {
        // 15ms, beats 30%

        // focus on the work :)
        // I want to loop over the stuff
        // scan over each element
        // have a var register the count of each unique val
        // have a var register the last val
        // until finding a duplicate, mark it as available space
        // until finding a new unique val, move it to the available space
        // return the unique counter
        if (nums.length < 2) return nums.length;
        else {
            int lastNum = nums[0];
            int insertPos = 1;
            int scout = 1;
            int count = 1;
            while (scout < nums.length) {
                if (nums[scout] != lastNum) {
                    nums[insertPos] = nums[scout];
                    lastNum = nums[scout];
                    insertPos++;
                    count++;
                }
                scout++;
            }
            return count;
        }
    }
    
    public static int removeDuplicates1_2(int[] nums) {
        // 12ms, beats 90%

        // have a pointer register the tail of processed
        // have a scout to find new value
        // have a lastNum to track last number.
        
        // insight: tail of processed array can serve as counter
        // insight: tail of processed array can serve as insert pos
        // insight: can use for loop instead of while. Can use for (int i: nums) to decrease time of accessing nums[scout]
        // question: should I keep the lastNum to decrease time of accessing nums[tail]?
        // In this ver I'll incorporate first two insights
        if (nums.length < 2) return nums.length;
        else {
            int lastNum = nums[0];
            int tail = 0;
            int scout = 1;
            while (scout < nums.length) {
                if (nums[scout] != lastNum) {
                    nums[tail+1] = nums[scout];
                    lastNum = nums[scout];
                    tail++;
                }
                scout++;
            }
            return tail+1;
        }
    }
    
    public static int removeDuplicates1_3(int[] nums) {
        /**
         * v3 simply changing while to for loop
         * 12ms, beats 90%
            * have a pointer register the tail of processed
            * have a lastNum to track last number.
            * have a scout to find new value
         */

        if (nums.length < 2) return nums.length;
        else {
            int lastNum = nums[0];
            int tail = 0;
            for (int scout = 1; scout < nums.length; scout++) {
                if (nums[scout] != lastNum) {
                    nums[tail+1] = nums[scout];
                    lastNum = nums[scout];
                    tail++;
                }
            }
            return tail+1;
        }
    }
    
    public static int removeDuplicates1_4(int[] nums) {
        /**
         * v4 intend to use "for (int i: nums)" to decrease time of accessing nums[scout]
         * 13ms, beats 70%
            * have a pointer register the tail of processed
            * have a lastNum to track last number.
         * conclusion: for (int i: nums) is slightly more costly, or is not so different from for ( ; ; )
         */

        if (nums.length < 2) return nums.length;
        else {
            int lastNum = nums[0];
            int tail = 0;
            for (int i : nums) {
                if (i != lastNum) {
                    nums[tail+1] = i;
                    lastNum = i;
                    tail++;
                }
            }
            return tail+1;
        }
    }
    
    public static int removeDuplicates1_5(int[] nums) {
        /**
         * v5 delete lastNum to see accessing nums[tail] is more costly
         * ohh not really, I can get rid of lastNum = nums[scout], which could possibly increase the efficiency
         * 16ms, beats 20%
         * 12ms beats 90%  (don't know how it worked..)
         * 12ms beats 90%
         * OJ is not very stable so take it easy :)
            * have a pointer register the tail of processed
            * have a scout to find new value
         */

        if (nums.length < 2) return nums.length;
        else {
            int tail = 0;
            for (int scout = 1; scout < nums.length; scout++) {
                if (nums[scout] != nums[tail]) {
                    nums[tail+1] = nums[scout];
                    tail++;
                }
            }
            return tail+1;
        }
    }
    
    public static int removeDuplicates1_6(int[] nums) {
        /**
         * v6 recite, keep it simple
         */
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;        // save one more addition, very concise
                nums[i] = nums[j];
            }
        }
        return i+1;
    }
    
    public static int removeDuplicates2(int[] nums) {
        /** from LeetCode
         * 
         */
        int i=1;
        int j=0;
        
        while(i<nums.length){
            if(nums[j]==nums[i]){
                i++;
            }else{
                j++;
                nums[j]=nums[i];
                i++;
            }
            
        }
        return j+1;
    }
    
    public static int removeDuplicates3(int[] nums) {
        // from official LeetCode article
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums = {1, 1, 2, 4, 5, 6, 7, 8, 9, 9, 9, 9, 9};
        int length = removeDuplicates1_6(nums);
        System.out.println(length);
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
    
}
