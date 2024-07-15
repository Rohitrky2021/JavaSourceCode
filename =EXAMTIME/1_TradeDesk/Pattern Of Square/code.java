public class code {
    
}
vector<string> solve(int n) {
    vector<string> f;

    if (n <= 0) {
        return f; 
    }
    f.push_back(string(n, '*'));

    for (int i = 1; i <= n - 2; ++i) {
        string l = "*" + string(n - 2, ' ') + "*";
        f.push_back(l);
    }

    f.push_back(string(n, '*'));
    return f;
}