def calculate_maximum_sum(r, s, k):  
    ans = float('-inf')
    n = len(r)
    sum_val = 0
# Running on TC
    for i in range(n):
        if s[i] == 1:
            sum_val += r[i]
        elif s[i] == -1:
            sum_val -= r[i]
        ans = max(ans, sum_val)

    sf = []
    sum_val = 0
    for i in range(n):
        if s[i] == 1:
            sum_val += r[i]
        elif s[i] == -1:
            sum_val -= r[i]
        sf.append(sum_val)

    p = []
    sum_val = 0
    for i in range(n - 1, -1, -1):
        if s[i] == 1:
            sum_val += r[i]
        elif s[i] == -1:
            sum_val -= r[i]
        p.append(sum_val)

    p.reverse()
    sum_val = 0
    for i in range(k // 2, k):
        sum_val += r[i]

    if k == n:
        ans = max(ans, sum_val)
        print(ans)
        return

    ans = max(ans, sum_val + p[k])

    for i in range(k, n):
        sum_val -= r[i - k // 2]
        sum_val += r[i]
        if i + 1 != n:
            ans = max(ans, sf[i - k] + sum_val + p[i + 1])
        else:
            ans = max(ans, sf[i - k] + sum_val)

    print(ans)

# Example usage:
rates = [2, 4, 1, 5, 10, 6]
strategy = [-1, 1, 0, 1, -1, 0]
k = 4                   
# 18

calculate_maximum_sum(rates, strategy, k)
