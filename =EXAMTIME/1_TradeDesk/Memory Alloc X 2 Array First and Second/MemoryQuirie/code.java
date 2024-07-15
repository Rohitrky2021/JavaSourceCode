public class code {
    
}
vector<int> solve(vector<int>& mem, vector<vector<int>>& queries) {
    map<int, pair<int, int>> alloc; 
    int id = 1;
    vector<int> res;
    for (auto& q : queries) {
        if (q[0] == 0) { 
            int x = q[1];
            int start = -1;
            int count = 0;
            for (int i = 0; i < mem.size(); ++i) {
                if (mem[i] == 0) {
                    if (start == -1 && i % 8 == 0) {
                        start = i;
                    }
                    if (start != -1) {
                        ++count;
                    }
                    if (count == x) {
                        break;
                    }
                } else {
                    start = -1;
                    count = 0;
                }
            }
            if (count == x) {
                fill(mem.begin() + start, mem.begin() + start + x, 1);
                alloc[start] = {id, x};
                res.push_back(start);
                ++id;
            } else {
                res.push_back(-1);
            }
        } else { 
            int eraseId = q[1];
            int length = -1;
            for(auto it = alloc.begin(); it != alloc.end(); ++it) {
                if(it->second.first == eraseId) {
                    fill(mem.begin() + it->first, mem.begin() + it->first + it->second.second, 0);
                    length = it->second.second;
                    alloc.erase(it);
                    break;
                }
            }
            res.push_back(length);
        }
    }
    return res;
}