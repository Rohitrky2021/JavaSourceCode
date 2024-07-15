import sys
input = sys.stdin.read

def is_stable(matrix, i, j, n, m):
    value = matrix[i][j]
    
    # Check up, down, left, right neighbors
    if i > 0 and matrix[i - 1][j] >= value:
        return False
    if i < n - 1 and matrix[i + 1][j] >= value:
        return False
    if j > 0 and matrix[i][j - 1] >= value:
        return False
    if j < m - 1 and matrix[i][j + 1] >= value:
        return False
    
    return True

def stabilize_matrix(matrix, n, m):
    modified = True
    while modified:
        modified = False
        
        # Iterate over each cell in the matrix
        for i in range(n):
            for j in range(m):
                # Check if matrix[i][j] is strictly greater than all its neighbors
                if is_stable(matrix, i, j, n, m):
                    matrix[i][j] -= 1
                    modified = True
    
    return matrix

def main():
    data = input().strip().split('\n')
    idx = 0
    t = int(data[idx])
    idx += 1
    results = []
    
    for _ in range(t):
        n, m = map(int, data[idx].split())
        idx += 1
        
        matrix = []
        for i in range(n):
            row = list(map(int, data[idx].split()))
            matrix.append(row)
            idx += 1
        
        stabilized_matrix = stabilize_matrix(matrix, n, m)
        
        for row in stabilized_matrix:
            results.append(" ".join(map(str, row)))
    
    print("\n".join(results))

if __name__ == "__main__":
    main()
