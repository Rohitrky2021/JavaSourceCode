import java.util.List;

public class HealthSum {
    public static void main(String[] args) {
        // Example usage:
        int initial = 12;
        List<Integer> deltas = List.of(-4,-12,6,2);

        int result = solve(initial, deltas);
        System.out.println(result);
    }

    static int solve(int initial, List<Integer> deltas) {
        int health = initial;
        for (int d : deltas) {
            health += d;
            if (health < 0) {
                health = 0;
            } else if (health > 100) {
                health = 100;
            }
        }
        return health;
    }
}
