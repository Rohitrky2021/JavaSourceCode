 // Java program to find modified array 
// after m range toggle operations. 
class _11_Toggle_in_range_M 
{ 

// function for toggle 
static void command(boolean arr[], 
                    int a, int b) 
{ 
    arr[a] ^= true; 
    arr[b + 1] ^= true; 
} 

// function for final processing of array 
static void process(boolean arr[], int n) 
{ 
    for (int k = 1; k <= n; k++) 
    { 
        arr[k] ^= arr[k - 1]; 
    } 
} 

// function for printing result 
static void result(boolean arr[], int n) 
{ 
    for (int k = 1; k <= n; k++) 
    { 
        if(arr[k] == true) 
            System.out.print("1" + " "); 
        else
            System.out.print("0" + " "); 
    } 
} 

// Driver Code 
public static void main(String args[]) 
{ 
    int n = 5, m = 3; 
    boolean arr[] = new boolean[n + 2]; 

    // function call for toggle 
    command(arr, 1, 5); 
    command(arr, 2, 5); 
    command(arr, 3, 5); 

    // process array 
    process(arr, n); 

    // print result 
    result(arr, n); 
} 
} 

// This code is contributed 
// by PrinciRaj1992 
