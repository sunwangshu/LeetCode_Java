/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz058;

/**
 * https://leetcode.com/problems/length-of-last-word/description/
 * 
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

If the last word does not exist, return 0.

Note: A word is defined as a character sequence consists of non-space characters only.

For example, 
Given s = "Hello World",
return 5.
* 
 * @author sunwangshu
 */
public class Quiz058 {

    public static int lengthOfLastWord(String s) {
        char[] set = s.toCharArray();
        int count = 0;
        boolean started = false;
        for (int i = set.length-1; i>=0; i--) {
            if (!started) {
                if (set[i] != ' ') {
                    count ++;
                    started = true;
                }
            } else {
                if (set[i] != ' '){
                    count ++;
                }else {
                    break;
                }
            }
        }
        return count;
    }
    
    public static int lengthOfLastWord2(String s) { // from online
        int length = 0, tail = s.length() - 1;
        while(tail >= 0 && s.charAt(tail) == ' ')
            tail--;
        while(tail >= 0 && s.charAt(tail) != ' ') {
            length++;
            tail--;
        }
        return length;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //String s = "thi si ldkjf   ";
        String s = "";
        int count = lengthOfLastWord(s);
        System.out.println(count);
    }
    
}
