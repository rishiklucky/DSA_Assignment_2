/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stackusingtwoqueues;

/**
 *
 * @author nalla
 */
class Queue {

    private int[] arr;
    private int front;
    private int rear;
    private int capacity;
    private int count;

    // Constructor to initialize the queue
    public Queue(int size) {
        arr = new int[size];
        capacity = size;
        front = 0;
        rear = -1;
        count = 0;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return (count == 0);
    }

    // Check if the queue is full
    public boolean isFull() {
        return (count == capacity);
    }

    // Add an element to the queue
    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Overflow: Queue is full");
            return;
        }
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        count++;
    }

    // Remove an element from the queue
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Underflow: Queue is empty");
            return -1;
        }
        int item = arr[front];
        front = (front + 1) % capacity;
        count--;
        return item;
    }

    // Get the front element of the queue
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return arr[front];
    }

    // Get the current size of the queue
    public int size() {
        return count;
    }
}

class StackUsingTwoQueues1 {

    private Queue queue1;
    private Queue queue2;

    // Constructor to initialize the stack with a given size
    public StackUsingTwoQueues1(int size) {
        queue1 = new Queue(size);
        queue2 = new Queue(size);
    }

    // Push an element to the stack
    public void push(int data) {
        if (queue1.isFull()) {
            System.out.println("Stack Overflow: No space left to push");
            return;
        }

        // Push the new element into queue2
        queue2.enqueue(data);

        // Transfer all elements from queue1 to queue2
        while (!queue1.isEmpty()) {
            queue2.enqueue(queue1.dequeue());
        }

        // Swap queue1 and queue2
        Queue temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    // Pop an element from the stack
    public int pop() {
        if (queue1.isEmpty()) {
            System.out.println("Stack Underflow: No elements to pop");
            return -1;
        }
        return queue1.dequeue();  // The front of queue1 is the top of the stack
    }

    // Peek the top element of the stack
    public int top() {
        if (queue1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }
        return queue1.peek();  // The front of queue1 is the top of the stack
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }

    // Get the size of the stack
    public int size() {
        return queue1.size();
    }
}

// Driver code to test the user-defined stack using two queues
public class StackUsingTwoQueues {

    public static void main(String[] args) {
        StackUsingTwoQueues1 stack = new StackUsingTwoQueues1(5);

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.top());  // Output: 30
        System.out.println("Stack size: " + stack.size());  // Output: 3

        stack.pop();
        System.out.println("Top element after pop: " + stack.top());  // Output: 20

        stack.pop();
        stack.pop();

        System.out.println("Is stack empty? " + stack.isEmpty());  // Output: true
    }
}




//Output:
//Top element: 30
//Stack size: 3
//Top element after pop: 20
//Is stack empty? true