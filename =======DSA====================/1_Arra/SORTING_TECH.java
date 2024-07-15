// package Arra;
import java.util.Arrays;
import java.lang.reflect.Array;
import java.util.*;
import java.util.Collections;
public class SORTING_TECH {
    public static void print(int marks[]){
        for(int i=0;i<marks.length;i++){
            System.out.print(marks[i]+" ");
        }
        System.out.println();
    }
    public static void main(String args[]){
        // int marks[]=new int [100];
        int marks[]={10,20,70,40,50};
        print(marks);
           // buuble_sort();
           insertion_sort(marks);
           print(marks);
           buble_sort(marks);
        print(marks);
        Arrays.sort(marks);
        print(marks);
       System.out.println(Arrays.binarySearch(marks, 50));
    //    Array.getShort(marks, 3);
       // Arrays.sort(marks,0,3,Collections.reverseOrder());//work on object class only that is Integer
        Arrays.sort(marks);
       




    }
    public static void buble_sort(int marks[]){
        int temp=0;
        for(int turn=0;turn<marks.length-1;turn++){
            for(int j=0;j<marks.length-1-turn;j++){
                int flag=0;
                //   Collection.swap(marks[j],marks[j+1]);
               if(marks[j]<marks[j+1]){
                temp=marks[j];
                marks[j]=marks[j+1];
                 marks[j+1]=temp;
                flag=1;} 
            if(flag==0){
                break; }      }
               }   // System.out.println();
    }
    public static void selection_sort(int marks[]){
        for(int i=0;i<marks.length-1;i++){
            int j,temp;
            int min=i;
            for(j=i+1;j<marks.length;j++){
                if(marks[min]>marks[j]){
                    min=j;
                }
            }
            temp=marks[i];
            marks[i]=marks[min];
             marks[min]=temp;
        }
    }
    public static void insertion_sort(int marks[]){
        for(int i=1;i<marks.length;i++){
            int curr=marks[i];
            int prev=i-1;
            while(prev>0 && marks[prev]>curr){
                marks[prev+1]=marks[prev];
                prev--;
            }
             marks[prev+1]=curr;
            }
    } 

	public static void QuickSort(int marks[]) {
	
}

}

// merge SORT---------------------------------


/* Java program for Merge Sort */
class MergeSort
{
	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	void merge(int arr[], int l, int m, int r)
	{
		// Find sizes of two subarrays to be merged
		int n1 = m - l + 1;
		int n2 = r - m;

		/* Create temp arrays */
		int L[] = new int [n1];
		int R[] = new int [n2];

		/*Copy data to temp arrays*/
		for (int i=0; i<n1; ++i)
			L[i] = arr[l + i];
		for (int j=0; j<n2; ++j)
			R[j] = arr[m + 1+ j];


		/* Merge the temp arrays */

		// Initial indexes of first and second subarrays
		int i = 0, j = 0;

		// Initial index of merged subarray array
		int k = l;
		while (i < n1 && j < n2)
		{
			if (L[i] <= R[j])
			{
				arr[k] = L[i];
				i++;
			}
			else
			{
				arr[k] = R[j];
				j++;
			}
			k++;
		}

		/* Copy remaining elements of L[] if any */
		while (i < n1)
		{
			arr[k] = L[i];
			i++;
			k++;
		}

		/* Copy remaining elements of R[] if any */
		while (j < n2)
		{
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	// Main function that sorts arr[l..r] using
	// merge()
	void sort(int arr[], int l, int r)
	{
		if (l < r)
		{
			// Find the middle point
			int m = (l+r)/2;

			// Sort first and second halves
			sort(arr, l, m);
			sort(arr , m+1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	/* A utility function to print array of size n */
	static void printArray(int arr[])
	{
		int n = arr.length;
		for (int i=0; i<n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

	// Driver method
	public static void main(String args[])
	{
		int arr[] = {12, 11, 13, 5, 6, 7};

		System.out.println("Given Array");
		printArray(arr);

		MergeSort ob = new MergeSort();
		ob.sort(arr, 0, arr.length-1);

		System.out.println("\nSorted array");
		printArray(arr);
	}
}
/* This code is contributed by Rajat Mishra */





























































































































































































































































































