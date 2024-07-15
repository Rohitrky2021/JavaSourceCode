public class C1 {
    
}
// https://t.me/codingsolns/99220
vector<string> solve(vector<vector<string>> p, vector<string> a, int w) {
    vector<string> r;
    r.push_back(string(w + 2, '*'));
    for(int i = 0; i < p.size(); i++) {
        string l = "";
        for(string wd : p[i]) {
            if(l.size() + wd.size() + (l.empty() ? 0 : 1) > w) {
                if(a[i] == "LEFT") {
                    l += string(w - l.size(), ' ');
                } else if(a[i] == "RIGHT") {
                    l = string(w - l.size(), ' ') + l;
                }
                r.push_back("*" + l + "*");
                l = "";
            }
            if(!l.empty()) {
                l += " ";
            }
            l += wd;
        }
        if(!l.empty()) {
            if(a[i] == "LEFT") {
                l += string(w - l.size(), ' ');
            } else if(a[i] == "RIGHT") {
                l = string(w - l.size(), ' ') + l;
            }
            r.push_back("*" + l + "*");
        }
    }
    r.push_back(string(w + 2, '*'));
    return r;
}

