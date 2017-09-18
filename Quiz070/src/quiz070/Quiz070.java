/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz070;

/**
 * https://leetcode.com/problems/climbing-stairs/description/
 * You are climbing a stair case. It takes n steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

Note: Given n will be a positive integer.


 * @author sunwangshu
 */
public class Quiz070 {
    public static int climbStairs(int n) {
        // fn = fn-1 + fn-2  // fibonacci
        // split half till end, O(log(n)), http://disq.us/p/1m5cqqi
        // f(2n) = f(n)^2 + f(n-1)^2, f(2n+1) = f(n)^2 + 2*f(n)*f(n-1)
        if (n == 0) return 1;
        else if (n == 1) return 1;
        else if (n == 2) return 2;
        else {
            if (n % 2 == 0) {
                return climbStairs(n/2)*climbStairs(n/2) + climbStairs(n/2-1) * climbStairs(n/2-1);
            } else {
                return climbStairs((n-1)/2)*climbStairs((n-1)/2) + 2*climbStairs((n-1)/2) * climbStairs((n-1)/2 - 1);
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        for (int i = 0; i <= 44; i++) {
            int ans = climbStairs(i);
            System.out.println(ans);
        }
        for (int i = 0; i < 7; i++) {
            int degree = 360 * i / 7;
            System.out.println(degree);
        } 
    }
    
}
