package com.java.java2blog;

import java.util.Stack;

class StackUseArray{
    private int top;
    private int size;
    private int arr[];

    StackUseArray(int size)
    {
        this.size = size;
        this.arr = new int[size];
        this.top = -1;
    }


    protected void pushEle(int ele)
    {
        if(!isFull()){
            top = top+1;
            this.arr[top] = ele;
            System.out.println("Successfull Push "+ ele);
        }else{
            System.out.println("Stack is Full!");
        }
    }

    protected int popEle()
    {
        int ele = -1;
        if(!isEmpty()){
            ele = arr[top--];
            System.out.println("Successfully Poped "+ ele);
        }
        else{
            System.out.println("Stack is Empty");
        }
        return ele;
    }


    protected int peekEle()
    {
        int ele = -1;
        if(!isEmpty())
        {
            ele = arr[top];
            System.out.println("Successfully Peeked "+ ele);
        }else{
            System.out.println("Stack is Empty");
        }
        return ele;
    }

    private boolean isFull()
    {
        return size-1 == top? true:false;
    }

    private boolean isEmpty()
    {
        return top < 0 ? true : false;
    }
}

public class StackUsingArray
{
    public static void main(String args[])
    {
        StackUseArray stackUseArray = new StackUseArray(100);
        System.out.println("Initialised Stack");
        System.out.println("========PushEle=========");
        stackUseArray.popEle();
        stackUseArray.pushEle(10);
        stackUseArray.pushEle(20);
        stackUseArray.pushEle(30);
        stackUseArray.pushEle(40);
        System.out.println("=========PopEle========");
        stackUseArray.popEle();
        stackUseArray.popEle();
        stackUseArray.popEle();
        //stackUseArray.popEle();

        System.out.println("==========PeekEle=======");
        stackUseArray.peekEle();

    }
}
