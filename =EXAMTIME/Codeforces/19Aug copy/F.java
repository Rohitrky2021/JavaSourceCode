import java.util.*;
import java.io.*;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);
        int t = Integer.parseInt(reader.readLine());

        for (int caseIdx = 0; caseIdx < t; caseIdx++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            long h = Long.parseLong(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int[] damage = new int[n];
            int[] cooldown = new int[n];

            st = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                damage[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(reader.readLine());
            for (int i = 0; i < n; i++) {
                cooldown[i] = Integer.parseInt(st.nextToken());
            }
            int max=Arrays.stream(damage).max().orElse(0);
            if(max>=h) {
                writer.println("1");
                continue;
            }

            long left = 1;
            long right = Long.MAX_VALUE;
            long result = right;
            while (left <= right) {
                long mid = left + (right - left) / 2;
                if (canDefeatBoss(mid, h, damage, cooldown)) {
                    result = mid;
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            writer.println(result);
        }
        writer.flush();
    }

    private static boolean canDefeatBoss(long turns, long h, int[] damage, int[] cooldown) {
        long totalDamage = 0;
        for (int i = 0; i < damage.length; i++) {
            long attackTurns = (turns - 1) / cooldown[i] + 1;
            totalDamage += attackTurns * damage[i];
            if (totalDamage >= h) {
                return true;
            }
        }
        return totalDamage >= h;
    }
}
