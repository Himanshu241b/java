public class reverseArray {
    public static void main(String[]args)
    {
        int[] arr = {1, 2, 3, 4, 5};

        for(int i=arr.length-1; i>=0; i--)
        {
            int temp = arr[0];
            for(int j=1; j<=i; j++)
            {
                arr[j-1] = arr[j];
            }
            arr[i] = temp;
        }
        for(int i=0; i<arr.length; i++) System.out.print(arr[i]);
    }
}
