def solution(matrix, words):
    m, n = len(matrix), len(matrix[0])
    result = 0

    for word in words:
        for i in range(m):
            for j in range(n):
                for di, dj in [(0, 1), (1, 0)]:
                    x, y = i, j
                    if word[0] != matrix[x][y]:
                        continue
                    for k in range(1, len(word)):
                        x += di
                        y += dj
                        if x < 0 or y < 0 or x == m or y == n:
                            break
                        if word[k] != matrix[x][y]:
                            break
                        if x == m - 1 or y == n - 1:
                            di, dj = -di, -dj
                    else:
                        result += 1

    return result

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
words3 = ["code", "signal", "coder", "cat", "dog", "top","spot"]
print(solution(matrix3, words3))  # Output: 3