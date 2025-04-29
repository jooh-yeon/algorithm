package stack.impl;

import stack.MyStack;

import java.util.Arrays;
import java.util.EmptyStackException;

public class ArrayStack implements MyStack {
    int[] array;
    int top = -1;

    public ArrayStack(int capacity) {
        array = new int[capacity];
    }

    public void push(int item) {
        if (top == array.length - 1) {
            int[] newArray = new int[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, array.length);
            array = newArray;
        }
        array[++top] = item;
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int value = array[top];
        top--;
        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return array[top];
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int search(int item) {
        for (int i = top; i >= 0; i--) {
            if (array[i] == item) {
                return top - i + 1;
            }
        }
        return -1;
    }

//    public static void main(String[] args) {
//        ArrayStack stack = new ArrayStack(5);
//        stack.push(10);
//        stack.push(20);
//        stack.push(30);
//        System.out.println(stack.peek()); // 30
//        System.out.println(stack.search(20)); // 2
//        System.out.println(stack.pop()); // 30
//        System.out.println(stack.size()); // 2
//        System.out.println(stack.isEmpty()); // false
//        System.out.println(Arrays.toString(stack.array));
//    }
}
