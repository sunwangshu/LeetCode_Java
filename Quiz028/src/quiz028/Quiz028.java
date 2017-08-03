/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz028;

/**
 *
 * @author sunwangshu
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 */
public class Quiz028 {
    public static int strStr1_1(String haystack, String needle) {
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        if (h.length < n.length) return -1;
        if (n.length == 0) return 0;    // not -1
        int i = 0;
        int j = 0;
        while (i < h.length) {
            if (h[i] == n[j]) {
                j++;
                while (j < n.length) {
                    if ((i+j) >= h.length) return -1;
                    if (h[i+j] != n[j]) {
                        j = 0;
                        break;
                    } 
                    else {
                        j++;
                    }
                }
                if (j == n.length) {
                    return i;
                }
            }
            i++;        // made some mistake to include it in if statement O.O
        }
        return -1;
    }
    
    public static int strStr1_2(String haystack, String needle) {
        /**
         * less lines why
         * 7ms
         */
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();
        if (h.length < n.length) return -1;
        if (n.length == 0) return 0;    // not -1
        int i = 0;
        int j = 0;
        while (i < h.length - n.length + 1) {   // update
            while(j < n.length) {
                if (h[i + j] == n[j]) {
                    j++;
                }
                else {
                    j = 0;
                    break;
                }
            }
            if (j == n.length) return i;
            i++;
        }
        return -1;
    }
    
    
    /** sort of my first recursive algorithm
     * 
     * @param i starting index to look at
     * @param h charArray of haystack
     * @param n charArray of needle
     * @return 
     */
    
    public static boolean charsetEqual(int i, char[] h, char[] n) {
        for (int j = 0; j < n.length; j++) {
            if (h[i + j] != n[j]) return false;
        } 
        return true;
    }
    
    public static int charChar(int i, char[] h, char[] n) {
        if (i > h.length - n.length) return -1;
        else if (charsetEqual(i, h, n)) return i;
        else return charChar(i+1, h, n);
    }
    
    public static int strStr1_3(String haystack, String needle) {
        /**
         * wanna try recursive
         * divide to charChar, and then to charsetEqual, and conquer!
         * 7ms same
         */
        char[] h = haystack.toCharArray();
        char[] n = needle.toCharArray();        
        // if (h.length < n.length) return -1;  // not necessary
        if (n.length == 0) return 0;    // not -1
        
        return charChar(0, h, n);
    }
    
    
    
    
    public static int strStr2(String haystack, String needle) {
        /** from LeetCode
         * 
         */
        if (haystack == null || needle == null) return -1;
        int m = haystack.length(), n = needle.length();
        if (m < n) return -1;

        for (int i = 0; i <= m - n; i++) {
            for (int j = 0;  j <= n; j++) {
                if (j == n) return i;
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
        }
        return -1;
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int test = strStr1_2("ijsa","js");
        System.out.println(test);
    }
    
}
