package com.example.lib_arithmetic.stack;

import java.util.Stack;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/8/25 上午9:22
 * @Version: 1.0
 * @Description:
 */
class Solution {
    public boolean isValid(String s){
        if (s == null ) return false;
        Stack<Character> charStack = new Stack<>();
        for (int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '['){
                charStack.push(c);
            }else{
                if (charStack.empty()) return false;
                if (c == ')' && charStack.pop() != '('){
                    return false;
                }else if (c == '}' && charStack.pop() != '{'){
                    return false;
                }else if(c == ']' && charStack.pop() != '['){
                    return false;
                }
            }
        }
        return charStack.empty();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("}"));
    }
}
