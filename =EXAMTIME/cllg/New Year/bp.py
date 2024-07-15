def solve_arithmetic_mean(n, sequence):
    result_indices = []

    total_sum = sum(sequence)
    target = (total_sum * (n - 1)) // n


   

    for i in range(n):
        if  sequence[i] * (n - 1) == total_sum - sequence[i]:
            result_indices.append(i + 1)

    print(len(result_indices))

    for index in result_indices:
        print(index, end=" ")


def main():
    n = int(input())
    sequence = list(map(int, input().split()))

    solve_arithmetic_mean(n, sequence)


if __name__ == "__main__":
    main()
