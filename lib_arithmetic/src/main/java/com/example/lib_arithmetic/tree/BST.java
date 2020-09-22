package com.example.lib_arithmetic.tree;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


/**
 * @Author: MR-Cheng
 * @CreateDate: 2020/9/9 下午3:27
 * @Version: 1.0
 * @Description: 二分搜索树
 */
public class BST<E extends Comparable<E>> {

    private class TreeNode {
        public E e;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(E e) {
            this.e = e;
            left = null;
            right = null;
        }

    }

    private TreeNode root;
    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
//        if (node == null){
//            node = new TreeNode(e);
//            size++;
//        }else{
        root = add(root, e);
//        }
//        add2(node,e);
    }
//    private void  add(TreeNode node,E e){
//        if (e.equals(node.e)){
//            return;
//        }else if (e.compareTo(node.e) < 0 && node.left == null){
//            node.left = new TreeNode(e);
//            size++;
//            return;
//        }else if (e.compareTo(node.e) > 0 && node.right == null){
//            node.right = new TreeNode(e);
//            size++;
//            return;
//        }
//        if (e.compareTo(node.e) < 0){
//            add(node.left,e);
//        }else{
//            add(node.right,e);
//        }
//    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(TreeNode node, E e) {
        if (node == null) {
            return false;
        }

        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) > 0) {
            return contains(node.right, e);
        } else {
            return contains(node.left, e);
        }
    }

    private TreeNode add(TreeNode node, E e) {
        if (node == null) {
            size++;
            return new TreeNode(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = add(node.right, e);
        }
        return node;
    }

    /**
     * 递归方式添加树节点
     *
     * @param node
     * @param e
     */
    private void add2(TreeNode node, E e) {
        if (node == null) {
            root = new TreeNode(e);
            size++;
            return;
        }
        TreeNode p = node;
        while (p != null) {
            if (e.compareTo(p.e) > 0) {
                if (p.right == null) {
                    p.right = new TreeNode(e);
                    size++;
                    return;
                }
                p = p.right;
            } else if (e.compareTo(p.e) < 0) {
                if (p.left == null) {
                    p.left = new TreeNode(e);
                    size++;
                    return;
                }
                p = p.left;
            } else {
                return;
            }
        }
    }

    /**
     * 前序遍历
     */
    private void preVeOrder() {
        preVeOrder(root);
        System.out.println();
        preOrder(root);
//        preOrder(root);
    }

    /**
     * 前序遍历使用递归方式
     * @param node
     */
    private void preVeOrder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.e+"->");
        preVeOrder(node.left);
        preVeOrder(node.right);
    }

    /**
     * 前序遍历使用循环方式
     * @param node
     */
    private void preOrder(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.empty()){
            TreeNode cur = stack.pop();
            System.out.print(cur.e+"->");
            if (cur.right != null){
                stack.push(cur.right);
            }
            if (cur.left != null){
                stack.push(cur.left);
            }

        }

