//imports
import java.util.*;

class SlidingWindowAverage{
    public static void main(String[] args){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter size of array: ");
            int size = sc.nextInt();
            System.out.println("Enter size of window: ");
            int windowSize = sc.nextInt();
            int[] array = new int[size];
            System.out.println("Enter " + size + " elements of array: ");
            for (int i = 0; i < size; ++i)
                array[i] = sc.nextInt();
            // call the function that returns result
            List res = calc_mov_avg(array, windowSize, size);

            Vector v = (Vector) res.get(0);
            int vectorSize = (Integer) res.get(1);
            Iterator<Integer> iterator = v.iterator();
            while (iterator.hasNext())
                System.out.println(" " + iterator.next());
            System.out.println("Size of vector: " + v.size());
        }
        catch (InputMismatchException e){
            e.printStackTrace();
        }
    }

    /**
     * method to calculate sliding window average
     * @param array array of input integers
     * @param windowSize size of window
     * @param size size of input array
     * @return returns list of 2 items vector of averages and length of vector [vector, lenght of vector]
     */
    public static List calc_mov_avg(int[] array, int windowSize, int size) {
        Vector<Integer> result = new Vector();
        int i = 0;
        while(i+windowSize-1 < size){
            int sum = 0;
            for(int j = i; j <= i+windowSize-1; j++){
                sum += array[j];
            }
            result.add((Integer)(sum/windowSize));
            ++i;
        }
        List vectorAndLength = new ArrayList();
        vectorAndLength.add(result);
        vectorAndLength.add(result.size());

        return vectorAndLength;
    }

}