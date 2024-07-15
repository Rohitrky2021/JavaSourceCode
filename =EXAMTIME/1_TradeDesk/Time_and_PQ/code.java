public class code {
    
}
int solve(vector<int>& t) {
    priority_queue<int, vector<int>, greater<int>> a(t.begin(), t.end());
    queue<int> w;
    int time = 0;

    while (!a.empty() || !w.empty()) {
        if (!w.empty()) {
            time = max(time, w.front()) + 5 * 60;
            w.pop();
        } else {
            time = a.top();
        }

        while (!a.empty() && a.top() <= time) {
            if (w.size() < 10) {
                w.push(a.top());
            }
            a.pop();
        }
    }

    return time;
}


Trade Desk Solution ✅✅
// https://t.me/oahelpchannels/202
// https://t.me/skill_sailor_discussion/22044
// https://t.me/skill_sailor_discussion/22045