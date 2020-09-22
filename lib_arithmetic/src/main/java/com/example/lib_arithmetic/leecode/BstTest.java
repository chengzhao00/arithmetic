package com.example.lib_arithmetic.leecode;

/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/9/22 上午10:19
 * @Version: 1.0
 * @Description:
 */
public class BstTest {

    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    static class Solution {

        int i = 0;
        public int kthLargest(TreeNode root, int k) {
            if(root == null)
                return -1;
                kthLargest(root.right,k);
                i++;
                if(i == k){
                    return root.val;
                }
                kthLargest(root.left,k);
            return 0;
        }
    }
}
