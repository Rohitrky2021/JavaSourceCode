def main():
    N, A, B = map(int, input().split())

    numbers = list(range(1, N + 1))

    found = False
    for i in range(1, 2**N):
        sum1 = 0
        sum2 = 0
        for j in range(N):
            if (i & (1 << j)) > 0:
                sum1 += numbers[j]
            else:
                sum2 += numbers[j]
        if sum1 / sum2 == A / B:
            print(sum1, sum2)
            found = True
            break

    if not found:
        print("-1")

if _name_ == "_main_":
    main()

 