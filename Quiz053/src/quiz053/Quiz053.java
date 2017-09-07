/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz053;

/**
 *Find the contiguous subarray within an array (containing at least one number) which has the largest sum.

For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * @author sunwangshu
 */
public class Quiz053 {

    /*-------- just a way of thinking ------*/
    //
    
    // public int maxSubArray(int[] nums) {
    //     int currentMax = nums[0];
    //     for (int i = 0; i < nums.length; i++) {
    //         int maxBefore = DP(nums,i);
    //         if (maxBefore > currentMax) {
    //             currentMax = maxBefore;
    //         }
    //     }
    //     return currentMax;
    // }
    
    // public int DP(int[] nums, int i) {
    //     if (i == 0) {
    //         return nums[0];
    //     }
    //     else {
    //         int maxBefore = DP(nums, i-1);
    //         return (maxBefore > 0 ? maxBefore: 0) + nums[i];
    //     }
    // }
    /*--------- optimized ---------*/
    public static int maxSubArray(int[] nums) {
        int currentMax = nums[0];
        int maxBefore = nums[0];
        for (int i = 1; i < nums.length; i++) {
            maxBefore = (maxBefore > 0 ? maxBefore: 0) + nums[i];       // must use parenthesis
            if (maxBefore > currentMax) {
                currentMax = maxBefore;
            }
        }
        return currentMax;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray(nums);
        System.out.println(result);
    }
    
}
