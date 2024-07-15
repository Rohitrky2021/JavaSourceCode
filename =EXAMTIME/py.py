for _ in range(int(input())):
    n = int(input())
    a = list(map(int, input().split()))

    mx = 1
    while mx <= 10**9:
        mx *= 2

    mx -= 1

    mn = mx
    for i in range(n):
        mn &= a[i]

    ans = 0
    cur = mx

    for i in range(n):
        cur &= a[i]
        if cur == 0:
            ans += 1
            cur = mx

    ans += mn > 0
    print(ans)
