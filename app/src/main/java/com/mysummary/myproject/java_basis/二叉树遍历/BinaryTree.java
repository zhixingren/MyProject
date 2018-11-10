package com.mysummary.myproject.java_basis.二叉树遍历;

import android.util.Log;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by xingzhi on 2018/7/31.
 */

public class BinaryTree {

    private TreeNode root;

    public BinaryTree() {
        root = new TreeNode(1, "A");
    }

    /*
            A
        B       C
    D      E        F

     */
    public void creatBinaryTree() {
        TreeNode nodeB = new TreeNode(2, "B");
        TreeNode nodeC = new TreeNode(3, "C");
        TreeNode nodeD = new TreeNode(4, "D");
        TreeNode nodeE = new TreeNode(5, "E");
        TreeNode nodeF = new TreeNode(6, "F");
        root.leftChild = nodeB;
        root.rightChild = nodeC;
        nodeB.leftChild = nodeD;
        nodeB.rightChild = nodeE;
        nodeC.rightChild = nodeF;

    }

    public class TreeNode {
        private int index;
        private String data;
        private TreeNode leftChild;
        private TreeNode rightChild;

        public TreeNode(int index, String data) {
            this.index = index;
            this.data = data;
            this.leftChild = null;
            this.rightChild = null;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public TreeNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(TreeNode leftChild) {
            this.leftChild = leftChild;
        }

        public TreeNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(TreeNode rightChild) {
            this.rightChild = rightChild;
        }
    }


    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.creatBinaryTree();
//        int height = binaryTree.getHeight();
//
//        System.out.println("TreeHeight :" + height);
//        int size = binaryTree.getSize();
//        System.out.println("TreeSize :" + size);
//        binaryTree.preOrder(binaryTree.root);

//        binaryTree.midOrder(binaryTree.root);
//        binaryTree.postOrder(binaryTree.root);

        new BinaryTree().nonOrder(binaryTree.root);


    }

    //求而二叉树的高度
    public int getHeight() {
        return getHeight(root);
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int i = getHeight(root.getLeftChild());
            int j = getHeight(root.getRightChild());

            return (i < j) ? j + 1 : i + 1;
        }

    }

    //获取二叉树结点数
    public int getSize() {
        return getSize(root);
    }

    //getsixe(B)=3
    private int getSize(TreeNode node) {
        if (node == null) {

            return 0;
        } else {                     //getsize(D)=1            //getsize(E)=1
            return 1 + getSize(node.getLeftChild()) + getSize(node.getRightChild());
        }
    }

    //前序遍历(根 左 右)-迭代方式,
    public void preOrder(TreeNode node) {
        if (node == null) {
            return;
        } else {
            System.out.println("preOrder data " + node.getData());
            preOrder(node.getLeftChild());
            preOrder(node.getRightChild());
        }

    }

    //中序遍历（左 中 右）D B E A C F
     /*
            A
        B       C
    D      E        F

     */
    public void midOrder(TreeNode node) {
        if (node==null){
            return;
        }else {
            midOrder(node.getLeftChild());
            System.out.println("midOrder data " + node.getData());
            midOrder(node.getRightChild());
        }

    }

    //后序遍历（左 右 中）D E B F C A
     /*
            A
        B       C
    D      E        F

     */
    public void postOrder(TreeNode node) {
        if (node==null){
            return;
        }else {
            postOrder(node.getLeftChild());
            postOrder(node.getRightChild());
            System.out.println("postOrder data " + node.getData());

        }

    }


    //前序遍历-非迭代
    public void nonOrder(TreeNode node){
        if (node == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(node);
        while (!stack.isEmpty()){
            TreeNode n = stack.pop();
            System.out.println(n.getData());

            if (n.getRightChild()!=null){
                stack.push(n.getRightChild());
            }
            if (n.getLeftChild()!=null) {
                stack.push(n.getLeftChild());

            }

        }

    }

    //通过前序遍历的数据序列反向生成二叉树
       /*
             A
        B        C
    D      E   #     F
 #     # #   #    #    #

     ABD##E##C#F##
     */
    public void creatBinaryTreepre(ArrayList<String> data){


    }



}