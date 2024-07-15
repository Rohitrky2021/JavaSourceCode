import java.util.HashMap;
import java.util.Map;

public class Recommend {
    private Map<Integer, Item> itemMap = new HashMap<>();
    private Item dealOfTheDay = null;

    public void outOfStock(int itemId) {
        Item item = itemMap.get(itemId);
        if (item != null) {
            item.setInStock(false);
        }
    }

    public void makeDealOfTheDayItem(int itemId) {
        Item item = itemMap.get(itemId);
        if (item != null) {
            dealOfTheDay = item;
        }
    }

    public void rateItem(int itemId, int rating) {
        Item item = itemMap.get(itemId);
        if (item != null) {
            item.addRating(rating);
        }
    }

    public void restockItem(int itemId) {
        Item item = itemMap.get(itemId);
        if (item != null) {
            item.setInStock(true);
        }
    }

    public Item recommendItem() {
        if (dealOfTheDay != null && dealOfTheDay.isInStock()) {
            return dealOfTheDay;
        } else {
            return itemWithHighestAverageRating();
        }
    }

    private Item itemWithHighestAverageRating() {
        Item highestRatedItem = null;
        double highestAverageRating = 0.0;

        for (Item item : itemMap.values()) {
            if (item.isInStock() && item.getAverageRating() > highestAverageRating) {
                highestRatedItem = item;
                highestAverageRating = item.getAverageRating();
            }
        }

        return highestRatedItem;
    }

    // Inner class representing an item
    private static class Item {
        private boolean inStock;
        private int totalRating;
        private int ratingCount;

        Item() {
            this.inStock = true;
            this.totalRating = 0;
            this.ratingCount = 0;
        }

        boolean isInStock() {
            return inStock;
        }

        void setInStock(boolean inStock) {
            this.inStock = inStock;
        }

        double getAverageRating() {
            return (ratingCount == 0) ? 0.0 : ((double) totalRating / ratingCount);
        }

        void addRating(int rating) {
            totalRating += rating;
            ratingCount++;
        }
    }

    public static void main(String[] args) {
        // Example Usage
        Recommend recommendationSystem = new Recommend();

        // Adding items
        recommendationSystem.itemMap.put(1, new Item());
        recommendationSystem.itemMap.put(2, new Item());
        recommendationSystem.itemMap.put(3, new Item());

        // Making item with ID 1 the "Deal of the Day"
        recommendationSystem.makeDealOfTheDayItem(1);

        // Rating items
        recommendationSystem.rateItem(1, 4);
        recommendationSystem.rateItem(2, 5);
        recommendationSystem.rateItem(3, 3);

        // Simulating item 1 going out of stock
        recommendationSystem.outOfStock(1);

        // Recommending an item
        Item recommendedItem = recommendationSystem.recommendItem();
        System.out.println("Recommended Item ID: " + (recommendedItem != null ? "Item " : "None"));
    }
}
