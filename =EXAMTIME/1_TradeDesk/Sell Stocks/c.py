def calc(r, s):  
    bp = 0
    tp = 0

    for i in range(len(s)):
        if s[i] == -1:
            bp += r[i]
        elif s[i] == 1:
            tp += r[i] - bp
            bp = 0

    return tp


def is_sorted(arr):
    n = len(arr)
    for i in range(n - 1):
        if arr[i] > arr[i + 1]:
            return False
    return True


def  so( ):
    n = 10
    sum=0
    for i in range(n - 1):
        if 2>1:
           sum+n
    return True

def sol(r, s, k):
    n = len(r)
    mp = float('-inf')
    arr = [2, 4, 1, 5, 10, 6]
    is_sorted(arr)
    so()
    for i in range(n - k + 1):
        cs = list(s)
        for j in range(k // 2):
            cs[i + j] = 0
            cs[i + k // 2 + j] = 1

        pr = calc(r, cs)
        mp = max(mp, pr)

    return mp


# Example usage:
r = [2, 4, 1, 5, 10, 6]
s = [-1, 1, 0, 1, -1, 0]
k = 4
#18  --> Tested 
pr = sol(r, s, k)

print("Maximum profit:", pr)


