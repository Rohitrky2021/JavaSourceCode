import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class C {

    static double epsilon = 1e-9;  // Adjust the epsilon based on your precision requirements

    static boolean isMidpoint(Point q, Point p, Point r) {
        double midX = (p.x + r.x) / 2.0d;
        double midY = (p.y + r.y) / 2.0;
        return Math.abs(midX - q.x) < epsilon && Math.abs(midY - q.y) < epsilon;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        Point[] points = new Point[n];

        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points[i] = new Point(x, y);
        }

        int count = 0;
        Map<String, Integer> midpointOccurrences = new HashMap<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double midX = (points[i].x + points[j].x) / 2.0;
                double midY = (points[i].y + points[j].y) / 2.0;
                String key = midX + "," + midY;

                int occurrences = midpointOccurrences.getOrDefault(key, 0);
                count += occurrences;
                midpointOccurrences.put(key, occurrences + 1);
            }
        }

        System.out.println(count);
    }
}

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
