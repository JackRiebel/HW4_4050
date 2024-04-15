public class Heap {
    private int[] keys;
    private int[] ids;
    private int size;

    public Heap(int[] keys, int n) {
        this.keys = new int[n + 1];
        this.ids = new int[n + 1];
        System.arraycopy(keys, 0, this.keys, 1, n);
        for (int i = 1; i <= n; i++) {
            this.ids[i] = i;
        }
        this.size = n;
        buildHeap();
    }

    // Other methods of the Heap class...

    // Initialize the heap with given keys
    public void heap_ini(int[] keys, int n) {
        // Implementation
    }

    // Check if element with given id is in the heap
    public void in_heap(int id) {
        // Implementation
    }

    // Return the minimum key of the heap
    public void min_key() {
        // Implementation
    }

    // Return the id of the element with minimum key
    public void min_id() {
        // Implementation
    }

    // Return the key of the element with given id
    public void key(int id) {
        // Implementation
    }

    // Delete the element with minimum key from the heap
    public void delete_min() {
        // Implementation
    }

    // Decrease the key of the element with given id to new_key
    public void decrease_key(int id, int new_key) {
        // Implementation
    }
}
