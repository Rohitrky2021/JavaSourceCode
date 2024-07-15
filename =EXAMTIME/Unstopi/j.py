def findSumOfConcatenatedValues(A, N):
    MOD = 998244353
    total_sum = 0

    for i in range(N):
        for j in range(i + 1, N):
            concatenatedValue = A[i] * 10**(len(str(A[j]))) + A[j]
            total_sum = (total_sum + concatenatedValue) % MOD

    return total_sum

if __name__ == "__main__":
    N = int(input())
    array = list(map(int, input().split()))

    print(findSumOfConcatenatedValues(array, N))
