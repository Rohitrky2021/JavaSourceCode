public class code {
    
}
string solve(vector<string>& l) {
    unordered_map<string, set<string>> b;
    string c = "";
    for (string s : l) {
        stringstream ss(s);
        string d, n;
        ss >> d >> n;
        if (d == "switch") {
            c = n;
        } else if (d == "push") {
            b[c].insert(n);
        }
    }
    string m = "";
    int f = 0;
    for (auto i : b) {
        if (i.second.size() > f) {
            f = i.second.size();
            m = i.first;
        }
    }
    return m;
}

// Autodesk ✅
// https://t.me/skill_sailor_discussion/21994

// https://t.me/leetcodegfgdailysolution/33246