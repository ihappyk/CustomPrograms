package com.ihappyk.leetcode;

import java.util.Stack;

class MinStack {
    private Stack<Integer> integerStack;
    private Stack<Integer> minStack;


    /** initialize your data structure here. */
    public MinStack() {
        this.integerStack = new Stack<Integer>();
        this.minStack = new Stack<Integer>();
    }

    public void push(int x) {
        if(minStack.isEmpty()) {
            integerStack.push(x);
            minStack.push(x);
        }
        else{
            Integer temp = minStack.peek();
            integerStack.push(x);
            temp = temp < x ? temp: x;
            minStack.push(temp);
        }
    }

    public void pop() {
        if(!integerStack.isEmpty()){
            integerStack.pop();
            minStack.pop();
        }
    }

    public int top() {
        if(!integerStack.isEmpty()){
            return integerStack.peek();
        }
        return 0;
    }

    public int getMin() {
        if(!minStack.isEmpty()){
            return minStack.peek();
        }
        return -1;
    }
}
