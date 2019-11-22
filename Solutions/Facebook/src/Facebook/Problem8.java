package Facebook;

/*

Given a array of numbers representing the stock prices of a company in chronological order,
write a function that calculates the maximum profit you could have made from buying and selling that stock once.
You must buy before you can sell it.

For example, given [9, 11, 8, 5, 7, 10], you should return 5,
since you could buy the stock at 5 dollars and sell it at 10 dollars.

*/

import java.util.List;

class Problem8 {

    static int getMaxProfit(List<Integer> stockVariations) {

        int maxProfit = 0;

        for (int i = 0; i < stockVariations.size() - 1; ++i) {
            int currentPrice = stockVariations.get(i);

            for (int j = i + 1; j < stockVariations.size(); j++) {
                int nextPrice = stockVariations.get(j);
                
                if (currentPrice < nextPrice) {
                    int profitMargin = nextPrice - currentPrice;
                    if (profitMargin > maxProfit) {
                        maxProfit = profitMargin;
                    }
                }
            }
        }

        return maxProfit;
    }
}
