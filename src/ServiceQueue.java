public class ServiceQueue {
    private static class Node {
        ServiceRequest data;
        Node next;
        Node(ServiceRequest data) { this.data = data; }
    }

    private Node front;
    private Node rear;

    public void enqueue(ServiceRequest request) {
        Node newNode = new Node(request);
        if (rear == null) {
            front = rear = newNode;
            return;
        }
        rear.next = newNode;
        rear = newNode;
    }

    public ServiceRequest dequeue() {
        if (front == null) return null;

        ServiceRequest request = front.data;
        front = front.next;
        if (front == null) rear = null;
        return request;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public void display() {
        System.out.println("\n--- Service Queue (FIFO) ---");
        if (isEmpty()) {
            System.out.println("No service requests available.");
            return;
        }

        Node current = front;
        int count = 1;
        while (current != null) {
            System.out.println(count + ". " + current.data);
            current = current.next;
            count++;
        }
    }
}
