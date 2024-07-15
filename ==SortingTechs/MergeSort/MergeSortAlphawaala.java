import java.util.*;

public class MergeSortAlphawaala {
    public static void main(String args[]){
        int arr[]={6,3,9,5,2,8};
        mergeShort(arr, 0, 5);
        // int tem[]={1,2,34,4};
        // arr=tem;
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void mergeShort(int arr[],int si,int ei){

        int mid=(si+ei)/2;
        if(si>=ei){
            return;
        }
        mergeShort(arr, si, mid);
        mergeShort(arr, mid+1, ei);
        merge(arr, si, mid, ei);
        // if(arr[])
    }
    public static void merge(int arr[],int si,int mid,int ei){
        int temp[]=new int[ei-si+1];
        int i=si;
        int j=mid+1;
        int k=0;

        while(i<=mid && j<=ei){
            if(arr[i]>=arr[j]){
                temp[k]=arr[j];
                j++;k++;
            }
            else{temp[k]=arr[i];
            k++;i++;}
        }
        //if in chance arr buch jaaye
        while(i<=mid){
            temp[k++]=arr[i++];
        }
        while(j<=ei){
            temp[k++]=arr[j++];
        }
        // arr=temp;
        // System.out.println();
        // for(int b=0;b<arr.length;b++){
        //     System.out.print(arr[b]+" ");
        // }
        for(k=0,i=si;k<temp.length;k++,i++){
            arr[i]=temp[k];
        }
    }
}
