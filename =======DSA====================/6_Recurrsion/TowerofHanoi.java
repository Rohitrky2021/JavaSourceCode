public class TowerofHanoi {
    public static void TowerofHanoi(char S, char H, char D, int n) {
        if (n == 1) {
            System.out.println("Moving -> " + n + "from " + S + "to-->" + D);
            return;

        }
        TowerofHanoi(S, D, H, n - 1);
        System.out.println("Moving -> " + n + "from " + S + "to-->" + D);
        TowerofHanoi(H, S, D, n - 1);

    }

    public static void main(String[] args) {
        TowerofHanoi('S', 'H', 'D', 3);
    }
}
