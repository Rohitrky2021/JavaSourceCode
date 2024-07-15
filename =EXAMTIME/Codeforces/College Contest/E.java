import java.io.*;
import java.util.*;

public class E {
    static int[] cost;
    static ArrayList<ArrayList<Integer>> friends;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        cost = new int[n];
        friends = new ArrayList<>(n);
        visited = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            friends.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            friends.get(x).add(y);
            friends.get(y).add(x);
        }

        long minCost = findMinimumCost(n);
        System.out.println(minCost);
    }

    static long findMinimumCost(int n) {
        long minCost = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                long minFriendCost = cost[i];
                Stack<Integer> stack = new Stack<>();
                stack.push(i);

                while (!stack.isEmpty()) {
                    int student = stack.pop();
                    visited[student] = true;

                    for (int friend : friends.get(student)) {
                        if (!visited[friend]) {
                            stack.push(friend);
                            minFriendCost = Math.min(minFriendCost, cost[friend]);
                        }
                    }
                }

                minCost += minFriendCost;
            }
        }

        return minCost;
    }
}
