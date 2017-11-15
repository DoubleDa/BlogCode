package com.dyx.ip.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class BinaryTreeUtil {
    public static class TreeNode {
        Object data;
        TreeNode left;
        TreeNode right;

        public TreeNode(Object data) {
            this.data = data;
        }

        public TreeNode(Object data, TreeNode left, TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    /**
     * @param root
     * @function 分层遍历二叉树：宽度优先遍历
     */
    public static void levelTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            TreeNode curNode = queue.removeFirst();
            //左子树
            if (curNode.left != null) {
                queue.add(curNode.left);
            }
            //右子树
            if (curNode.right != null) {
                queue.add(curNode.right);
            }
        }
    }

    /**
     * @param root
     * @return
     * @function 分层遍历应用：按层打印二叉树
     */
    public ArrayList<Integer> printElementFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayBlockingQueue<TreeNode>(100);
        //当前行的最后节点
        TreeNode last = root;
        //下一行的最右节点
        TreeNode nLast = root;
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode out = queue.poll();
            list.add((Integer) out.data);
            if (out.left != null) {
                queue.add(out.left);
                nLast = out.left;
            }
            if (out.right != null) {
                queue.add(out.right);
                nLast = out.right;
            }
            //下一行
            if (out == last) {
                last = nLast;
            }
        }
        return list;
    }

    /**
     * @param root
     * @function 前序遍历(递归)
     */
    public static void preOrderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        printInfo(root.data + "");
        preOrderTraversalRec(root.left);
        preOrderTraversalRec(root.right);
    }

    /**
     * @param root
     * @function 前序遍历(迭代)
     */
    public static void preOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curNode = stack.pop();
            printInfo(curNode.data + "");
            //关键点：要先压入右子树，再压入左子树，这样出栈的时候先打印左子树再打印右子树
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
        }
    }

    /**
     * @param root
     * @function 中序遍历(递归)
     */
    public static void centerOrderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        centerOrderTraversalRec(root.left);
        printInfo(root.data + "");
        centerOrderTraversalRec(root.right);
    }

    /**
     * @param root
     * @function 中序遍历(迭代)
     */
    public static void centerOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curNode = root;
        if (curNode != null) {
            while (!stack.isEmpty() || curNode != null) {
                if (curNode != null) {
                    stack.push(curNode);
                    curNode = curNode.left;
                } else {
                    curNode = stack.pop();
                    printInfo(curNode.data + "");
                    curNode = curNode.right;
                }
            }
        }
    }

    /**
     * @param root
     * @function 后序遍历(递归)
     */
    public static void postOrderTraversalRec(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrderTraversalRec(root.left);
        postOrderTraversalRec(root.right);
        printInfo(root.data + "");
    }

    /**
     * @param root
     * @function 后序遍历(迭代)
     */
    public static void postOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }
        //用于添加node和它的左右孩子
        Stack<TreeNode> stack = new Stack<>();
        //用于反转第一个stack输出
        Stack<TreeNode> outputStack = new Stack<>();
        stack.push(root);
        //确保所有元素都被反转到第二个stack
        while (!stack.isEmpty()) {
            //把栈顶元素添加到第二个stack
            TreeNode curNode = stack.pop();
            outputStack.push(curNode);
            //把栈顶元素的左孩子和右孩子分别添加到底一个stack
            if (curNode.left != null) {
                stack.push(curNode.left);
            }
            if (curNode.right != null) {
                stack.push(curNode.right);
            }
        }
        while (!outputStack.isEmpty()) {
            printInfo(outputStack.pop().data + "");
        }
    }

    private static void printInfo(String msg) {
        System.out.print(msg);
    }
}
