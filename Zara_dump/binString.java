import java.util.*;
import java.io.*;


public class binString {

  public static long kmin(int arr[],int n,int k)
    {
      int start = 0, end = 0, sum = arr[0], count = 0;
      while(start<n && end<n)
      {
        if(sum<(end-start)/2)
        {
          end++;
          if(end>=start)
            count += end-start;
          if(end<n)
            sum += arr[end];
        }
        else
        {
          sum -= arr[start];
          start++;
        }
      }
      return count;
}

  public static void main(String args[]) throws IOException {

    int t;
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();

        while(t>0){
            int n,k;
            n=sc.nextInt();
            k=sc.nextInt();
            int arr[]=new int[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextInt();
            }
            long res = (n*(n+1))/2;
            long p=kmin(arr,n,k);
            System.out.println(res-p);
            t--;
      }
  }
}