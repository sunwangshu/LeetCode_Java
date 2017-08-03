/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz009;

/**
 *
 * @author sunwangshu
 * Determine whether an integer is a palindrome. Do this without extra space.
 */


public class Quiz009 {
    public static boolean isPalindrome2(int x) {
        // top 1
        if(x <10 && x >-1) return true;
        int input = x;
        int rev = 0;
        while(x>0) {
            rev= rev*10 + (x%10) ;
            x =x/10 ;
        }
        if(rev == input) return true;
        
        return false;
    }
    
    public static boolean isPalindrome2_2(int x) {
        // top 1, edited
        if(x <10 && x >-1) return true;
        // added
        if(x % 10 == 0) {   // 0 is excluded. Not really saving time but doing extra mod.
            return false;
        }
        int input = x;
        int rev = 0;
        while(x>0) {    // so negative stuff is avoided
            rev= rev*10 + (x%10) ;
            x =x/10 ;
        }
        if(rev == input) return true;   // and if overflow it must not equal O.O
        
        return false;
    }
    
    public static boolean isPalindrome2_3(int x) {
        // top 1, edited
        if(x <10 && x >-1) return true;
        int input = x;
        int rev = 0;
        boolean first = true;
        while(x>0) {
            int tail = x%10;
            if (first) {
                if (tail == 0) {
                    return false;
                }
            }
            first = false;
            rev= rev*10 + tail ;
            x =x/10 ;
        }
        if(rev == input) return true;
        
        return false;
    }
    
    public static boolean isPalindrome(int x) {
        int result = 0;
        int divisor = x;
        if (divisor < 0) {              //  || (divisor != 0 && divisor % 10 == 0) this will slow the exp
            return false;
        }
        while (divisor != 0 ) {
            int tail = divisor % 10; 
            int newResult = result * 10 + tail;
            if ((newResult - tail)/ 10 != result) {     // why removing this will slow it???
                return false;
            }
            divisor = divisor / 10;
            result = newResult;
        }
        if (result == x) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean result = isPalindrome(-12321);
        System.out.println(result);
    }
    
}
