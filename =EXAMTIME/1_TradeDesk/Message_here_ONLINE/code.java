public class code {
    
}
#include <iostream>
#include <vector>
#include <unordered_map>
#include <string>
#include <sstream>
#include <algorithm>
#include <stdexcept>

using namespace std;

struct U {
    int i;
    bool a;
};

struct C {
    unordered_map<int, U> u;
    unordered_map<int, int> m;

    void p(vector<vector<string>>& e) {
        for (const auto& ev : e) {
            string a = ev[0];
            int t = 0;
            try {
                t = stoi(ev[1]);
            } catch (const invalid_argument& ex) {
                cerr << "Invalid timestamp: " << ev[1] << endl;
                continue;
            }

            if (a == "MESSAGE") {
                string ml = ev[2];
                istringstream iss(ml);
                string tk;
                while (iss >> tk) {
                    if (tk == "ALL") {
                        for (auto& us : u) {
                            m[us.first]++;
                        }
                    } else if (tk == "HERE") {
                        for (auto& us : u) {
                            if (us.second.a) {
                                m[us.first]++;
                            }
                        }
                    } else if (tk.size() >= 3) {
                        try {
                            int id = stoi(tk.substr(2));
                            m[id]++;
                        } catch (const invalid_argument& ex) {
                            cerr << "Invalid user ID: " << tk.substr(2) << endl;
                        }
                    }
                }
            } else if (a == "OFFLINE" && ev.size() >= 3) {
                string idStr = ev[2].substr(2);
                if (!idStr.empty()) {
                    try {
                        int id = stoi(idStr);
                        if (u.find(id) != u.end()) {
                            u[id].a = false;
                            m[id]--;
                            m[-1]--;
                            if (u[id].a) {
                                m[-2]--;
                            }
                        }
                    } catch (const invalid_argument& ex) {
                        cerr << "Invalid user ID: " << idStr << endl;
                    }
                }
            }
        }
    }

    vector<string> g() {
        vector<string> r;
        for (const auto& me : m) {
            if (me.first >= 0) {
                r.push_back("id" + to_string(me.first) + " - " + to_string(me.second));
            }
        }
        sort(r.begin(), r.end());
        return r;
    }
};

int main() {
    vector<vector<string>> e = {
        {"MESSAGE", "0", "ALL id158 id42"},
        {"OFFLINE", "1", "id158"},
        {"MESSAGE", "2", "id158 id158"},
        {"OFFLINE", "3", "id23"},
        {"MESSAGE", "60", "HERE id158 id42 id23"},
        {"MESSAGE", "61", "HERE"}
    };

    C c;
    c.p(e);
    vector<string> r = c.g();
    for (const string& s : r) {
        cout << s << endl;
    }
    return 0;
}