import java.util.Scanner;
class arraysum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of array elements:");
        int n = sc.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the "+n+" elemnts of array");
        // take input for array elements
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }
        // sum the array in variable sum
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum+=array[i];
        }
        System.out.println("array sum = "+sum);
    }
}