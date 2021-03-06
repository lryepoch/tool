package com.problem.tooffer;

import java.util.ArrayList;
import java.util.Stack;

/**
* 树的遍历
*/
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class PrintListFromTailToHead {
    public ArrayList<Integer> listFromTailToHead(ListNode listNode) {

        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> al = new ArrayList<>();
        while (listNode != null) {
            stack.push(listNode.val);
            listNode = listNode.next;
        }
        while (!stack.empty()) {
            al.add(stack.pop());
        }
        return al;
    }

    public static void main(String[] args) {

    }
}