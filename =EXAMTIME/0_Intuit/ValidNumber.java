// https://leetcode.com/discuss/interview-question/880798/Intuit-or-OA

public class ValidNumber {

}

// Solution using x as the radix of the number in O(n * Log(x))
public class KValidNumber {

    public static void main(String... args) {
        try (Scanner sc = new Scanner(System.in)) {
            String[] temp = sc.nextLine().split("\\s");
            int n = Integer.parseInt(temp[0]), x = Integer.parseInt(temp[1]), k = Integer.parseInt(temp[2]);
            char[] str = sc.nextLine().toCharArray();
            for (int i = 0; i < n; i += x)
                Arrays.sort(str, i, Math.min(n, i + x));
            StringBuilder sb = new StringBuilder();
            int i = 1;
            while (k > 0) {
                int r = k % x;
                k /= x;
                sb.append(str[n - (i * x) + r]);
                i++;
            }
            System.out.println(sb.reverse().toString());
        } catch (Exception ex) {
            System.out.println("Runtime Error");
            ex.printStackTrace();
            throw ex;
        }
    }

}