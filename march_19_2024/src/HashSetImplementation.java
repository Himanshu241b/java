import java.util.LinkedList;

public class HashSetImplementation {
    public static void main(String[] args) {
        HashSet hashSet = new HashSet();
        hashSet.add(500);
        hashSet.add(200);
        hashSet.add(400);
        System.out.println(hashSet.contains(200));
        System.out.println(hashSet.contains(600));
        System.out.println(hashSet.remove(400));
        System.out.println(hashSet.remove(700));
    }
}

class HashSet {
    private static final int SIZE = 1000;
    private LinkedList<Integer>[] buckets;

    // constructor
    public HashSet(){
        buckets = new LinkedList[SIZE];
        for(int bucket = 0; bucket < SIZE; bucket++){
            buckets[bucket] = new LinkedList<Integer>();
        }
    }

    // hash value method
    public int hash(int value){
        return value % SIZE;
    }

    // add method
    public boolean add(int value){
        int index = hash(value);
        LinkedList<Integer> bucket = buckets[index];
        if(!bucket.contains(value)){
            bucket.add(value);
            return true;
        }
        return false;
    }

    // contains method
    public boolean contains(int value){
        int index = hash(value);
        LinkedList<Integer> bucket = buckets[index];
        if(!bucket.contains(value)){
            return false;
        }
        return true;
    }

    // remove method
    public int remove(int value){
        int index = hash(value);
        LinkedList<Integer> bucket = buckets[index];
        if(bucket.contains(value)){
            bucket.remove(Integer.valueOf(value));
            return value;
        }
        return -1;
    }
}