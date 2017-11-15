package com.dyx.ip.algorithm;


import java.util.HashSet;
import java.util.Stack;

public class StackUtil {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * @param head 头节点
     * @param node 指定节点
     * @funcation 删除单链表中的指定节点
     */
    public static void deleteNode(Node head, Node node) {
        //删除尾节点，采用顺序查找找到尾节点的前一个节点
        if (node.next == null) {
            while (head.next != node) {
                head = head.next;
            }
            head.next = null;
        }
        //删除头节点
        else if (head == node) {
            head = null;
        }
        //删除其它节点
        else {
            //当前节点的下一个节点
            Node nextNode = node.next;
            //将下一个节点的data赋值给当前节点
            node.data = nextNode.data;
            node.next = nextNode.next;
        }
    }

    /**
     * @param head
     * @param num
     * @funcation 删除单链表中指定数值的节点方法一：利用栈
     */
    public Node removeValueMethodA(Node head, int num) {
        Stack<Node> stack = new Stack<>();
        while (head != null) {
            if (head.data != num) {
                //入栈
                stack.push(head);
            }
            head = head.next;
        }
        while (!stack.isEmpty()) {
            //返回头部节点不删除
            stack.peek().next = head;
            //返回头部节点删除
            head = stack.pop();
        }
        return head;
    }

    /**
     * @param head
     * @param num
     * @funcation 删除单链表中指定数值的节点方法一：不利用栈
     */
    public Node removeValueMethodB(Node head, int num) {
        while (head != null) {
            if (head.data != num) {
                break;
            }
            head = head.next;
        }
        Node preNode = head;
        Node curNode = head;
        while (curNode != null) {
            if (curNode.data == num) {
                preNode.next = curNode.next;
            } else {
                preNode = curNode;
            }
            curNode = curNode.next;
        }
        return head;
    }

    /**
     * @param head
     * @funcation 删除单链表中数值重复的节点
     */
    public void deleteRepetition(Node head) {
        if (head == null) {
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        Node preNode = head;
        Node curNode = head.next;
        set.add(head.data);
        while (curNode != null) {
            if (set.contains(curNode.data)) {
                preNode.next = curNode.next;
            } else {
                set.add(curNode.data);
                preNode = curNode;
            }
            curNode = curNode.next;
        }
    }

    /**
     * @param head1
     * @param head2
     * @return
     * @funcation 两个单链表相加
     */
    public Node addList(Node head1, Node head2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (head1 != null) {
            stack1.push(head1.data);
            head1 = head1.next;
        }
        while (head2 != null) {
            stack2.push(head2.data);
            head2 = head2.next;
        }
        //链表1的值
        int n1 = 0;
        //链表2的值
        int n2 = 0;
        //n1+n2+ca
        int n = 0;
        //进位
        int ca = 0;
        //当前节点
        Node curNode = null;
        //当前节点的前序节点
        Node preNode = null;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            n1 = stack1.isEmpty() ? 0 : stack1.pop();
            n2 = stack2.isEmpty() ? 0 : stack2.pop();
            n = n1 + n2 + ca;
            curNode = new Node(n % 10);
            curNode.next = preNode;
            preNode = curNode;
            ca = n / 10;
        }
        if (ca == 1) {
            preNode = curNode;
            curNode = new Node(n / 10);
            curNode.next = preNode;
        }
        return curNode;
    }

    /**
     * @param head
     * @return
     * @funcation 判断一个单链表是否有回文结构
     */
    public boolean isPlalindrome(Node head) {
        if (head == null) {
            return false;
        }
        Stack<Node> stack = new Stack<>();
        Node curNode = head;
        if (curNode != null) {
            stack.push(curNode);
            curNode = curNode.next;
        }
        while (head.next != null) {
            if (head.data != stack.pop().data) {
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * @param head
     * @param k
     * @return
     * @funcation 删除单链表的倒数第k个节点
     */
    public static Node deleteLastKthNode(Node head, int k) {
        if (k <= 0 || head == null) {
            return head;
        }
        Node preNode = head;
        for (int i = 0; i < k; i++) {
            if (preNode.next != null) {
                preNode = preNode.next;
            } else {
                return head;
            }
        }
        Node nextNode = head;
        while (preNode.next != null) {
            preNode = preNode.next;
            nextNode = nextNode.next;
        }
        nextNode.next = nextNode.next.next;
        return head;
    }
}