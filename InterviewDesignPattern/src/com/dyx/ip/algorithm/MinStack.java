package com.dyx.ip.algorithm;

import java.util.Stack;

/**
 * 设计含最小函数min()的栈，要求min、push、pop的时间复杂度都是o(1)。min的作用是：返回栈中的最小值
 */
public class MinStack {
    //存储数据的栈
    Stack<Integer> stack = new Stack<>();
    //存储最小数据的栈
    Stack<Integer> minStack = new Stack<>();

    /**
     * @param num
     * @funcation 添加数据，首先往stack栈中添加
     * 如果最小栈minStack为空，或者栈顶元素比新添加的元素要大，则将新元素也要添加到辅助栈
     */
    public void push(int num) {
        stack.push(num);
        if (minStack.isEmpty() || ((int) minStack.peek()) >= num) {
            minStack.push(num);
        }
    }

    /**
     * 如果Stack为空，直接返回
     * 如果Stack不为空，得到栈顶元素，同时将栈顶元素弹出
     * 如果最小栈的栈顶元素与Stack弹出的元素相等，那么最小栈也要将其弹出
     */
    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int num = stack.peek();
        stack.pop();
        if (((int) minStack.peek()) == num) {
            minStack.pop();
        }
    }

    /**
     * @return
     * @function 查找栈的最小元素
     */
    public int min() {
        return (int) minStack.peek();
    }
}
