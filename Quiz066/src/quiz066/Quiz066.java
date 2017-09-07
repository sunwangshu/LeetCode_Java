/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz066;

/**
 * https://leetcode.com/problems/plus-one/description/
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.
 * @author sunwangshu
 */
public class Quiz066 {

    public static int[] plusOne(int[] digits) {
        int i = digits.length - 1;
        while(i >= 0) {
            if (digits[i] != 9) {
                digits[i]++;
                break;
            }
            else {
                digits[i] = 0;
                i--;
            }
        }
        if (i < 0) {
            int[] newArray = new int[digits.length + 1];
            newArray[0] = 1;
            for (int j = 1; j < newArray.length; j++) {
                newArray[j] = 0;
            }
            return newArray;
        }
        return digits;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] digits = {9, 9, 9};
        int[] result = plusOne(digits);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println();
    }
    
}
