import java.util.*;

public class D {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        List<List<Integer>> photos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            List<Integer> photo = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                photo.add(scanner.nextInt());
            }
            photos.add(photo);
        }

        List<Integer> result = findOriginalOrder(N, photos);
        for (int id : result) {
            System.out.println(id);
        }
    }

    public static List<Integer> findOriginalOrder(int N, List<List<Integer>> photos) {
        Set<Integer> moved = new HashSet<>();
        Map<Integer, Integer> originalOrder = new HashMap<>();

        // Iterate through the photos
        for (List<Integer> photo : photos) {
            if (photo.get(0).equals(photo.get(1))) {
                // No kid moved in this photo
                for (int i = 0; i < N; i++) {
                    int id = photo.get(i);
                    originalOrder.put(id, i);
                }
            } else {
                // One kid moved in this photo
                int movedId = -1;
                int destinationIndex = -1;
                for (int i = 0; i < N; i++) {
                    int id = photo.get(i);
                    originalOrder.put(id, i);
                    if (!moved.contains(id)) {
                        movedId = id;
                    } else {
                        destinationIndex = i;
                    }
                }
                originalOrder.remove(movedId);
                moved.add(movedId);
                originalOrder.put(movedId, destinationIndex);
            }
        }

        List<Integer> result = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            result.add(-1);
        }

        for (Map.Entry<Integer, Integer> entry : originalOrder.entrySet()) {
            result.set(entry.getValue(), entry.getKey());
        }

        return result;
    }
}
