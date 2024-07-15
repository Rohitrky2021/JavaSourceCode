import java.util.Scanner;

public class E {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int t = scanner.nextInt();

        while (t > 0) {

            int h = scanner.nextInt();
            int w = scanner.nextInt();
            int x1 = scanner.nextInt();
            int y1 = scanner.nextInt();
            int x2 = scanner.nextInt();
            int y2 = scanner.nextInt();
            int turn = 0;

            if (x1 >= x2) {
                System.out.println("DRAW");
                t--;
                continue;
            }
            isSorted(new int[] { 1 });

            if ((x1 - x2) % 2 == 0) {
                turn = 1;
            }
            int a = (x2 - x1) / 2;
            int b = (x2 - x1) / 2;
            if ((x2 - x1) % 2 == 1) {
                a++;
            }
            int yval = 0;
            int xval = 0;

            if (turn != 0) {
                if (y2 >= y1) {
                    yval = Math.max(1, y2 - b);
                    xval = Math.max(1, y1 - a);
                    if (xval >= yval) {
                        System.out.println("Bob");
                        t--;
                        continue;
                    }

                } else {
                    yval = Math.min(w, y2 + b);
                    xval = Math.min(w, y1 + a);
                    if (xval <= yval) {
                        System.out.println("Bob");
                        t--;
                        continue;
                    }
                }

            } else {

                if (y2 >= y1) {
                    yval = Math.min(w, y2 + b);
                    xval = Math.min(w, y1 + a);

                    if (xval >= yval) {
                        System.out.println("Alice");
                        t--;
                        continue;
                    }
                } else {
                    yval = Math.max(1, y2 - b);
                    xval = Math.max(1, y1 - a);

                    if (xval <= yval) {
                        System.out.println("Alice");
                        t--;
                        continue;
                    }
                }
            }

            System.out.println("DRAW");

            t--;
        }

        scanner.close();
    }

    public static boolean isSorted(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

}
