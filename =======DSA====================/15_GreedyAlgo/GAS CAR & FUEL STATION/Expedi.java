
// https://www.spoj.com/problems/EXPEDI/

import java.util.*;

public class Expedi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();

        while (t-- > 0) {
            int flag = 0, ans = 0;
            List<Pair<Integer, Integer>> v = new ArrayList<>();
            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                int d = scanner.nextInt();
                int f = scanner.nextInt();
                // Insert the city index and fuel capacity
                v.add(new Pair<>(d, f));
            }

            // Sort the cities according to their location
            Collections.sort(v, (l, r) -> Integer.compare(r.getKey(), l.getKey()));

            int D = scanner.nextInt();
            int F = scanner.nextInt();

            // Updating Distance of Fuel station from the Truck
            for (int i = 0; i < n; i++) {

                v.set(i, new Pair(D - v.get(i).getKey(), v.get(i).getValue()));

            }
            // M2 or if u want to add the updated one in new Array

            // Create a new list with updated distances from the truck

            // List<Pair<Integer, Integer>> updatedDistances = new ArrayList<>();
            
            // for (int i = 0; i < n; i++) {
            //     int distanceToDestination = D - v.get(i).getKey();
            //     int fuelCapacity = v.get(i).getValue();
            //     updatedDistances.add(new Pair<>(distanceToDestination, fuelCapacity));
            // }

            int prev = 0;
            int x = 0;

            while (x < n) {
                if (F >= (v.get(x).getKey() - prev)) {
                    F -= (v.get(x).getKey() - prev);
                    pq.add(v.get(x).getValue());
                    prev = v.get(x).getKey();
                } else {
                    if (pq.isEmpty()) {
                        flag = 1;
                        break;
                    }

                    F += pq.poll();
                    ans++;
                    continue;
                }
                x++;
            }

            if (flag == 1) {
                System.out.println("-1");
                continue;
            }

            D = D - v.get(n - 1).getKey();
            if (F >= D) {
                System.out.println(ans);
                continue;
            }

            while (F < D) {
                if (pq.isEmpty()) {
                    flag = 1;
                    break;
                }

                F += pq.poll();
                ans++;
            }

            if (flag == 1) {
                System.out.println("-1");
                continue;
            }

            System.out.println(ans);
        }
    }
}

class Pair<K, V> {
    private final K key;
    private final V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
