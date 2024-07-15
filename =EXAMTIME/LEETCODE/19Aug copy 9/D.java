import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int l = scanner.nextInt();
        int wmax = scanner.nextInt();
        
        Cloud[] clouds = new Cloud[n];
        for (int i = 0; i < n; i++) {
            int x = scanner.nextInt();
            int v = scanner.nextInt();
            clouds[i] = new Cloud(x, v);
        }
        
        // Sort clouds based on their initial positions
        Arrays.sort(clouds, Comparator.comparingInt(c -> c.x));
        
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(clouds[i].x - clouds[j].x) < l) {
                    continue;
                }
                
                if (canOverlap(clouds[i], clouds[j], wmax)) {
                    count++;
                }
            }
        }
        
        System.out.println(count);
    }
    
    static boolean canOverlap(Cloud a, Cloud b, int wmax) {
        double wLow = -wmax;
        double wHigh = wmax;
        while (wHigh - wLow > 1e-9) {
            double wMid = (wLow + wHigh) / 2;
            double ta = -a.x / (a.v + wMid);
            double tb = -b.x / (b.v + wMid);
            if (Math.abs(ta - tb) < 1e-9) {
                return true;
            }
            if (ta < tb) {
                wLow = wMid;
            } else {
                wHigh = wMid;
            }
        }
        return false;
    }
    
    static class Cloud {
        int x;
        int v;
        
        Cloud(int x, int v) {
            this.x = x;
            this.v = v;
        }
    }
}
