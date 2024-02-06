import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
    public static void main(String[] args) {
        
        Queue<Integer> queue1 = new LinkedList<>();
        queue1.add(5);
        queue1.add(24);
        queue1.add(9);
        queue1.add(6);
        queue1.add(8);
        queue1.add(4);
        queue1.add(1);
        queue1.add(8);
        queue1.add(3);
        queue1.add(6);
        
        reverseQueue(queue1);
        System.out.println(queue1); 

        
        Queue<Integer> queue2 = new LinkedList<>();
        queue2.add(8);
        queue2.add(7);
        queue2.add(2);
        queue2.add(5);
        queue2.add(1);

        reverseQueue(queue2);
        System.out.println(queue2); // print the queue
    }

    public static void reverseQueue(Queue<Integer> queue) {
        if (!queue.isEmpty()) {
            int front = queue.poll(); // Dequeue the front element
            reverseQueue(queue); // Recursively reverse the remaining queue
            queue.add(front); // Enqueue the dequeued element to the rear of the reversed queue
        }
    }
}
