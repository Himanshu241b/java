package April_2;

public class StockTransactions {
    public static int maxProfit(int n, int[] prices) {
        int buy1 = Integer.MIN_VALUE, sell1 = 0;
        int buy2 = Integer.MIN_VALUE, sell2 = 0;

        for (int price : prices) {
            buy1 = Math.max(buy1, -price); // Maximum profit after first buy
            sell1 = Math.max(sell1, buy1 + price); // Maximum profit after first sell
            buy2 = Math.max(buy2, sell1 - price); // Maximum profit after second buy
            sell2 = Math.max(sell2, buy2 + price); // Maximum profit after second sell
        }

        return sell2; // Maximum profit after two transactions
    }

    public static void main(String[] args) {
        int[] prices1 = {1, 3, 1, 2, 4, 8};
        int[] prices2 = {5, 4, 3, 2, 1};

        System.out.println(maxProfit(6, prices1)); // Output: 9
        System.out.println(maxProfit(5, prices2)); // Output: 0
    }
}

