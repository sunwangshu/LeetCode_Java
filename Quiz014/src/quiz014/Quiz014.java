/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz014;

/**
 *
 * @author sunwangshu
 */
public class Quiz014 {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String common = strs[0]; 
        for (int i = 1; i < strs.length; i++) {
            if (common.length() > strs[i].length()) {
                common = common.substring(0, strs[i].length());
            }
            for (int j = 0; j < common.length(); j++) {
                if (common.charAt(j) != strs[i].charAt(j)) {
                    common = common.substring(0, j);
                    break;
                }
            }
        }
        return common;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] test = new String[3];
        test[0] = "Abacus";
        test[1] = "Abandon";
        test[2] = "Abathur";
        String[] test2 = new String[2];
        test2[0] = "aa";
        test2[1] = "a";
        String common = longestCommonPrefix(test);
        System.out.println(common);
     }
    
}
