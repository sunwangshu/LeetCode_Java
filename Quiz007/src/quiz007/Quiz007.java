/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz007;
import java.util.*;

/**
 *
 * @author sunwangshu
 */
public class Quiz007 {

    /**
     * @param args the command line arguments
     */
    public static int reverse(int x) {
        // get each digit stored in an array
        int sign = x >= 0 ? 1 : -1;
        int divisor = Math.abs(x);
        List<Integer> digits = new ArrayList<Integer>();
        // keep dividing by 10, get [0], [1], etc until the result is 0
        while (divisor > 0) {
            int temp = divisor % 10;
            digits.add(temp);
            divisor = divisor /10;
        }
        // restore the number
        int result = 0;
        for (int i = 0; i < digits.size(); i++) {
            result *= 10;
            result += digits.get(i);
        }
        return result * sign;
        // if overflow then return 0
    }
    
    public static int reverse2(int x) {
        int sign = x >= 0 ? 1 : -1;
        int divisor = Math.abs(x);
        int result = 0;
        while (divisor > 0) {
            int temp = divisor % 10;
            result = result * 10 + temp;
            if (result % 10 != temp) {
                return 0;
            }
            divisor = divisor /10;
        }
        return result * sign;
    }
    public static int reverse2_2(int x) {
        int result = 0;
        while (x != 0) {
            int temp = x % 10;
            int newResult = result * 10 + temp;
            if ((newResult - temp)/10 != result) {
                return 0;
            }
            result = newResult;
            x = x /10;
        }
        return result;
    }
    
    public static int reverse3(int x) {
        long rev= 0;
        while( x != 0){
            rev= rev*10 + x % 10;
            x= x/10;
            if( rev > Integer.MAX_VALUE || rev < Integer.MIN_VALUE)
                return 0;
        }
        return (int) rev;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        int test = -1999;
        test = reverse2_2(test);
        System.out.println(test);
    }
    
}
