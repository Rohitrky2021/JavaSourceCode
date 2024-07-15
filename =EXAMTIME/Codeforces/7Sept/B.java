import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            List<Trap> traps = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] trapInfo = br.readLine().split(" ");
                int d = Integer.parseInt(trapInfo[0]);
                int s = Integer.parseInt(trapInfo[1]);
                traps.add(new Trap(d, s));
            }

            int maxK = solve(n, traps);
            System.out.println(maxK);
        }
    }

    static class Trap {
        int d;
        int s;

        public Trap(int d, int s) {
            this.d = d;
            this.s = s;
        }
    }

    public static int solve(int n, List<Trap> traps) {
        int ans=Integer.MAX_VALUE;
        Collections.sort(traps, (a, b) -> Integer.compare(a.d, b.d));
        int maxK = traps.get(0).d - 1;

        for (int i = 0; i < n; i++) {
            if(traps.get(i).s%2==0){
                int res=(traps.get(i).s-2)/2;
                ans=Math.min(ans, res+traps.get(i).d);
                
            }else{
                int res1=traps.get(i).s/2;
                ans=Math.min(ans, res1+traps.get(i).d);

            }
            // int waitingTime = traps.get(i).d - traps.get(i - 1).d;
            // maxK = Math.min(maxK + waitingTime, traps.get(i).d - traps.get(i).s);
        }

        return ans;
    }
}
