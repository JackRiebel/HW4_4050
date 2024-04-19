public class Heap {
    private float[] keys;
    private int[] ids;
    private int[] V;
    private int size;

    public Heap(float[] keys, int n) {
        this.keys = new float[n + 1];
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
    public void heap_ini(float[] keys, int n) {
        this.keys = new float[n+1];
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
    public float min_key() {
        if (size > 0) return keys[1];
        else return -1;
    }

    // Return the id of the element with minimum key
    public int min_id() {
        if (size > 0) return ids[1];
        else return -1;
    }

    // Return the key of the element with given id
    public float key(int id) {
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
    public void decrease_key(int id, float new_key) {
        //System.out.println("id: " + id + " - size: " + size + "keys[id]" + keys[id] + " - ids[id] = " + ids[id]);
        if (id > 0 && id <= size){ //&& keys[id] > new_key) {
            keys[id] = new_key;
            while (id > 1 && keys[id / 2] > keys[id]) {
                swap(id, id / 2);
                id = id / 2;
            }
        }
    }
    public int findId(int vertex){
        for(int i = 1; i < size+1; i++){
            if(ids[i] == vertex){
                return i;
            }
        }
        return -1;
    }

    private void buildHeap() {
        for (int i = size / 2; i >= 1; i--) {
            heapify(i);
        }
    }

    private void heapify(int i) {
        int smallest = i;
        int left = 2 * i;
        int right = 2 * i + 1;
        if (left <= size && keys[left] < keys[smallest]) smallest = left;
        if (right <= size && keys[right] < keys[smallest]) smallest = right;
        if (smallest != i) {
            swap(i, smallest);
            heapify(smallest);
        }
    }

    private void swap(int i, int j) {
        float tempKey = keys[i];
        keys[i] = keys[j];
        keys[j] = tempKey;

        int tempId = ids[i];
        ids[i] = ids[j];
        ids[j] = tempId;
    }
}
