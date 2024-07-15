
    import java.util.Scanner;

    public class J_sheep {
        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            int t = s.nextInt();
            while(t-- >0) {
                int n = s.nextInt();
                int hour = s.nextInt();
                int minute = s.nextInt();
                int[][] arr = new int[n][2];
                int time = hour*60 + minute;
                int min = 10000;
                for(int i=0;i<n;i++){
                    arr[i][0] = s.nextInt();
                    arr[i][1] = s.nextInt();

                    int temp = arr[i][0]*60 + arr[i][1];
                    if(temp < time){
                        temp += 1440;
                    }
                    min = Math.min(temp - time,min);
                }
                    System.out.println(min/60 + " " + min%60);

            }
        }
    }
