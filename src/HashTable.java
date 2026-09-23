public class HashTable {
    private static class Entry {
        String key;
        Student value;
        Entry next;

        Entry(String key, Student value) {
            this.key = key;
            this.value = value;
        }
    }

    private final Entry[] table;

    public HashTable(int size) {
        table = new Entry[size];
    }

    private int hash(String key) {
        return Math.abs(key.toUpperCase().hashCode()) % table.length;
    }

    public void put(Student student) {
        String key = student.getStudentId();
        int index = hash(key);

        Entry current = table[index];
        while (current != null) {
            if (current.key.equalsIgnoreCase(key)) {
                current.value = student;
                return;
            }
            current = current.next;
        }

        Entry newEntry = new Entry(key, student);
        newEntry.next = table[index];
        table[index] = newEntry;
    }

    public Student get(String key) {
        int index = hash(key);
        Entry current = table[index];

        while (current != null) {
            if (current.key.equalsIgnoreCase(key)) return current.value;
            current = current.next;
        }
        return null;
    }

    public void remove(String key) {
        int index = hash(key);
        Entry current = table[index];
        Entry previous = null;

        while (current != null) {
            if (current.key.equalsIgnoreCase(key)) {
                if (previous == null) table[index] = current.next;
                else previous.next = current.next;
                return;
            }
            previous = current;
            current = current.next;
        }
    }
}
