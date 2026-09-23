public class StudentBST {
    private static class Node {
        Student data;
        Node left, right;
        Node(Student data) { this.data = data; }
    }

    private Node root;

    public boolean insert(Student student) {
        if (search(student.getStudentId()) != null) return false;
        root = insertRecursive(root, student);
        return true;
    }

    private Node insertRecursive(Node node, Student student) {
        if (node == null) return new Node(student);

        int comparison = student.getStudentId().compareToIgnoreCase(node.data.getStudentId());
        if (comparison < 0) node.left = insertRecursive(node.left, student);
        else if (comparison > 0) node.right = insertRecursive(node.right, student);

        return node;
    }

    public Student search(String id) {
        Node current = root;
        while (current != null) {
            int comparison = id.compareToIgnoreCase(current.data.getStudentId());
            if (comparison == 0) return current.data;
            current = comparison < 0 ? current.left : current.right;
        }
        return null;
    }

    public void displayInOrder() {
        System.out.println("\n--- Students using BST (In-Order) ---");
        if (root == null) {
            System.out.println("BST is empty.");
            return;
        }
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.data);
        inOrder(node.right);
    }
}
