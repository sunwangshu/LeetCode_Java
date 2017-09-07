/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz069;

/**
 * https://leetcode.com/problems/sqrtx/description/
 * Implement int sqrt(int x).

Compute and return the square root of x.
 * @author sunwangshu
 */
public class Quiz069 {

    public static int mySqrt(int x) {
        if (x <= 0) return 0;
        // otherwise <=0 will return 0 really?? Nope
        else {
            // thoughts: mid search between 1 - x;
            int left = 1;
            int right = x;
            int mid = left + (right-left) / 2;  // If right is maxInt, then (left + right)/2 may cause overflow. It's just safe in Java.
            while (left+1 < right) {
                if (mid > x/mid) {
                    right = mid;
                } else {
                    left = mid;
                }
                mid = left + (right-left) / 2;
            }
            return mid;
        } 
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int input = 1;
        int test = mySqrt(input);
        System.out.println(test);
        System.out.println(test*test);
        System.out.println((test+1)*(test+1));
    }
    
}
