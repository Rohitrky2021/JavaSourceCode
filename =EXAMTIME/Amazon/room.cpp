#include <iostream>
#include <vector>
#include <unordered_map>
#include <algorithm>

using namespace std;

int numIdleDrives(vector<int>& x, vector<int>& y) {
    int n = x.size();

    unordered_map<int, vector<int>> xMap, yMap;
    for (int i = 0; i < n; ++i) {
        xMap[y[i]].push_back(x[i]);
        yMap[x[i]].push_back(y[i]);
    }

    for (auto& pair : xMap) {
        sort(pair.second.begin(), pair.second.end());
    }

    for (auto& pair : yMap) {
        sort(pair.second.begin(), pair.second.end());
    }

    int count = 0;

    for (int i = 0; i < n; ++i) {
        int currX = x[i], currY = y[i];

        auto& yVec = xMap[currY];
        auto it1 = upper_bound(yVec.begin(), yVec.end(), currX);
        auto it2 = lower_bound(yVec.begin(), yVec.end(), currX);

        bool above = (it1 != yVec.end());
        bool below = (it2 != yVec.begin());

        auto& xVec = yMap[currX];
        it1 = upper_bound(xVec.begin(), xVec.end(), currY);
        it2 = lower_bound(xVec.begin(), xVec.end(), currY);

        bool left = (it1 != xVec.end());
        bool right = (it2 != xVec.begin());

        if (above && below && left && right) {
            count++;
        }
    }

    return count;
}
