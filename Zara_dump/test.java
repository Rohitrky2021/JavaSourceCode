
import java.util.*;

class test{
// }

// public class Solution {
    public static int getMaximizedFunds(int k, int f, List<Integer> price, List<Integer> profit) {
        // Create a list of stocks with their prices and profits
        List<String> ans=new List<String>() {
            
        };
        Arrays.
        List<Stock> stocks = new ArrayList<>();
        int n = price.size();
        for (int i = 0; i < n; i++) {
            stocks.add(new Stock(price.get(i), profit.get(i)));
        }
    
        // Sort the stocks based on their profit in descending order
        Collections.sort(stocks, (s1, s2) -> s2.profit - s1.profit);
    
        // Select at most k stocks for k days
        for (int i = 0; i < k && i < n; i++) {
            Stock stock = stocks.get(i);
            if (stock.price <= f) {
                f += stock.profit;  // Add the profit to the funds
            }
        }
    
        return f;
    }
    
    static class Stock {
        int price;
        int profit;
    
        public Stock(int price, int profit) {
            this.price = price;
            this.profit = profit;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        int f = scanner.nextInt();
        int n = scanner.nextInt();

        List<Integer> price = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            price.add(scanner.nextInt());
        }

        List<Integer> profit = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            profit.add(scanner.nextInt());
        }

        int result = getMaximizedFunds(k, f, price, profit);
        System.out.println(result);
    }

    public static int findSumOfJumbledString(String s) {

    }

}
