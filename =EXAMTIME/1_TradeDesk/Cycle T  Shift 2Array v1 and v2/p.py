def helper(v):
    n = len(v)
    arr1, arr2 = [v[0]], [v[1]]

    for i in range(2, n):
        ans1 = sum(1 for x in arr1 if x > v[i])
        temp = sum(1 for x in arr2 if x > v[i])

        if ans1 > temp:
            arr1.append(v[i])
        elif temp > ans1:
            arr2.append(v[i])
        else:
            if len(arr1) <= len(arr2):
                arr1.append(v[i])
            else:
                arr2.append(v[i])

    arr1.extend(arr2)
    return arr1

# Example usage:
v = [5,4,3,2,1]
result = helper(v)
print(result)
