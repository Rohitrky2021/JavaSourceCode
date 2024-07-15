import java.util.*;
public class c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();

        while(tc>0){
            int n = sc.nextInt(), m = sc.nextInt();
            TreeSet<Integer> set = new TreeSet<>();
            char[] s = sc.next().toCharArray();

            for(int i=0;i<m;i++) set.add(sc.nextInt());
            char[] c = sc.next().toCharArray();
            Arrays.sort(c);
            int j = 0;

            while(!set.isEmpty()){
                s[set.pollFirst()-1] = c[j++];
            }


            System.out.println(String.valueOf(s));
            tc--;
        }
    }
}
