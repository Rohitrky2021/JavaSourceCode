import java.util.Scanner;

// some ninjas are in training of n days where they have to trains in 3 practices
// if at day1 he practice first skill then on next day he cannot practice same skill
// so non adjacent type
// so we have given a points array which is 2d row represents days of training and column
// are 3 bcoz we have three skills training with their marks
// we have to find in n days a ninja can take training so he can earn max points
public class Q7_Ninjas_training {
    public static int helper(int day, int last, int[][] points){
        // base case when day is 0 that means we are at last day and in last we have idx which
        // we used in previous day so don't use that index
        if(day == 0){
            int maxi = 0;
            for(int i = 0; i < 3; i++){
                // if we perform ith task on this day then compare max and return and make sure we
                // are not using last task
                if(i != last) maxi = Math.max(maxi, points[day][i]); 
            }
            return maxi;
        }

        // in rest day we have same options but here we can perform todays task and pass ith index
        // so in next day that ith task will not perform
        int maxi = 0;

        for(int i = 0; i < 3; i++){
            if(i != last){
                int point = points[day][i] + helper(day - 1, i, points);
                maxi = Math.max(maxi, point);  
            }
        }

        return maxi;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // days 
        int[][] points = new int[n][3];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 3; j++){
                points[i][j] = scn.nextInt();
            }
        }
        scn.close();
        // so we start at n-1 days and first time we have 3 options available but we are using 0 based 
        // indexing so index will be 0 to 2 but we give 3 that means we have all options from 0 to 2 
        // are available
        // System.out.println(helper(n-1, 3, points));

        // now we can solve this using memoization
        // but in recursion we are using two variables daya and last so we have to create 2D array
        // row size will be n and col size will be 4, 4 bcoz we have 3 skills from 0 to 2 and we have option
        // 3 that means we haven't use any task 
        // int[][] dp = new int[n][4];
        // for(int i = 0; i < n; i++){
        //     Arrays.fill(dp[i], -1);
        // }
        // System.out.println(helper2(n-1, 3, points, dp));

        // now tabulation method
        // so create a dp of size n*4
        // in base case of memoization we use n == 0 we put max of all tasks without using the
        // last task, doing same here
        // and in dp[0][3] put max of all taks
        // now start loop for day start from 1
        // inside in start loop for last from 0 to 4
        // now intialize dp[day]][last] as 0 and craete a loop for task from 0 to 3
        // if the task is not used at last then use the current task point and call for prev day by telling
        // i'm using that task
        // int[][] dp = new int[n][4];
        // dp[0][0] = Math.max(points[0][1], points[0][2]);
        // dp[0][1] = Math.max(points[0][0], points[0][2]);
        // dp[0][2] = Math.max(points[0][0], points[0][1]);
        // dp[0][3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        // for(int day = 1; day < n; day++){
        //     for(int last = 0; last < 4; last++){
        //         dp[day][last] = 0;
        //         for(int task = 0; task < 3; task++){
        //             if(task != last){
        //                 int point = points[day][task] + dp[day - 1][task]; 
        //                 dp[day][last] = Math.max(dp[day][last], point);
        //             }
        //         }
        //     }
        // }

        // System.out.println(dp[n-1][3]);

        // now we can optimized the space
        // as we are able to see to calculate dp[day][task] we want dp[day-1][task]
        // only want prev row so we can use a 1D array instead of 2D
        int[] dp = new int[4];
        dp[0] = Math.max(points[0][1], points[0][2]);
        dp[1] = Math.max(points[0][0], points[0][2]);
        dp[2] = Math.max(points[0][0], points[0][1]);
        dp[3] = Math.max(points[0][0], Math.max(points[0][1], points[0][2]));

        for(int day = 1; day < n; day++){
            int[] temp = new int[4];
            for(int last = 0; last < 4; last++){
                temp[last] = 0;
                for(int task = 0; task < 3; task++){
                    if(task != last){
                        temp[last] = Math.max(temp[last], points[day][task] + dp[task]);
                    }
                }
            }
            dp = temp;
        }
        System.out.println(dp[3]);
    }

    public static int helper2(int day, int last, int[][] points, int[][] dp){
        // base case when day is 0 that means we are at last day and in last we have idx which
        // we used in previous day so don't use that index
        if(day == 0){
            int maxi = 0;
            for(int i = 0; i < 3; i++){
                // if we perform ith task on this day then compare max and return and make sure we
                // are not using last task
                if(i != last) maxi = Math.max(maxi, points[day][i]); 
            }
            return maxi;
        }

        if(dp[day][last] != -1) return dp[day][last];

        // in rest day we have same options but here we can perform todays task and pass ith index
        // so in next day that ith task will not perform
        int maxi = 0;

        for(int i = 0; i < 3; i++){
            if(i != last){
                int point = points[day][i] + helper2(day - 1, i, points, dp);
                maxi = Math.max(maxi, point);  
            }
        }

        return dp[day][last] = maxi;
    }
}
