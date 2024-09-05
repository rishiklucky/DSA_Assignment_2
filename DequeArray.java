/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package deque;

/**
 *
 * @author nalla
 */
class Deque {
    private int[] arr;   // Array to store deque elements
    private int front;   // Points to front of the deque
    private int rear;    // Points to rear of the deque
    private int size;    // Maximum size of the deque
    private int count;   // Current number of elements in deque

    // Constructor to initialize the deque
    public Deque(int size) {
        arr = new int[size];
        front = -1;
        rear = 0;
        this.size = size;
        count = 0;
    }

    // Check if the deque is full
    public boolean isFull() {
        return (count == size);
    }

    // Check if the deque is empty
    public boolean isEmpty() {
        return (count == 0);
    }

    // Insert an element at the front
    public void insertFront(int item) {
        if (isFull()) {
            System.out.println("Overflow: Deque is full");
            return;
        }

        if (front == -1) {  // Empty deque
            front = 0;
            rear = 0;
        } else if (front == 0) {
            front = size - 1;  // Wrap around
        } else {
            front = front - 1;
        }

        arr[front] = item;
        count++;
    }

    // Insert an element at the rear
    public void insertRear(int item) {
        if (isFull()) {
            System.out.println("Overflow: Deque is full");
            return;
        }

        if (front == -1) {  // Empty deque
            front = 0;
            rear = 0;
        } else if (rear == size - 1) {
            rear = 0;  // Wrap around
        } else {
            rear = rear + 1;
        }

        arr[rear] = item;
        count++;
    }

    // Delete an element from the front
    public void deleteFront() {
        if (isEmpty()) {
            System.out.println("Underflow: Deque is empty");
            return;
        }

        if (front == rear) {  // Only one element
            front = -1;
            rear = -1;
        } else if (front == size - 1) {
            front = 0;  // Wrap around
        } else {
            front = front + 1;
        }

        count--;
    }

    // Delete an element from the rear
    public void deleteRear() {
        if (isEmpty()) {
            System.out.println("Underflow: Deque is empty");
            return;
        }

        if (front == rear) {  // Only one element
            front = -1;
            rear = -1;
        } else if (rear == 0) {
            rear = size - 1;  // Wrap around
        } else {
            rear = rear - 1;
        }

        count--;
    }

    // Get the front element
    public int getFront() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        return arr[front];
    }

    // Get the rear element
    public int getRear() {
        if (isEmpty()) {
            System.out.println("Deque is empty");
            return -1;
        }
        return arr[rear];
    }
    
    // Get the current size of the deque
    public int size() {
        return count;
    }
}

// Driver code to test the deque
public class DequeArray {
    public static void main(String[] args) {
        Deque deque = new Deque(5);

        deque.insertRear(10);
        deque.insertRear(20);
        System.out.println("Rear element: " + deque.getRear());

        deque.insertFront(5);
        System.out.println("Front element: " + deque.getFront());

        deque.deleteRear();
        System.out.println("Rear element after deletion: " + deque.getRear());

        deque.deleteFront();
        System.out.println("Front element after deletion: " + deque.getFront());
    }
}




//Output:
//Rear element: 20
//Front element: 5
//Rear element after deletion: 10
//Front element after deletion: 10


