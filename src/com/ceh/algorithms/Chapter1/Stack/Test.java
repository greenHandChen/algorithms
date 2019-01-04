package com.ceh.algorithms.Chapter1.Stack;

public class Test {
    public static void main(String[] args) {
        stackArrayTest();
    }

    public static void stackLinkedTest() {
        Stack<Integer> stacks = new Stack<>();
        stacks.push(5);
        stacks.push(4);
        stacks.push(3);
        stacks.push(8);
        stacks.push(7);
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
        System.out.println(stacks.pop());
    }

    public static void stackArrayTest() {
        StackArray<Integer> stackArrays = new StackArray<>();
        System.out.println(stackArrays.length());
        for (int i = 0; i < 17; i++) {
            stackArrays.push(i);
        }
        System.out.println(stackArrays.length());
        stackArrays.forEach(stackArray -> System.out.println(stackArray));
    }
}
