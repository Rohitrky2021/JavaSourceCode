import java.util.HashMap;
import java.util.Map;

public class R {

    private Map<Integer, Integer> s = new HashMap<>();
    private Map<Integer, Double> r = new HashMap<>();
    private int d = -1;

    public void o(int i) {
        s.put(i, 0);
    }

    public void m(int i) {
        d = i;
    }

    public void a(int i, int t) {
        r.put(i, (r.getOrDefault(i, 0.0) + t) / 2);
    }

    public void re(int i) {
        s.put(i, 1);
    }

    public int g() {
        if (d != -1) {
            if (s.getOrDefault(d, 0) > 0) {
                return d;
            } else {
                return h();
            }
        } else {
            return h();
        }
    }

    private int h() {
        double maxRating = -1.0;
        int recommendedItem = -1;

        for (Map.Entry<Integer, Double> entry : r.entrySet()) {
            int i = entry.getKey();
            double t = entry.getValue();

            if (t > maxRating && s.getOrDefault(i, 0) > 0) {
                maxRating = t;
                recommendedItem = i;
            }
        }

        return recommendedItem;
    }

    public static void main(String[] args) {
        R recommend = new R();

        // Sample data
        recommend.re(1);
        recommend.re(2);
        recommend.a(1, 2);
        recommend.a(2, 3);
        // recommend.m(2);

        // Get recommendation
        int recommendation = recommend.g();

        // Print recommendation
        if (recommendation != -1) {
            System.out.println("Recommended item: " + recommendation);
        } else {
            System.out.println("No recommendation available.");
        }
    }
}

 
public class Recommend {

    private Map<Integer, Integer> stockMap = new HashMap<>();
    private Map<Integer, Double> ratingMap = new HashMap<>();
    private int dealOfTheDayItem = -1;

    public void outOfStock(int itemId) {
        stockMap.put(itemId, 0);
    }

    public void makeDealOfTheDayItem(int itemId) {
        dealOfTheDayItem = itemId;
    }

    public void rateItem(int itemId, int rating) {
        ratingMap.put(itemId, (ratingMap.getOrDefault(itemId, 0.0) + rating) / 2);
    }

    public void restockItem(int itemId) {
        stockMap.put(itemId, 1);
    }

    public int getRecommendation() {
        if (dealOfTheDayItem != -1) {
            if (stockMap.getOrDefault(dealOfTheDayItem, 0) > 0) {
                return dealOfTheDayItem;
            } else {
                return getHighestRatedInStockItem();
            }
        } else {
            return getHighestRatedInStockItem();
        }
    }

    private int getHighestRatedInStockItem() {
        double maxRating = -1.0;
        int recommendedItem = -1;

        for (Map.Entry<Integer, Double> entry : ratingMap.entrySet()) {
            int itemId = entry.getKey();
            double rating = entry.getValue();

            if (rating > maxRating && stockMap.getOrDefault(itemId, 0) > 0) {
                maxRating = rating;
                recommendedItem = itemId;
            }
        }

        return recommendedItem;
    }
}