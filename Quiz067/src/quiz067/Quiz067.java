/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz067;

/**
 *
 * @author sunwangshu
 */
public class Quiz067 {

    public static String addBinary(String a, String b) {
        if (a == "") return b;
        else if (b == "") return a;
        else {
            // get same length
            int maxLength = Math.max(a.length(), b.length());
            if (maxLength > a.length()) {
                int diff = maxLength - a.length();
                while(diff > 0) {
                    a = "0" + a;
                    diff--;
                }
            }
            else if (maxLength > b.length()) {
                int diff = maxLength - b.length();
                while(diff > 0) {
                    b = "0" + b;
                    diff--;
                }
            }
            // add from last digit
            int i = maxLength - 1;
            int inc = 0;
            String answer = "";
            while(i >= 0) {
                int ai = (a.charAt(i) == '1') ? 1 : 0;
                int bi = (b.charAt(i) == '1') ? 1 : 0;
                int newVal = ai + bi + inc;
                inc = newVal / 2;
                newVal = newVal % 2;
                answer = newVal + answer;
                i--;
            }
            if (inc != 0) answer = inc + answer;
            return answer;
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        // not sure if using binary is okay
//        int test = 0b001;
//        int test2= 0b011;
//        int test3 = test + test2;
//        System.out.println(test3);

        // trying to convert to char
//        char test = (char)233;
//        int test2 = Character.getNumericValue(test);
//        System.out.println(test2);
        
//        // test about string and parseInt
//        String x0 = "010";
//        int x1 = Integer.parseInt(x0);
//        System.out.println(x1);
    String x1 = "100";
    String x2 = "111";
    String x3 = addBinary(x1, x2);
    System.out.println(x3);
    }
    
}
