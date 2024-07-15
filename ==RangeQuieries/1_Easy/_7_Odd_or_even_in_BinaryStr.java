 
// java program to find if a subarray 
// is even or odd. 
import java.io.*; 

class oddorevenINBinarystr 
{ 
    // prints if subarray is even or odd 
    static void checkEVENodd (int arr[], int n, int l, int r) 
    { 
        // if arr[r] = 1 print odd 
        if (arr[r] == 1) 
            System.out.println( "odd") ; 
    
        // if arr[r] = 0 print even 
        else
            System.out.println ( "even") ; 
    } 

    // driver code 
    public static void main (String[] args) 
    { 
        int arr[] = {1, 1, 0, 1}; 
        int n = arr.length; 
        checkEVENodd (arr, n, 1, 3); 
        
        
    } 
} 

// This article is contributed by vt_m. 
