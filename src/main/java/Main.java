import stack.impl.ArrayListStack;
import stack.impl.ArrayStack;
import stack.impl.LinkedListStack;

public class Main {
    public static void main(String[] args) {
        Timer timer = new Timer();
        int testSize = 100_000;

        ArrayStack arrayStack = new ArrayStack(testSize);
        ArrayListStack arrayListStack = new ArrayListStack(testSize);
        LinkedListStack linkedListStack = new LinkedListStack();

        timer.start();
        for (int i = 0; i < testSize; i++) {
            arrayStack.push(i);
        }
        timer.end("ArrayStack push");

        timer.start();
        for (int i = 0; i < testSize; i++) {
            arrayListStack.push(i);
        }
        timer.end("ArrayListStack push");

        timer.start();
        for (int i = 0; i < testSize; i++) {
            linkedListStack.push(i);
        }
        timer.end("LinkedListStack push");

        timer.start();
        arrayStack.toString();
        timer.end("ArrayStack");

        timer.start();
        arrayListStack.toString();
        timer.end("ArrayListStack");

        timer.start();
        linkedListStack.toString();
        timer.end("LinkedListStack");

        timer.start();
        arrayStack.peek();
        timer.end("ArrayStack peek");

        timer.start();
        arrayListStack.peek();
        timer.end("ArrayListStack peek");

        timer.start();
        linkedListStack.peek();
        timer.end("LinkedListStack peek");

        timer.start();
        arrayStack.isEmpty();
        timer.end("ArrayStack isEmpty");

        timer.start();
        arrayListStack.isEmpty();
        timer.end("ArrayListStack isEmpty");

        timer.start();
        linkedListStack.isEmpty();
        timer.end("LinkedListStack isEmpty");

        timer.start();
        for (int i = 0; i < testSize; i++) {
            arrayStack.search(60000);
        }
        timer.end("ArrayStack search");

        timer.start();
        for (int i = 0; i < testSize; i++) {
            arrayListStack.search(60000);
        }
        timer.end("ArrayListStack search");

        timer.start();
        for (int i = 0; i < testSize; i++) {
            linkedListStack.search(60000);
        }
        timer.end("LinkedListStack search");

        timer.start();
        for (int i = 0; i < testSize; i++) {
            arrayStack.pop();
        }
        timer.end("ArrayStack pop");

        timer.start();
        for (int i = 0; i < testSize; i++) {
            arrayListStack.pop();
        }
        timer.end("ArrayListStack pop");

        timer.start();
        for (int i = 0; i < testSize; i++) {
            linkedListStack.pop();
        }
        timer.end("LinkedListStack pop");

    }
}