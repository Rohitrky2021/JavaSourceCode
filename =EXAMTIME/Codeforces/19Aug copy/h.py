MOD = 10**9 + 7

def digit_sum(n):
    return sum(int(digit) for digit in str(n))

def satisfies_condition(n, k):
    return digit_sum(k * n) == k * digit_sum(n)

def count_valid_numbers(l, r, k):
    count = 0
    for n in range(10**l, 10**r):
        if satisfies_condition(n, k):
            count += 1
    return count % MOD

def main():
    import sys
    input = sys.stdin.read
    data = input().split()
    
    t = int(data[0])
    index = 1
    results = []
    
    for _ in range(t):
        l = int(data[index])
        r = int(data[index + 1])
        k = int(data[index + 2])
        index += 3
        
        answer = count_valid_numbers(l, r, k)
        results.append(answer)
    
    for result in results:
        print(result)

if __name__ == "__main__":
    main()
