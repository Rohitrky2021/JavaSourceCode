public class code {
    
}
Trade Desk All Solutions Available ✅✅

// https://t.me/oahelpchannels/183

int n = nums1.size();
    vector<int> result;

    for (int t = 0; t < n; ++t) {
        vector<int> numsShifted(n);
        for (int i = 0; i < n; ++i) {
            numsShifted[i] = nums1[(i + t) % n];
        }

        int sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += abs(numsShifted[i] - nums2[i]);
        }

        result.push_back(sum);
    }

    sort(result.begin(), result.end());
    return result;