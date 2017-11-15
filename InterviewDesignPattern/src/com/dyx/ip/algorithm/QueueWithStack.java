package com.dyx.ip.algorithm;

import java.util.Stack;

/**
 * 通过两个栈实现一个队列
 */
public class QueueWithStack {
    private static Stack<Object> stack1 = new Stack<>();
    private static Stack<Object> stack2 = new Stack<>();

    /**
     * @param item
     * @funcation 入队
     */
    public static void appendTail(Object item) {
        stack1.push(item);
        printInfo("入队元素：" + item);
    }

    private static void printInfo(String msg) {
        System.out.print(msg);
    }

    /**
     * 出栈：删除一个元素时，检查栈2是否为空，栈2不为空则弹出栈2栈顶元素；栈2为空，则把栈1中的元素全部弹出、压入栈2中，然后从栈2栈顶弹出元素
     */
    public static void deleteHead() {
        if (!stack2.isEmpty()) {
            printInfo("出队元素：" + stack2.pop());
        } else {
            if (stack1.isEmpty()) {
                throw new RuntimeException("队列为空！");
            }
            while (!stack1.isEmpty()) {
                Object item = stack1.pop();
                stack2.push(item);
            }
        }
    }
}