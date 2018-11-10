package com.mysummary.myproject.java_basis.jihe.singlelist;

/**
 * Created by xingzhi on 2018/7/11.
 */

public class SList {

    Node head = null; // 头节点

    /**
     * 链表中的节点，data代表节点的值，next是指向下一个节点的引用
     *
     * @author zjn
     *
     */
    class Node {
        Node next = null;// 节点的引用，指向下一个节点
        int data;// 节点的对象，即内容

        public Node(int data) {
            this.data = data;
        }
    }

//    public void add(int d){
//        Node node = new Node(d);
//        if (head==null){
//            head = node;
//            return;
//        }
//
//        Node tmp = head;
//        while (tmp.next!=null){
//
//            tmp = tmp.next;
//
//        }
//        tmp.next = node;
//
//    }
//
//
//    public void printList() {
//
//        Node tmp = head;
//
//        while (tmp!=null){
//            System.out.println(tmp.data);
//            tmp = tmp.next;
//        }
//
//    }


















    public static void main(String[] args) {

        SList list = new SList();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//
//        list.printList();

    }

}
