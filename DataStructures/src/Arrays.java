public class Arrays {
    // TWO SUM
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

    // BEST TIME TO BUY AND SELL STOCK
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];    // set buy stock as first element

        for (int i = 1; i < prices.length; i++) {
            if (buy < prices[i]) {   // stock is worth more next day, ie price is higher than buy price
                int profit = prices[i] - buy;
                if (profit > maxProfit){
                    maxProfit = profit;
                }
            } else {
                buy = prices[i];    // if not worth more than buy, set next day as buy, cant make profit
            }
        }
        return maxProfit;
    }

    // PRODUCT OF ARRAY EXCEPT SELF
    public int[] productExceptSelf(int[] nums) {
        // answer fits in data type int, 32 bit max
        // must NOT use division operation, must run O(n)

        // this works for one number of the array
//        int current = 0;
//        int product = nums[current];
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] == nums[current]) {
//                continue;   // skip multiplying if it is the number itself
//            } else {
//                product = product * nums[i];    // multiply itself with the value of the item
//            }
//        }
//        nums[current] = product;    // after going through every number, set new value as the product of all numbers multiplied except chosen value
//

        int[] products = new int[nums.length];  // need new array to store new values
        for (int i = 0; i < nums.length; i++) {     // iterate through list once
            int product = 1;
            for (int j = 0; j < nums.length; j++) {
                if (j != i) {   // excluding if the number is itself
                    if (nums[j] != 0)
                        product = product * nums[j];    // multiply itself with the value of the item
                    else {  // if number is 0, product will be 0
                        product = 0;
                        break;
                    }
                }
            }
            products[i] = product;    // after going through every number, set new value as the product of all numbers multiplied except chosen value
        }
        return products;
    }
}
