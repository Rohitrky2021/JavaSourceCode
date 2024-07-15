public class onlin {
    import java.util.Arrays;
    import java.util.HashMap;
    public class FenwickInversion {
         public static int n=0;
         public static int FT[];
         
        public static void main(String[] args) {
            int a[] = {1,-9,5,4,3};  
            int p[]=a.clone();
            n=a.length;
            FT =new int[n+1]; 
            System.out.println("Input array :"+Arrays.toString(a));
            System.out.println("Number of Inversions in given input array :" +inversions(a,n));
            clearFT();  // clear Frnwick tree
            Arrays.sort(p);
            System.out.println("number of Inversions in sorted(ascending order) array :"+inversions(p,n));
            int desc[] = {5,4,3,1,-9}; 
            clearFT();  // clear Fenwick tree
            System.out.println("number of Inversions in sorted(descending order) array :"+inversions(desc,n));
          
        }
        public static int [] convert(int arr[]) //convert(map) an array in [1,..n] example [1,-3,5,4]  
        {                                       // will convert into [2,1,4,3].
            int tmp[]=arr.clone();
            Arrays.sort(tmp);   //sort an array in ascending order
            HashMap&ltInteger,Integer&gt map =new HashMap();
            int value=1;
            for(int j=0; j&lttmp.length; j++)
                map.put(tmp[j], value++);    // we map the array in [1,...n]
            for (int i =0; i&ltmap.size(); i++) 
                arr[i] = map.get(arr[i]);  //store the new value (mapped) value into array
            return arr;
            
        }
         public static void construct(int arr[])  // create a fenwick tree of given array
           {
            for(int i=0; i&lt=n; i++)  // intitalize all node with zero
            {
                FT[i]=0;    
            }
            // Store the values in FT[] using update()  
            for(int i=0; i&ltn; i++)
                update(i,arr[i]);  
           }
           public static void update(int i,int value)  // add value to element with index i
           {
               while(i&lt==n)
               { 
                   FT[i]+=value;
                   i=i+(i&(-i));
               }
           }
           
           public static int sum(int i)  //  returns the sum of input array[0,..i] 
           {
               int sum=0;
               while (i&gt0)
               {  
                   sum+=FT[i];
                   i=parentnode(i);	
               }    
               return sum;
                   
           }
           
           public static int parentnode(int i) // returns the parent node(index) of index i
           {
              int index = i-(i&(-i));
              return index;
           }
           public static int inversions(int arr[],int n) // returns the number of inversion in array
           {
               int inversion=0;
               convert(arr);
               for(int i=n-1; i&gt=0; i--)
               {
                   inversion+=sum(arr[i]-1);   //// count the elements smaller than arr[i] 
                   update(arr[i],1);          // add current element into FT[]
               }
               return inversion;
               
           }
           public static void clearFT()
           {
               FT=null;
               FT=new int[n+1];
           }
    
    }
    