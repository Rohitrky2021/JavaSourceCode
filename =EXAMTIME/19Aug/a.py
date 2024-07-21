def is_prime(num):
    if num <= 1:
        return False
    if num <= 3:
        return True
    if num % 2 == 0 or num % 3 == 0:
        return False
    i = 5
    while i * i <= num:
        if num % i == 0 or num % (i + 2) == 0:
            return False
        i += 6
    return True

def get_subarrays(s):
    subarrays = []
    for i in range(len(s)):
        for j in range(i + 1, len(s) + 1):
            subarrays.append(int(s[i:j]))
    return subarrays

def sum_largest_primes(s):
    subarrays = get_subarrays(s)
    primes = list(set(filter(is_prime, subarrays)))
    primes.sort(reverse=True)
    return sum(primes[:10])

# Sample Input
input_string = "12234"

# Compute Output
output = sum_largest_primes(input_string)
print(output)  # Should print 1474 for the sample input