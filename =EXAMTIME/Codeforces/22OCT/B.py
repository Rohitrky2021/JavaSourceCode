def compute_swaps(n, binary_string):
    reversed_string = binary_string[::-1]
    zero_count = 0
    zero_positions = []
    prefix_sums = [0] * n

    for i in range(n):
        if reversed_string[i] == '0':
            zero_count += 1
            zero_positions.append(i + 1)

    index = 1
    back = 0

    for i in range(len(zero_positions)):
        prefix_sums[i] = zero_positions[i] - index + back
        back += zero_positions[i] - index
        index += 1

    results = []
    for i in range(1, n + 1):
        if zero_count < i:
            results.append(-1)
        else:
            results.append(prefix_sums[i - 1])

    return results

def main():
    num_tests = int(input())
    for _ in range(num_tests):
        n = int(input())
        binary_str = input().strip()
        results = compute_swaps(n, binary_str)
        print(*results)

if __name__ == "__main__":
    main()
