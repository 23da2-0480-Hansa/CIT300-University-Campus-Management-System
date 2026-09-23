import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    private static final StudentLinkedList studentList = new StudentLinkedList();
    private static final ActionStack actionStack = new ActionStack();
    private static final ServiceQueue serviceQueue = new ServiceQueue();
    private static final StudentBST bst = new StudentBST();
    private static final HashTable hashTable = new HashTable(31);
    private static final Graph graph = new Graph();

    public static void main(String[] args) {
        System.out.println("==============================================");
        System.out.println(" UNIVERSITY STUDENT & CAMPUS ROUTE SYSTEM");
        System.out.println("==============================================");

        boolean running = true;

        while (running) {
            displayMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> updateStudent();
                case 3 -> deleteStudent();
                case 4 -> studentList.display();
                case 5 -> addServiceRequest();
                case 6 -> processServiceRequest();
                case 7 -> actionStack.display();
                case 8 -> bst.displayInOrder();
                case 9 -> searchUsingHashing();
                case 10 -> addLocation();
                case 11 -> removeLocation();
                case 12 -> addConnection();
                case 13 -> removeConnection();
                case 14 -> graph.display();
                case 15 -> traverseBFS();
                case 16 -> {
                    running = false;
                    System.out.println("Thank you for using the system.");
                }
                default -> System.out.println("Invalid menu choice. Please enter 1-16.");
            }
        }

        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n================ MAIN MENU ================");
        System.out.println("1. Add Student Record");
        System.out.println("2. Update Student Record");
        System.out.println("3. Delete Student Record");
        System.out.println("4. Display All Records using Linked List");
        System.out.println("5. Add Service Request to Queue");
        System.out.println("6. Process Next Service Request");
        System.out.println("7. Display Recent Actions using Stack");
        System.out.println("8. Display Students using BST");
        System.out.println("9. Search Student using Hashing");
        System.out.println("10. Add Campus Location");
        System.out.println("11. Remove Campus Location");
        System.out.println("12. Add Campus Connection/Road");
        System.out.println("13. Remove Campus Connection/Road");
        System.out.println("14. Display Campus Connections");
        System.out.println("15. Traverse Campus Locations using BFS");
        System.out.println("16. Exit");
        System.out.println("============================================");
    }

    private static void addStudent() {
        System.out.println("\n--- Add Student Record ---");

        String id = readNonEmpty("Student ID: ");
        if (studentList.search(id) != null) {
            System.out.println("Error: Student ID already exists.");
            return;
        }

        String name = readNonEmpty("Name: ");
        String programme = readNonEmpty("Programme: ");
        double marks = readMarks();

        Student student = new Student(id, name, programme, marks);

        studentList.add(student);
        bst.insert(student);
        hashTable.put(student);
        actionStack.push("Added student " + id);

        System.out.println("Student added successfully.");
    }

    private static void updateStudent() {
        System.out.println("\n--- Update Student Record ---");

        String id = readNonEmpty("Student ID: ");
        Student existing = studentList.search(id);

        if (existing == null) {
            System.out.println("Student not found.");
            return;
        }

        String name = readNonEmpty("New name: ");
        String programme = readNonEmpty("New programme: ");
        double marks = readMarks();

        studentList.update(id, name, programme, marks);
        hashTable.put(existing);
        actionStack.push("Updated student " + id);

        System.out.println("Student updated successfully.");
        System.out.println("Note: The BST keeps the student ID as its key, so the updated record remains searchable.");
    }

    private static void deleteStudent() {
        System.out.println("\n--- Delete Student Record ---");

        String id = readNonEmpty("Student ID: ");
        Student removed = studentList.delete(id);

        if (removed == null) {
            System.out.println("Student not found.");
            return;
        }

        hashTable.remove(id);
        actionStack.push("Deleted student " + id);

        System.out.println("Student deleted successfully.");
        System.out.println("Note: The BST component is demonstrated as an insertion/search structure; deleted records are removed from the primary list and hash table.");
    }

    private static void addServiceRequest() {
        System.out.println("\n--- Add Service Request ---");

        String id = readNonEmpty("Student ID: ");
        if (studentList.search(id) == null) {
            System.out.println("Student not found. Add the student record first.");
            return;
        }

        String request = readNonEmpty("Service request: ");
        serviceQueue.enqueue(new ServiceRequest(id, request));
        actionStack.push("Added service request for " + id);

        System.out.println("Service request added to the queue.");
    }

    private static void processServiceRequest() {
        System.out.println("\n--- Process Next Service Request ---");

        ServiceRequest request = serviceQueue.dequeue();

        if (request == null) {
            System.out.println("No service requests available.");
            return;
        }

        System.out.println("Processing: " + request);
        actionStack.push("Processed service request for " + request.getStudentId());
        System.out.println("Request processed successfully.");
    }

    private static void searchUsingHashing() {
        System.out.println("\n--- Search Student using Hashing ---");

        String id = readNonEmpty("Student ID: ");
        Student student = hashTable.get(id);

        if (student == null) {
            System.out.println("Student not found.");
        } else {
            System.out.println("Student found using Hashing:");
            System.out.println(student);
        }
    }

    private static void addLocation() {
        System.out.println("\n--- Add Campus Location ---");

        String location = readNonEmpty("Location name: ");

        if (!graph.addLocation(location)) {
            System.out.println("Error: Location already exists.");
            return;
        }

        actionStack.push("Added campus location " + location);
        System.out.println("Campus location added successfully.");
    }

    private static void removeLocation() {
        System.out.println("\n--- Remove Campus Location ---");

        String location = readNonEmpty("Location name: ");

        if (!graph.removeLocation(location)) {
            System.out.println("Error: Location not found.");
            return;
        }

        actionStack.push("Removed campus location " + location);
        System.out.println("Campus location removed successfully.");
    }

    private static void addConnection() {
        System.out.println("\n--- Add Campus Connection/Road ---");

        String from = readNonEmpty("First location: ");
        String to = readNonEmpty("Second location: ");

        if (!graph.hasLocation(from) || !graph.hasLocation(to)) {
            System.out.println("Error: One or both locations do not exist.");
            return;
        }

        if (!graph.addConnection(from, to)) {
            System.out.println("Error: Connection already exists or is invalid.");
            return;
        }

        actionStack.push("Added connection: " + from + " - " + to);
        System.out.println("Campus connection added successfully.");
    }

    private static void removeConnection() {
        System.out.println("\n--- Remove Campus Connection/Road ---");

        String from = readNonEmpty("First location: ");
        String to = readNonEmpty("Second location: ");

        if (!graph.removeConnection(from, to)) {
            System.out.println("Error: Connection does not exist.");
            return;
        }

        actionStack.push("Removed connection: " + from + " - " + to);
        System.out.println("Campus connection removed successfully.");
    }

    private static void traverseBFS() {
        System.out.println("\n--- BFS Campus Traversal ---");

        String start = readNonEmpty("Starting location: ");
        graph.bfs(start);
    }

    private static String readNonEmpty(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) return input;

            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    private static double readMarks() {
        while (true) {
            System.out.print("Marks (0-100): ");
            String input = scanner.nextLine().trim();

            try {
                double marks = Double.parseDouble(input);

                if (marks >= 0 && marks <= 100) return marks;

                System.out.println("Invalid marks. Enter a value between 0 and 100.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please enter marks between 0 and 100.");
            }
        }
    }

    private static int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();

            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }
}
