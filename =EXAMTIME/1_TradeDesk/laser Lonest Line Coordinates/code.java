public class code {
    
}

// https://t.me/codingsolns/99316

// https://t.me/skill_sailor_discussion/21575

int findLongestStraightLine(vector<vector<int>>& grid, int row, int col) {
    int n = grid.size();
    int m = grid[0].size();
    vector<pair<int, int>> directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, 1}};

    int maxLength = 0;

    for (const auto& direction : directions) {
        int dx = direction.first;
        int dy = direction.second;
        int length = 0;

        int i = row, j = col;

        while (i >= 0 && i < n && j >= 0 && j < m && grid[i][j] == grid[row][col]) {
            length++;
            i += dx;
            j += dy;
        }

        maxLength = max(maxLength, length);
    }

    return maxLength;
}
int remainingCells(int n, int m, vector<pair<int, int>> laserCoordinates,int currow,int curcol) {
    vector<vector<int>> grid(n, vector<int>(m, 1));

    for (const auto& laser : laserCoordinates) {
        int x = laser.first;
        int y = laser.second;

        for (int i = 0; i < n; ++i) {
            grid[i][y - 1] = 0;
        }

        for (int j = 0; j < m; ++j) {
            grid[x - 1][j] = 0;
        }
    }
    int ans=findLongestStraightLine(grid,currow,curcol)-1;
    if(ans<0) return 1;
    return ans;
}









// while loop me bs changes honge ye dalna " nrw>=1 nrw<=numRows and ncl>=1 and ncl<=numColumns"