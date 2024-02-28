//imports
import java.util.Scanner;
import java.util.List;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.ArrayList;

class SlidingWindowMaximum{
    public static void main(String[] args){
        Scanner sc = new Scanner((System.in));
        System.out.println("Enter size of input array:");
        int size = sc.nextInt();
        System.out.println("Enter the window size");
        int k = sc.nextInt();
        int[] array = new int[size];
        System.out.println("Enter the " + size + " elements of input array:");
        for(int i = 0; i < size;++i)
            array[i] = sc.nextInt();
        List resultArray = slidingWindowMaximum(array, k);
        //print resultant arary of maximum elements
        for(int i = 0; i < resultArray.size();++i)
            System.out.println(resultArray.get(i));

    }

    /**
     * Calculates the sliding window maximum array
     * @param array input array
     * @param k sliding window size
     * @return list of maximum elements of input according to sliding window
     */
    public static List slidingWindowMaximum(int[] array, int k){
        // list to store result
        List<Integer> resultArray = new ArrayList<Integer>();
        //deque to keep track of index of max element in window
        Deque<Integer> dq = new ArrayDeque<Integer>();
        for(int i = 0; i < array.length; i++){
            if(!dq.isEmpty() &&(i-k) == dq.peekFirst()) // when first element exits the window
                dq.pollFirst();
            while(!dq.isEmpty() && array[i] > array[dq.peekLast()]) // ith element is greater than last max element index added
                dq.pollLast();
            dq.add(i); // add the ith element
            if(i >= (k-1)) // start adding in result when first window is reached
                resultArray.add(array[dq.peekFirst()]);
        }
        return resultArray;
    }
}