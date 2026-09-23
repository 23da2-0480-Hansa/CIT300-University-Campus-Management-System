import java.util.*;

public class Graph {
    private final Map<String, LinkedHashSet<String>> adjacencyList = new LinkedHashMap<>();

    public boolean addLocation(String location) {
        if (adjacencyList.containsKey(location)) return false;
        adjacencyList.put(location, new LinkedHashSet<>());
        return true;
    }

    public boolean removeLocation(String location) {
        if (!adjacencyList.containsKey(location)) return false;

        adjacencyList.remove(location);
        for (Set<String> neighbours : adjacencyList.values()) {
            neighbours.remove(location);
        }
        return true;
    }

    public boolean addConnection(String from, String to) {
        if (!adjacencyList.containsKey(from) || !adjacencyList.containsKey(to)) return false;
        if (from.equalsIgnoreCase(to)) return false;

        boolean alreadyExists = adjacencyList.get(from).contains(to);
        if (alreadyExists) return false;

        adjacencyList.get(from).add(to);
        adjacencyList.get(to).add(from);
        return true;
    }

    public boolean removeConnection(String from, String to) {
        if (!adjacencyList.containsKey(from) || !adjacencyList.containsKey(to)) return false;

        boolean removed = adjacencyList.get(from).remove(to);
        adjacencyList.get(to).remove(from);
        return removed;
    }

    public boolean hasLocation(String location) {
        return adjacencyList.containsKey(location);
    }

    public void display() {
        System.out.println("\n--- Campus Network (Adjacency List) ---");
        if (adjacencyList.isEmpty()) {
            System.out.println("No campus locations available.");
            return;
        }

        for (Map.Entry<String, LinkedHashSet<String>> entry : adjacencyList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");
            if (entry.getValue().isEmpty()) {
                System.out.println("No direct connections");
            } else {
                System.out.println(String.join(", ", entry.getValue()));
            }
        }
    }

    public void bfs(String start) {
        System.out.println("\n--- BFS Traversal ---");
        if (!adjacencyList.containsKey(start)) {
            System.out.println("Starting location not found.");
            return;
        }

        Set<String> visited = new LinkedHashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current);

            for (String neighbour : adjacencyList.get(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.add(neighbour);
                }
            }

            if (!queue.isEmpty()) System.out.print(" -> ");
        }
        System.out.println();
    }
}
