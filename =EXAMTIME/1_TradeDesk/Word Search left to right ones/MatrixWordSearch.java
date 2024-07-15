public class MatrixWordSearch {
    
}
// https://leetcode.com/discuss/interview-question/4575359/Trade-Desk-OA-(SDE-internship)-2024
// https://t.me/codingsolns/98369
// Python | Bruteforce | O(matrix.length * matrix[0].length * words.length * max(words[i].length))
// Note :== > that the number of direction reversal is at most one
def solveLC(mat, words):
    m,n = len(mat), len(mat[0])
    res = []
    for w in words:
        cnt = 0
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                for di,dj in [(0,1),(1,0)]:
                    x,y = i,j
                    for k in range(len(w)):
                        x += di
                        y += dj
                        if x < 0 or y < 0 or x == m or y == n: break
                        if w[k] != mat[x][y]:
                            break
                        if x == m-1 or y == n-1:
                            di,dj = -di,-dj
                    else:
                        cnt += 1

        res.append(cnt)
    return res
print(solveLC([['a','a','a'],['a','a','a']],['aaaa']))
print(solveLC([['a','a','a'],['a','a','a']],['aaa']))









#include
#include
#include

using namespace std;

bool isValid(int i, int j, int rows, int cols) {
return i >= 0 && i < rows && j >= 0 && j < cols;
}

bool canFormString(vector<vector>& matrix, string& word, int startRow, int startCol, int dirRow, int dirCol) {
int len = word.length();
for (int k = 0; k < len; ++k) {
int i = startRow + k * dirRow;
int j = startCol + k * dirCol;
if (!isValid(i, j, matrix.size(), matrix[0].size()) || matrix[i][j] != word[k]) {
return false;
}
}
return true;
}

int solution(vector<vector>& matrix, vector& words) {
int rows = matrix.size();
int cols = matrix[0].size();
int count = 0;

for (int i = 0; i < rows; ++i) {
    for (int j = 0; j < cols; ++j) {
        for (auto& word : words) {
            // Check left to right
            if (canFormString(matrix, word, i, j, 0, 1)) {
                count++;
            }
            // Check right to left
            if (canFormString(matrix, word, i, j, 0, -1)) {
                count++;
            }
            // Check top to bottom
            if (canFormString(matrix, word, i, j, 1, 0)) {
                count++;
            }
            // Check bottom to top
            if (canFormString(matrix, word, i, j, -1, 0)) {
                count++;
            }
        }
    }
}

return count;
}

int main() {
vector<vector> matrix = {
{'a', 'b', 'a', 'c'},
{'x', 'a', 'c', 'd'},
{'y', 'r', 'd', 's'}
};

vector<string> words = {"ac", "cat", "car", "bar", "acdc", "abacaba"};

int result = solution(matrix, words);

cout << "" << result << endl;

return 0;
}