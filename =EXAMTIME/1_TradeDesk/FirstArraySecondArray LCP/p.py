def solve(first_list, second_list):
    longest = 0
    for num1 in first_list:
        str1 = str(num1)
        for num2 in second_list:
            str2 = str(num2)
            i = 0
            while i < len(str1) and i < len(str2) and str1[i] == str2[i]:
                i += 1
            longest = max(longest, i)
    return longest

# Example usage:
first_list = [123456789, 987654321]
second_list = [1234509876, 9876543210]
result = solve(first_list, second_list)
print("Longest Common Prefix Length:", result)
