#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int t;
    cin >> t;  // Input number of test cases

    while (t--) {
        int n, c;
        cin >> n >> c;  // Input number of elements and the budget

        vector<int> imp(n);
        for (auto &x : imp)
            cin >> x;  // Input the importance values into the vector

        int cnt = n;  // Initialize cnt with the total number of elements
        sort(imp.begin(), imp.end());  // Sort the vector of importance values

        for (int i = 0; i < n && c; ++i) {
            int sum = 0;
            for (int j = i + 1; j < n; ++j) {
                sum = sum + imp[i] * imp[j];  // Calculate the product sum
            }
            
            if (sum <= c) {
                cnt--;  // If sum is within budget, decrement count of elements
                c -= sum;  // Reduce the budget by the sum of products
            } else {
                break;  // If sum exceeds budget, stop further calculations
            }
        }

        cout << cnt << endl;  // Output the count of elements within budget
    }

    return 0;
}
