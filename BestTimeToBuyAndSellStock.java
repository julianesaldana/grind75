public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {

    }

    public static int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buy)  // always trying to buy at lowest
                buy = prices[i];
            else if (prices[i] - buy > maxProfit)   // if not found a new day thats lowest, check profit for the current lowest day
                maxProfit = prices[i] - buy;    // set max profit if so
        }
        return maxProfit;
    }
}
