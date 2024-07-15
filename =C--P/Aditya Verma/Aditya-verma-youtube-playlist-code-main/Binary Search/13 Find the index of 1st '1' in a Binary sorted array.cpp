class Solution{
  public:
  int firstIndex(int a[], int n)
  {
    int start =0;
    int end= n-1;
    while (start<=end){
      int mid = start+(end-start)/2;
      if (a[mid]==1)
      {
        if (a[mid-1]==1) // when the previous is also 1 then check in the right side 
        {
          end=mid-1;
        }
        else 
          return mid;
      }
      else 
        if (a[mid]==0)
        {
          start=mid+1;
        }
    } // close of while loop 
    return -1;
  }
};



class BinaryInfinetArray{
    public int fun(int arry[],int key,int start,int end) {
        int result=-1;
        while ( key>arry[end]) {
            if (arry[end] < key) {
                start = end;
                end = end * 2;
            }
        }
        while (start<=end) {
            int mid = start + (end - start) / 2;
            if (arry[mid] == key) {
                result = mid;
                end = mid - 1;
            } else if (arry[mid] > key) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }
}