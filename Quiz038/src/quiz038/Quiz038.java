/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz038;

/**
 *
 * @author sunwangshu
 * 
 * The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"
Example 2:

Input: 4
Output: "1211"
 */
public class Quiz038 {

    public static String countAndSay(int n) {
        /** recursive, using String "+"
         *  around 30ms
         */

        if (n == 1) return "1";
        else {
            String s = countAndSay(n-1) + "0";
            String sNew = "";
            int counter = 1;
            char val = s.charAt(0);
            for (int i = 1; i < s.length(); i++) {
                if (s.charAt(i) != val) {
                    sNew = sNew + counter + val;
                    counter = 1;
                    val = s.charAt(i);
                } else {
                    counter ++;
                }
            }
            return sNew;
        }
    }
    
    public static String countAndSay2(int n) {
        /** recursive, using StringBuilder. 
        * said to be faster than using String "+"
        * 4ms OMG
        */
        
        if (n == 1) return "1";
        else {
            String prev = countAndSay(n-1) + "0";
            StringBuilder sb = new StringBuilder();
            int counter = 1;
            char val = prev.charAt(0);
            for (int i = 1; i < prev.length(); i++) {
                if (prev.charAt(i) != val) {
                    sb = sb.append(counter).append(val);
                    counter = 1;
                    val = prev.charAt(i);
                } else {
                    counter ++;
                }
            }
            return sb.toString();
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // Java doesn't have a end /0
//        String s = "this";
//        char test = s.charAt(4);
//        System.out.println(test);
        for (int i = 1; i < 20; i++) {
            String str = countAndSay2(i);
            System.out.println(str);
        }
    }
    
}
