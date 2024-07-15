import java.util.Scanner;
public class D {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int t = scanner.nextInt(); // Number of test cases
    
            for (int i = 0; i < t; i++) {
                int n = scanner.nextInt(); // Number of enemies
                int h = scanner.nextInt(); // Chef's initial strength
                int[] enemies = new int[n]; // Array to store enemy strengths
    
                for (int j = 0; j < n; j++) {
                    enemies[j] = scanner.nextInt();
                }
    
                int minResistance = findMinimumResistance(enemies, h);
                System.out.println(minResistance);
            }
    
            scanner.close();
        }
    
        public static int findMinimumResistance(int[] enemies, int initialStrength) {
            int left = 0;
            int right = initialStrength;
    
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (canDefeatAllEnemies(enemies, initialStrength, mid)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
    
            return left;
        }
    
        public static boolean canDefeatAllEnemies(int[] enemies, int initialStrength, int resistance) {
            int remainingStrength = initialStrength;
            for (int enemyStrength : enemies) {
                if (enemyStrength <= resistance) {
                    // Chef wins without losing any strength
                    continue;
                } else {
                    // Enemy's strength exceeds Chef's resistance
                    remainingStrength -= (enemyStrength - resistance);
                    if (remainingStrength < 0) {
                        return false; // Chef loses the battle
                    }
                }
            }
            return true; // Chef defeats all enemies
        }
    }
    