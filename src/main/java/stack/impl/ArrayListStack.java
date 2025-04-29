package stack.impl;

import stack.MyStack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class ArrayListStack implements MyStack {
    List<Integer> stack;

    public ArrayListStack(int initialCapacity) {
        stack = new ArrayList<>(initialCapacity);
    }

    public void push(int item) {
        stack.add(item);
    }

    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public int size() {
        return stack.size();
    }

    public int search(int item) {
        for (int i = stack.size() - 1; i >= 0; i--) {
            if (stack.get(i) == item) {
                return stack.size() - i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return stack.toString();
    }

//    public static void main(String[] args) {
//        ArrayListStack stack = new ArrayListStack();
//        stack.push(10);
//        stack.push(20);
//        stack.push(30);
//        System.out.println(stack);
//        System.out.println(stack.search(10));
//        System.out.println(stack.search(20));
//        System.out.println(stack.search(30));
//        System.out.println(stack.size());
//        System.out.println(stack.peek());
//        System.out.println(stack.pop());
//        System.out.println(stack);
//        System.out.println(stack.isEmpty());
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println(stack.isEmpty());
//    }
}
