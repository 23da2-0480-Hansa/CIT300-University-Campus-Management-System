public class ActionStack {
    private static class Node {
        String action;
        Node next;
        Node(String action) { this.action = action; }
    }

    private Node top;

    public void push(String action) {
        Node newNode = new Node(action);
        newNode.next = top;
        top = newNode;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public void display() {
        System.out.println("\n--- Recent Actions (Stack - LIFO) ---");
        if (isEmpty()) {
            System.out.println("No recent actions available.");
            return;
        }

        Node current = top;
        int count = 1;
        while (current != null) {
            System.out.println(count + ". " + current.action);
            current = current.next;
            count++;
        }
    }
}
