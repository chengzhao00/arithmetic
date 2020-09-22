package com.example.lib_arithmetic.leecode;

import java.util.TreeSet;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/9/17 下午4:48
 * @Version: 1.0
 * @Description: 804. 唯一摩尔斯密码词
 */
public class LeetCode804 {

    static class Solution {

        public int uniqueMorseRepresentations(String[] words) {

            String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
            TreeSet<String> set = new TreeSet<>();
            for(String word:words){
                StringBuilder sb = new StringBuilder();
                for(int i = 0 ; i < word.length(); i++){
                   sb.append(code[word.charAt(i) - 'a']);
                }
                set.add(sb.toString());
            }
            return set.size();
        }
    }
}
