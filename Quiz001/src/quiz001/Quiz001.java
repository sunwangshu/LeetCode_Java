/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz001;

/**
 *
 * @author sunwangshu
 */




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sunwangshu
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sunwangshu
 */


public class Quiz001 {
    public static int[] twoSum(int[] nums, int target) {
      int[] ans = new int[2];  
      for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0] = i;
                    ans[1] = j;
                    return ans;
                }
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        //sol = new Solution();
        int[] nums = {2,3,4};
        int target = 6;

        int[] ans = twoSum(nums, target);
        System.out.println(ans[0]);
        System.out.println(ans[1]);
      }
    
}









