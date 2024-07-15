package T05_Recursion;

public class TowerOfHunai {

    public static void towerOfHanoi(int n, char s, char h, char d) {
        if (n == 1) {
            System.out.println(" Move disk 1 from rod " + s + " to rod " + h);
            return;
        }
        towerOfHanoi(n - 1, s, d, h);
        System.out.println(" Move disk " + n + " from rod " + s + " to rod " + h);
        towerOfHanoi(n - 1, d, h, s);
    }

    // Driver method
    public static void main(String args[]) {
        int n = 3;
        towerOfHanoi(n, 'A', 'C', 'B');
    }
}


