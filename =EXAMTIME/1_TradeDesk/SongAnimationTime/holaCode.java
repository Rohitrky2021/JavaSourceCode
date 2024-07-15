public class holaCode {
    
}

vector<string> solve(vector<string> s, vector<string> a) {
    vector<string> r;
    for (auto& song : s) {
        string sn;
        int sl;
        istringstream ss(song);
        getline(ss, sn, ':');
        ss >> sl;

        for (auto& anim : a) {
            string an;
            int al;
            istringstream as(anim);
            getline(as, an, '/');
            as >> al;

            if (sl % al == 0) {
                r.push_back(an + ":" + to_string(sl / al));
                break;
            }
        }
    }
    return r;
}