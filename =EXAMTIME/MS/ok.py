def countValidPasswords(n, k):
    MOD = 10 ** 9 + 7
    
    # Initialize result as 26^n
    result = pow(26, n, MOD)
    
    # Calculate the number of passwords with k consecutive equal characters
    for i in range(1, k):
        result -= (26 - i) * pow(25, n - i, MOD)
        result %= MOD
    
    return result

n = 3
k = 3
result = countValidPasswords(n, k)
print(result)
