#include <iostream>
#include <vector>

using namespace std;

void solveArithmeticMean(int n, vector<long>& sequence) {
    long sum = 0;
    for (int i = 0; i < n; i++) {
        sum += sequence[i];
    }

    vector<int> resultIndices;
    long target = (sum * (n - 1)) / n;

    for (int i = 0; i < n; i++) {
        if (sum - sequence[i] == target) {
            resultIndices.push_back(i + 1);
        }
    }

    cout << resultIndices.size() << endl;

    for (int index : resultIndices) {
        cout << index << " ";
    }
}

int main() {
    int n;
    cin >> n;

    vector<long> sequence(n);

    for (int i = 0; i < n; i++) {
        cin >> sequence[i];
    }

    solveArithmeticMean(n, sequence);

    return 0;
}
