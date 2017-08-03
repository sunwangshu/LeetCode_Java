/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz020;
import java.util.Stack;

/**
 * @author sunwangshu
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * Note: [()]{} is also considered as valid.
 */

public class Quiz020 {
    /*
    * bad code example
    */
    public static boolean isValid0(String s) {  // cannot tell "[(])"
        if (s.length() % 2 == 1) return false;
        if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}')  return false;
        
        int counter1 = 0;     // for []
        int counter2 = 0;     // for []
        int counter3 = 0;     // for {}
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(': counter1++; break;
                case '[': counter2++; break;
                case '{': counter3++; break;
                case ')': 
                    counter1--; 
                    if (counter1 < 0) return false;
                    break;
                case ']': 
                    counter2--; 
                    if (counter2 < 0) return false;
                    break;
                case '}': 
                    counter3--; 
                    if (counter3 < 0) return false;
                    break;
            }
        }
        if (counter1 + counter2 + counter3 != 0) return false;
        return true;
    }
    
    /* 
    * first working one
    */
    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) return false;
        
        Stack<Character> stack  = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(': stack.push('('); break;
                case '[': stack.push('['); break;
                case '{': stack.push('{'); break;
                case ')': 
                    if (stack.isEmpty()) return false;
                    else {
                        if (stack.pop() != '(') return false;
                        break;
                    } 
                case ']': 
                    if (stack.isEmpty()) return false;
                    else {
                        if (stack.pop() != '[') return false;
                        break;
                    } 
                case '}': 
                    if (stack.isEmpty()) return false;
                    else {
                        if (stack.pop() != '{') return false;
                        break;
                    }
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
        
    /**
     * a cleaned-up one
     * 
     */
    
    public static boolean isValid2(String s) {
        Stack<Character> stack  = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') stack.push(')');
            else if (s.charAt(i) == '[') stack.push(']');
            else if (s.charAt(i) == '{') stack.push('}');
            else {
                if (stack.isEmpty()) return false;
                else {
                    if (stack.pop()!= s.charAt(i)) return false;
                }
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
    
    public static boolean isValid2_2(String s) {
        Stack<Character> stack  = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else {
                if (stack.isEmpty()) return false;
                if (stack.pop()!= c) return false;
            }
        }
        return stack.isEmpty();
    }

    public boolean isValid3(String s) {
        // from web
        char[] word = s.toCharArray();
        Stack<Character> stack = new Stack();
        
        for(char c : word){
            if(c =='('||c =='{'||c =='['){
                stack.push(c);
            }else if(c==')'){
                if(stack.isEmpty()) return false;
                if(stack.pop()!='(') return false;
                
            }else if(c=='}'){
                if(stack.isEmpty()) return false;
                if(stack.pop()!='{') return false;
                
            }else if(c==']'){
                if(stack.isEmpty()) return false;
                if(stack.pop()!='[') return false;
                
            }
        }
        
        return stack.isEmpty();
        
    }
    
    public boolean isValid4(String s) {
        // from web. not using stack but rather pointer
        
        // uneven length cannot be well matched
        if (s.length() % 2 != 0) return false;

        char[] stack = new char[s.length()];
        int head = 0;

        for (char c : s.toCharArray()) {
            // push
            if (c == '(' || c == '[' || c == '{') stack[head++] = c;
            // pop
            else if (head != 0 && 
                    (  (c == ')' && stack[head - 1] == '(')
                    || (c == ']' && stack[head - 1] == '[')
                    || (c == '}' && stack[head - 1] == '{'))) head--;
            // unrecognized symbol or popping unmatched symbol
            else return false;
        }

        // well matched if stack is empty
        return head == 0;
    }
    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean test = isValid2("()[{([])}]");
        System.out.println(test);
    }
    
}
