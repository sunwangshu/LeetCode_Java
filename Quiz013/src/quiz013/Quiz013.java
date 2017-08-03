/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz013;

/**
 *
 * @author sunwangshu
 */
public class Quiz013 {
    public static int romanToInt(String s) {
        s = s.toUpperCase();
        int prev_val = 0;   // previous value
        int result = 0; 
        int index = s.length() - 1;
        while (index >= 0) {
            char cur_roman = s.charAt(index);   // current roman numeral
            int cur_val = 0;
            switch(cur_roman) {
                case 'I': cur_val = 1; break;
                case 'V': cur_val = 5; break;
                case 'X': cur_val = 10; break;
                case 'L': cur_val = 50; break;
                case 'C': cur_val = 100; break;
                case 'D': cur_val = 500; break;
                case 'M': cur_val = 1000; break;
            }
            if (cur_val == 0) {
                return 0;   // if not roman
            } else {
                if (prev_val > cur_val) {
                    result -= cur_val;
                } else {
                    result += cur_val;
                }
            }
            prev_val = cur_val;
            index -= 1;
        }
        return result;
    }
    
    public static int romanToInt1_2(String s) {
        // s = s.toUpperCase();
        char[] sc = s.toCharArray();
        int prev_val = 0;   // previous value
        int result = 0; 
        for (int index = sc.length -1; index >=0; index --) {
            char cur_roman = sc[index];
            int cur_val = 0;
            switch(cur_roman) {
                case 'I': cur_val = 1; break;
                case 'V': cur_val = 5; break;
                case 'X': cur_val = 10; break;
                case 'L': cur_val = 50; break;
                case 'C': cur_val = 100; break;
                case 'D': cur_val = 500; break;
                case 'M': cur_val = 1000; break;
            }
            if (cur_val == 0) {
                return 0;   // if not roman
            } else {
                if (prev_val > cur_val) {
                    result -= cur_val;
                } else {
                    result += cur_val;
                }
            }
            prev_val = cur_val;
        }
        return result;
    }
    
    public static int romanToInt2(String s) {
        // top 1
        char[] sc = s.toCharArray();
        int sum = 0;
        for (int index = sc.length - 1; index >= 0; index--) {
            if (sc[index] == 'I') {
                sum += (sum < 5 ? 1 : -1);
            } else if (sc[index] == 'V') {
                sum += 5;
            } else if (sc[index] == 'X') {
                sum += (sum < 50 ? 10 : -10);
            } else if (sc[index] == 'L') {
                sum += 50;
            } else if (sc[index] == 'C') {
                sum += (sum < 500 ? 100 : -100);
            } else if (sc[index] == 'D') {
                sum += 500;
            } else if (sc[index] == 'M') {
                sum += 1000;
            }
        }
        return sum;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int test = romanToInt ("MCMXCVIII");
        System.out.println(test);
    }
    
}
