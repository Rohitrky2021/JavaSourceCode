 

import java.util.*;

public class Roomba_Shape_Robo {
    public static int numIdleDrives(List<Integer> x, List<Integer> y) {
        int n = x.size();

        Map<Integer, List<Integer>> xMap = new HashMap<>();
        Map<Integer, List<Integer>> yMap = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            xMap.computeIfAbsent(y.get(i), k -> new ArrayList<>()).add(x.get(i));
            yMap.computeIfAbsent(x.get(i), k -> new ArrayList<>()).add(y.get(i));
        }

        for (List<Integer> values : xMap.values()) {
            Collections.sort(values);
        }

        for (List<Integer> values : yMap.values()) {
            Collections.sort(values);
        }

        int count = 0;

        for (int i = 0; i < n; ++i) {
            int currX = x.get(i);
            int currY = y.get(i);

            List<Integer> yVec = xMap.get(currY);
            int index1 = Collections.binarySearch(yVec, currX);
            int index2 = index1 < 0 ? -(index1 + 1) : index1;

            boolean above = index2 < yVec.size();
            boolean below = index2 > 0;

            List<Integer> xVec = yMap.get(currX);
            index1 = Collections.binarySearch(xVec, currY);
            index2 = index1 < 0 ? -(index1 + 1) : index1;

            boolean left = index2 < xVec.size();
            boolean right = index2 > 0;

            if (above && below && left && right) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        // Test the method with sample input
        List<Integer> x = Arrays.asList(0,0,0,0,0,1,1,1,2,-1,-1,-2,-1);
        List<Integer> y = Arrays.asList(-1,0,1,2,-2,0,1,-1,0,-1,0,0);
        System.out.println(numIdleDrives(x, y)); // Output will depend on the input lists x and y
    }
}


// #include <iostream>
// #include <vector>
// #include <unordered_map>
// #include <algorithm>

// using namespace std;

// int numIdleDrives(vector<int>& x, vector<int>& y) {
//     int n = x.size();

//     unordered_map<int, vector<int>> xMap, yMap;
//     for (int i = 0; i < n; ++i) {
//         xMap[y[i]].push_back(x[i]);
//         yMap[x[i]].push_back(y[i]);
//     }

//     for (auto& pair : xMap) {
//         sort(pair.second.begin(), pair.second.end());
//     }

//     for (auto& pair : yMap) {
//         sort(pair.second.begin(), pair.second.end());
//     }

//     int count = 0;

//     for (int i = 0; i < n; ++i) {
//         int currX = x[i], currY = y[i];

//         auto& yVec = xMap[currY];
//         auto it1 = upper_bound(yVec.begin(), yVec.end(), currX);
//         auto it2 = lower_bound(yVec.begin(), yVec.end(), currX);

//         bool above = (it1 != yVec.end());
//         bool below = (it2 != yVec.begin());

//         auto& xVec = yMap[currX];
//         it1 = upper_bound(xVec.begin(), xVec.end(), currY);
//         it2 = lower_bound(xVec.begin(), xVec.end(), currY);

//         bool left = (it1 != xVec.end());
//         bool right = (it2 != xVec.begin());

//         if (above && below && left && right) {
//             count++;
//         }
//     }

//     return count;
// }

// Amazon ✅