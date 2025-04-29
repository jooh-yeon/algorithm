package stack.impl;

import stack.MyStack;

import java.util.EmptyStackException;

public class LinkedListStack implements MyStack {
    /**
     * Node Class 정의 : 각 노드는 데이터와 다음 노드를 참조
     */
    public static class Node {
        int data;  // stack에 저장되는 값
        Node next;  // 다음 노드를 가리키는 참조

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node top;  // stack 가장 위를 가리키는 pointer
    private int size;  // stack의 크기

    public LinkedListStack() {
        this.top = null;  // stack이 비어있으면 top은 null
        this.size = 0;  // 초기값
    }

    @Override
    public void push(int item) {
        Node newNode = new Node(item);  // 새 노드 생성
        newNode.next = top;  // 새 노드는 현재 top을 가리킴
        top = newNode;  // top을 새 노드로 업데이트
        size++;  // 크기 증가
    }

    @Override
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int item = top.data;
        top = top.next;  // top을 다음 노드로 이동
        size--;  // 크기 감소
        return item;
    }

    @Override
    public int peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        // return size == 0;
        return top == null;  // top이 null이면 스택이 비어있음
    }

    @Override
    public int search(int item) {
        int index = 0;
        Node current = top;
        while (current != null) {
            if (current.data == item) {
                return index;  // item 찾으면 index 반환
            }
            current = current.next; // 다음 노드로 이동
            index++;
        }
        return -1;
    }

    @Override
    public String toString() {
//        for (int i = 0; i < size; i++) {
//            sb.append(top.data);
//        }
//        return sb.toString();
        StringBuilder sb = new StringBuilder();
        Node current = top;
        sb.append("[");
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

//    public static void main(String[] args) {
//        LinkedListStack stack = new LinkedListStack();
//        stack.push(10);
//        stack.push(20);
//        stack.push(30);
//        System.out.println(stack);  // [30 20 10]
//        System.out.println(stack.pop());  // 30
//        System.out.println(stack);  // [20 10]
//        System.out.println(stack.peek());  // 20
//        System.out.println(stack.size());  // 2
//        System.out.println(stack.search(10));  // 1
//    }
}
