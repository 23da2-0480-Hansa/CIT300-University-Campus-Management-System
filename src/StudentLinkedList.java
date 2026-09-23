public class StudentLinkedList {
    private static class Node {
        Student data;
        Node next;
        Node(Student data) { this.data = data; }
    }

    private Node head;

    public boolean add(Student student) {
        if (search(student.getStudentId()) != null) return false;

        Node newNode = new Node(student);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) current = current.next;
            current.next = newNode;
        }
        return true;
    }

    public Student search(String id) {
        Node current = head;
        while (current != null) {
            if (current.data.getStudentId().equalsIgnoreCase(id)) return current.data;
            current = current.next;
        }
        return null;
    }

    public boolean update(String id, String name, String programme, double marks) {
        Student student = search(id);
        if (student == null) return false;
        student.setName(name);
        student.setProgramme(programme);
        student.setMarks(marks);
        return true;
    }

    public Student delete(String id) {
        if (head == null) return null;

        if (head.data.getStudentId().equalsIgnoreCase(id)) {
            Student removed = head.data;
            head = head.next;
            return removed;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.data.getStudentId().equalsIgnoreCase(id)) {
                Student removed = current.next.data;
                current.next = current.next.next;
                return removed;
            }
            current = current.next;
        }
        return null;
    }

    public void display() {
        if (head == null) {
            System.out.println("No student records available.");
            return;
        }

        System.out.println("\n--- Student Records (Linked List) ---");
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }
}
