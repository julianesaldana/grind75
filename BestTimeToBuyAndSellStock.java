public class BestTimeToBuyAndSellStock {
    public static void main(String[] args) {

    }

    public static int maxProfit(int[] prices) {
        int buy = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (buy > prices[i])    // always trying to buy at lowest
                buy = prices[i];
            else if (prices[i] - buy > maxProfit) // if not lowest, checking to see if day contains higher profit
                maxProfit = prices[i] - buy;
        }
        return maxProfit;
    }
}
