
// Range Funcion 


#include <vector>
#include <iostream>


class NumArray {
public:
    NumArray(std::vector<int>& nums) {
        this->n = nums.size();
        this->nums = nums;
        this->st.resize(4 * n);
        build(0, 0, n - 1);
    }

    void update(int index, int val) {
        pointUpdate(0, 0, n - 1, index, val);
    }

    int sumRange(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

private:
    int n;
    std::vector<int> st;  
    std::vector<int> nums;

    void build(int index, int low, int high) {
        if (low == high) {
            st[index] = nums[low];
            return;
        }
        int mid = (low + high) / 2;
        build(2 * index + 1, low, mid);
        build(2 * index + 2, mid + 1, high);

        st[index] = st[2 * index + 1] + st[2 * index + 2];
    }

    int query(int index, int low, int high, int l, int r) {
        if (low >= l && high <= r) {
            return st[index];
        }
        if (low > r || high < l) {
            return 0;
        }
        int mid = low + (high - low) / 2;
        int left_result = query(2 * index + 1, low, mid, l, r);
        int right_result = query(2 * index + 2, mid + 1, high, l, r);
        return left_result + right_result;
    }

    void pointUpdate(int index, int low, int high, int node, int val) {
        if (low == high) {
            st[index] = val;
            nums[node] = val;
            return;
        }
        int mid = low + (high - low) / 2;
        if (node <= mid) {
            pointUpdate(2 * index + 1, low, mid, node, val);
        } else {
            pointUpdate(2 * index + 2, mid + 1, high, node, val);
        }
        st[index] = st[2 * index + 1] + st[2 * index + 2];
    }
};

std::vector<int> solve(int N, int Q, std::vector<int>& A, std::vector<std::vector<int>>& queries) {
    NumArray numArray(A);
    std::vector<int> result;

    for (const auto& query : queries) {
        int type = query[0];
        if (type == 1) {
            int index = query[1] - 1;
            int val = query[2];
            numArray.update(index, val);
        } else if (type == 2) {
            int L = query[1] - 1;
            int R = query[2] - 1;
            int sum = 0;
            for (int i = L; i <= R; i++) {
                for (int j = i; j <= R; j++) {
                    sum += numArray.sumRange(i, j);
                }
            }
            result.push_back(sum);
        }
    }

    return result;
}

int main() {
    int N = 5;
    int Q = 2;
    std::vector<int> A = {2, 1, 4, 3, 1};
    std::vector<std::vector<int>> queries = {{1, 2, 2}, {2, 1, 3}};

    std::vector<int> result = solve(N, Q, A, queries);
    for (int res : result) {
        std::cout << res << std::endl;
    }

    return 0;
}
