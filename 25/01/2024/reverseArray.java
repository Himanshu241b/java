public class reverseArray {
    public static void main(String[] args){
        int[] arr = {1,2,3,4,5,6,7}; // array decleration
        int i = 0;  // first index  of array          
        int j = arr.length-1; // last index of array
        while(i < j){
            swap(arr, i, j);
            ++i;
            --j;
        }
        printArr(arr);
    }

    public static void swap(int[] arr, int i, int j){ // swap function
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void printArr(int[] arr){ // print function to print array elements 
        for(int i = 0; i < arr.length; ++i){
        System.out.print(arr[i]+" ");
        }
    }

}
