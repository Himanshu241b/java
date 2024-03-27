import java.util.Scanner;

public class HouseRobber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of houses  ");
        int NumberOfHouses = scanner.nextInt();

        int[] houses = new int[NumberOfHouses];
        System.out.print("Enter the amounts of money in each house: ");
        for (int i = 0; i < NumberOfHouses; i++) {
            houses[i] = scanner.nextInt();
        }

        int result = maxAmountRobbed(NumberOfHouses, houses);
        System.out.println("Maximum amount of money  can rob: " + result);


    }

    public static int maxAmountRobbed(int N, int[] houses) {
        if (N == 0) return 0;
        if (N == 1) return houses[0];

        // Calculate maximum amount robbed if first house is included
        int includeFirst = houseRob(houses, 0, N - 2);

        // Calculate maximum amount robbed if first house is excluded
        int excludeFirst = houseRob(houses, 1, N - 1);

        // Return the maximum of the two cases
        return Math.max(includeFirst, excludeFirst);
    }


    private static int houseRob(int[] houses, int start, int end) {
        int inclusive = 0;
        int exclusive = 0;

        for (int i = start; i <= end; i++) {
            int temp = inclusive;
            inclusive = Math.max(inclusive, exclusive + houses[i]);
            exclusive = temp;
        }

        return Math.max(inclusive, exclusive);
    }
}
