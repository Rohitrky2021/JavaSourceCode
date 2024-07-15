int minDiffElement(vector<int>& arr,int key){
    int n=arr.size();

    int left=0,right=n-1;
    int minDiff=INT_MAX;
    int ans;

    while(left<=right){

        int mid=left+(right-left)/2;

        int diff=abs(arr[mid]-key);

        if(diff<minDiff){
            minDiff=diff;
            ans=arr[mid];
        }

        if(arr[mid]==key){
            return key;
        }

        else if(arr[mid]<key){
            left=mid+1;
        }

        else{
            right=mid-1;
        }
    }
    return ans;
}