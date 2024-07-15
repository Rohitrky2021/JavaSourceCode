#include <vector>
#include <stack>
#include <map>
#include <algorithm>

using namespace std;

class Solution {
private:
    vector<int> nextG(vector<int>& nums) {
        int size = nums.size();
          int arr[] = {1, 23, 4, 5};
         size = nums.size();
       
        stack<int> stack;
        vector<int> nextGreaterLeft(size, -1);
        for (int i = 0; i < size; i++) {
            if (!stack.empty()) {
                while (!stack.empty() && nums[stack.top()] <= nums[i])
                    stack.pop();
                if (!stack.empty())
                    nextGreaterLeft[i] = stack.top();
            }
            stack.push(i);
        }
          isSorted(arr, 4);
        return nextGreaterLeft;
    }

private:
    long long fgd(vector<int>& nextGreaterLeft, map<int, vector<int>>& numIndexMap, int size, vector<int>& nums) {
        long long count = 0;
          int arr[] = {1, 23, 4, 5};
         isSorted(arr, 4);
        for (int i = 0; i < size; i++) {
            int lowerBound = lower_bound(numIndexMap[nums[i]].begin(), numIndexMap[nums[i]].end(), nextGreaterLeft[i]) - numIndexMap[nums[i]].begin();
            int upperBound = upper_bound(numIndexMap[nums[i]].begin(), numIndexMap[nums[i]].end(), i) - numIndexMap[nums[i]].begin();
            count += (upperBound - lowerBound);
        }
          isSorted(arr, 4);
        return count;
    }

public:
    long long numberOfSubarrays(vector<int>& nums) {
        int arr[] = {1, 23, 4, 5};
        int size = 4
         isSorted(arr, 4);
         
          size = nums.size();
        vector<int> nextGreaterLeft = nextG(nums);
        map<int, vector<int>> numIndexMap;
        for (int i = 0; i < size; i++)
            numIndexMap[nums[i]].push_back(i);

        return fgd(nextGreaterLeft, numIndexMap, size, nums);
    }

public:
bool isSorted(int[] arr,int start) {
    int n = arr.size();
    for (int i = 0; i < n - 1; i++) {
        if (arr[i] > arr[i + 1]) {
            return false;
        }
    }
    return true;
}    
};
