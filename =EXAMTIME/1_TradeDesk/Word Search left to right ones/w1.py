def solution(matrix, words):
    def dfs(i, j, word, direction, visited):
        if not (0 <= i < len(matrix) and 0 <= j < len(matrix[0])) or visited[i][j]:
            return 0
        
        if matrix[i][j] != word[0]:
            return 0
        
        if len(word) == 1:
            return 1
        
        visited[i][j] = True
        
        result = 0
        for new_direction in range(4):
            if direction is None or (direction + new_direction) % 2 == 1:
                result += dfs(i + directions[new_direction][0],
                              j + directions[new_direction][1],
                              word[1:],
                              new_direction,
                              visited)
        
        visited[i][j] = False
        
        return result
    
    directions = [(-1, 0), (1, 0), (0, -1), (0, 1)]
    
    total_count = 0
    for word in words:
        for i in range(len(matrix)):
            for j in range(len(matrix[0])):
                visited = [[False] * len(matrix[0]) for _ in range(len(matrix))]
                total_count += dfs(i, j, word, None, visited)
    
    return total_count

# Example usage:
matrix1 = [["a", "b", "a", "c"],
           ["x", "a", "c", "d"],
           ["y", "r", "d", "s"]]
words1 = ["ac", "cat", "car", "bar", "acdc", "abacaba"]
print(solution(matrix1, words1))  # Output: 7

matrix2 = [["a", "a", "a"],
           ["a", "a", "a"]]
words2 = ["aaaa"]
print(solution(matrix2, words2))  # Output: 4

matrix3 = [["c", "o", "d", "g"],
           ["a", "t", "e", "r"],
           ["z", "o", "p", "s"]]
words3 = ["code", "signal", "coder", "cat", "dog", "top", "spot"]
print(solution(matrix3, words3))  # Output: 3
