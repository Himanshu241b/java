package March_19;
import java.util.ArrayList;

class MyHashSet {
    private ArrayList<Integer>[] buckets;
    private static final int SIZE = 10000; // Size of the array

    public MyHashSet() {
        buckets = new ArrayList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            buckets[i] = new ArrayList<>();
        }
    }

    public void add(int value) {
        int index = getIndex(value);
        if (!buckets[index].contains(value)) {
            buckets[index].add(value);
        }
    }

    public boolean contains(int value) {
        int index = getIndex(value);
        return buckets[index].contains(value);
    }

    public int remove(int value) {
        int index = getIndex(value);
        ArrayList<Integer> bucket = buckets[index];
        for (int i = 0; i < bucket.size(); i++) {
            if (bucket.get(i) == value) {
                bucket.remove(i);
                return value;
            }
        }
        return -1;
    }

    private int getIndex(int value) {
        return value % SIZE;
    }
}
public class ImplementHashset {
    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();

        set.add(500);
        set.add(200);
        set.add(400);

        System.out.println(set.contains(200)); // Output: true
        System.out.println(set.contains(600)); // Output: false

        System.out.println(set.remove(200));   // Output: 200
    }
}
