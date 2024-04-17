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
        this.keys = new int[n+1];
        this.ids = new int[n+1];
        System.arraycopy(keys, 0, this.keys, 1, n);
        for (int i = 1; i <= n; i++) {
            this.ids[i] = i;
        }
        this.size = n;
        buildHeap();
    }

    // Check if element with given id is in the heap
    public boolean in_heap(int id) {
        return id <= size && id > 0;
    }

    // Return the minimum key of the heap
    public int min_key() {
        if (size > 0) return keys[1];
        else return -1;
    }

    // Return the id of the element with minimum key
    public int min_id() {
        if (size > 0) return ids[1];
        else return -1;
    }

    // Return the key of the element with given id
    public int key(int id) {
        if (id <= size && id > 0) return keys[id];
        else return -1;
    }

    // Delete the element with minimum key from the heap
    public void delete_min() {
        if (size > 0) {
            keys[1] = keys[size];
            ids[1] = ids[size];
            size--;
            heapify(1);
        }
    }

    // Decrease the key of the element with given id to new_key
    public void decrease_key(int id, int new_key) {
        if (id > 0 && id <= size && keys[id] > new_key) {
            keys[id] = new_key;
            while (id > 1 && keys[id / 2] > keys[id]) {
                swap(id, id / 2);
                id = id / 2;
            }
        }
    }
}
