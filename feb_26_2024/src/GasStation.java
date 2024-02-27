//imports
import java.util.Scanner;
class GasStation{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of gas and cost array:");
        int size = sc.nextInt();
        int gas[] = new int[size];
        int cost[] = new int[size];
        System.out.println("Enter the gas array elements:");
        for (int i = 0; i < size; i++)
            gas[i] = sc.nextInt();
        System.out.println("Enter the cost array elements:");
        for (int i = 0; i < size; i++)
                cost[i] = sc.nextInt();
        int index = findStartingIndex(gas, cost, size);
        if(index != -1){
            System.out.println("start index:"+ index);
        }
        else
            System.out.println("Circuit cant be completed");
    }

    /**
     * method that returns the starting index to complete the circuit
     * @param gas represents the gas available at ith index station
     * @param cost represents the cost required to reach next station
     * @param size size of circuit or the array
     * @return the starting index to complete the circuit
     */
    public static int findStartingIndex(int[] gas, int[] cost, int size){
        int balance = 0;
        int deficit = 0;
        int ind = 0;
        for(int i = 0; i < size; ++i){
            balance = balance + gas[i] - cost[i];
            if(balance < 0) {
                ind = i + 1;
                deficit += balance;
                balance = 0;
            }
        }
        if(balance + deficit < 0)
            return -1;
        else
            return ind;
    }
}