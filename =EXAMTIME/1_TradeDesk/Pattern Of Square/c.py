def solve(n):
    f = []

    if n <= 0:
        return f

    f.append('*' * n)

    for i in range(1, n - 1):
        l = '*' + ' ' * (n - 2) + '*'
        f.append(l)

    f.append('*' * n)
    return f

# Example usage:
n = 5
result = solve(n)

for row in result:
    print(row)
