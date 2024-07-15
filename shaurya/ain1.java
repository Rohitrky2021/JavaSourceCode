import java.util.*;
import java.io.*;


public class ain1 {
  public static void main(String[] args) throws IOException{
    Scanner scan = new Scanner(System.in);
    int t = scan.nextInt();
    scan.nextLine();
    while(t-->0){
      int n = scan.nextInt();
      int k = scan.nextInt();
      scan.nextLine();
      int [] arr = Arrays.stream(scan.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
      int ones = 0;
      for(int i = 0; i < arr.length; i++){
        if(arr[i] == 1){
          ones++;
        }
      }
      if(ones == 0){
        System.out.println("NO");
      }
      else{
        System.out.println("YES");
      }
    }
    scan.close();
  }
}

