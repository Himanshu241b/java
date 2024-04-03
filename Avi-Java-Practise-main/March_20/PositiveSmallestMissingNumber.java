package March_20;

public class PositiveSmallestMissingNumber {

    //Function to find the smallest positive number missing from the array.
    static int missingNumber(int arr[], int size)
    {
        // Your code here
        for(int i=0; i<size; i++)
        {
            int currIndex = arr[i] - 1;

            while(currIndex < size && currIndex >=0 && arr[currIndex] != arr[i])
            {
                int temp = arr[i];
                arr[i] = arr[currIndex];
                arr[currIndex] = temp;
                currIndex = arr[i] - 1;
            }
        }

        for(int i=0; i<size; i++)
        {
            if(arr[i] != i+1) return i+1;
        }
        return size+1;
    }
    public static void main(String[] args) {

        int[] arr = {0, -10, 1, 3, -20};
        int size = arr.length;

        System.out.println(missingNumber(arr, size));
    }
}
