
    import java.util.ArrayList;
    import java.util.List;
    
    class NewsFeedEntity {
        String id;
        String postTimeISO;
    
        NewsFeedEntity(String id, String postTimeISO) {
            this.id = id;
            this.postTimeISO = postTimeISO;
        }
    }
    
    public class NewsFeed {
        private List<NewsFeedEntity> newsFeedEntities;
    
        public NewsFeed() {
            newsFeedEntities = new ArrayList<>();
        }
    
        void storeFeedEntity(String id, String postTimeISO) {
            NewsFeedEntity entity = new NewsFeedEntity(id, postTimeISO);
            newsFeedEntities.add(entity);
        }
    
        NewsFeedEntity[] getLatestNewsFeedEntities(int k) {
            int size = newsFeedEntities.size();
            int startIndex = Math.max(0, size - k);
            int endIndex = size;
    
            return newsFeedEntities.subList(startIndex, endIndex).toArray(new NewsFeedEntity[0]);
        }
    
        NewsFeedEntity[] getLatestNewsFeedEntities(int k, String beforeTime) {
            List<NewsFeedEntity> filteredEntities = new ArrayList<>();
    
            for (NewsFeedEntity entity : newsFeedEntities) {
                if (entity.postTimeISO.compareTo(beforeTime) < 0) {
                    filteredEntities.add(entity);
                }
            }
    
            int size = filteredEntities.size();
            int startIndex = Math.max(0, size - k);
            int endIndex = size;
    
            return filteredEntities.subList(startIndex, endIndex).toArray(new NewsFeedEntity[0]);
        }
    
        public static void main(String[] args) {
            NewsFeed newsFeed = new NewsFeed();
    
            
            newsFeed.storeFeedEntity("user1", "2023-11-10T12:00:00Z");
            newsFeed.storeFeedEntity("user2", "2023-11-10T12:30:00Z");
            newsFeed.storeFeedEntity("user3", "2023-11-10T13:00:00Z");
    
            NewsFeedEntity[] latestEntities = newsFeed.getLatestNewsFeedEntities(2);
            for (NewsFeedEntity entity : latestEntities) {
                System.out.println("ID: " + entity.id + ", Post Time: " + entity.postTimeISO);
            }
        }
    }
    