//        TreeNode p = node;
//        while (p != null || !stack.empty()){
//           if (p != null){
//               System.out.print(node.e+"->");
//               stack.push(p);
//               p = p.left;
//           }else{
//               TreeNode tem = stack.pop();
//               p = tem.right;
//           }

    }

    /**
     * 中序遍历
     */
    public void levelOrder(){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode cur = queue.remove();
            System.out.print(cur.e+"->");
            if (cur.left != null){
                queue.add(cur.left);
            }
            if (cur.right != null){
                queue.add(cur.right);
            }
        }
    }

    /**
     * 中序遍历
     */
    public void inOrder(){
        inOrder(root);
        System.out.println();
        inVeOrder(root);
    }

    /**
     * 递归方式进行中序遍历
     * @param node
     */
    private void inOrder(TreeNode node){
        if (node == null){
            return;
        }
        inOrder(node.left);
        System.out.print(node.e+"->");
        inOrder(node.right);
    }

    /**
     * 循环方式中序遍历
     */
    private void inVeOrder(TreeNode node){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = node;
        while (p != null || !stack.empty()){
            if (p != null){
                stack.push(p);
                p = p.left;
            }else{
                TreeNode tes = stack.pop();
                System.out.print(tes.e+"->");
                p = tes.right;
            }
        }
    }

    /**
     * 后序遍历
     */
    public void postOrder(){
        postOrder(root);
    }

    private void postOrder(TreeNode node){
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.e+"->");
    }

    //返回最小值
    public E miniNum (){
        if (size == 0) throw new NullPointerException("null bst");
        return miniNum(root).e;
    }

    public E miniMum(){
        TreeNode node = root;
        while (node!= null){
            if (node.left == null){
                break;
            }
            node = node.left;
        }
        return node.e;
    }

    public void removeMin(){
        root = removeMin(root);
    }
    private TreeNode removeMin(TreeNode node){
        if (node.left == null){
            TreeNode rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public void removeMax(){
        root = removeMax(root);
    }

    private TreeNode removeMax(TreeNode node){
        if (node.right == null){
            TreeNode leftNode = node.left;
            node.left = null;
            size --;
            return leftNode;
        }
        node.right = removeMax(node.right);
        return node;
    }

    private TreeNode miniNum(TreeNode node){
        if (node.left == null){
            return node;
        }
        return miniNum(node.left);
    }



    //最大值
    public E maxNum(){
        return maxNum(root).e;
    }

    private TreeNode maxNum(TreeNode node){
        if (node.right == null){
            return node;
        }
        return maxNum(node.right);
    }

    //删除任意元素
    public void remove(E e){
        root = remove(root,e);
        Set<Integer> set = new HashSet<>();
    }

    private TreeNode remove(TreeNode node,E e){
        if (node == null )
            return null;

        if (e.compareTo(node.e) < 0) { //e < node.e
            node.left = remove(node.left,e);
            return node;
        }else if (e.compareTo(node.e) > 0 ){ //e > node.e
            node.right = remove(node.right,e);
            return node;
        }else{// e == node.e
            //待删除节点左子树为空的情况
            if (node.left == null){ // 如果删除的是最左边的节点
                TreeNode rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }
            //待删除的节点右子树为空的情况
            if (node.right == null){
                 TreeNode leftNode  = node.left;
                 node.left = null;
                 size--;
                 return leftNode;
            }

            TreeNode successor = miniNum(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;

        }
    }

//    private void postVeOrder(TreeNode node){
//        TreeNode cur,pre = null;
//        Stack<TreeNode> stack = new Stack<>();
//        stack.push(node);
//        while (!stack.empty()){
//            cur = stack.peek();
//            if (cur.left == null && cur.right == null || (pre != null && (pre == cur.left || pre == cur.right))){
//                System.out.print(cur.e+"->");
//            }
//        }
//    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        generateBSTString(root,0,sb);
        return sb.toString();
    }


    private void generateBSTString(TreeNode node,int depth,StringBuilder res){
        if (node == null){
            res.append(generateDepth(depth)+"NULL \n");
            return;
        }
        res.append(generateDepth(depth)+node.e +"\n");
        generateBSTString(node.left,depth +1,res);
        generateBSTString(node.right,depth +1,res);
    }
    private String generateDepth(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth;i++){
            res.append("-- ");
        }
        return res.toString();
    }

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        int[] nums = {5,3,6,8,4,2};
        for (int num : nums) {
            bst.add(num);
        }
        ///       5
        //     3     6
        //  2     4    8
        bst.preVeOrder();
        System.out.println();
//        System.out.println(bst);

        bst.inOrder();
        System.out.println();
        bst.postOrder();
        System.out.println();
        bst.levelOrder();
        System.out.println();
        System.out.println(bst.miniNum());
        System.out.println(bst.maxNum());
        System.out.println(bst.miniMum());
        bst.removeMin();
        bst.levelOrder();
        System.out.println();
        bst.removeMax();
        bst.levelOrder();
        bst.remove(3);
        System.out.println();
        bst.levelOrder();

    }

//    public static void main(String[] args){
//        Thread thread = new Thread(){
//            @Override
//            public void run() {
//                super.run();
//                try {
//                    sleep(10000);
//                    System.out.println("线程结束");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
//        thread.start();
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("方法结束");
//    }



}
