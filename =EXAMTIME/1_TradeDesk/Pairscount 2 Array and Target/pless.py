from collections import defaultdict

def cp(a1, a2, target):
    m1, m2 = defaultdict(int), defaultdict(int)

    for a, m in [(a1, m1), (a2, m2)]:
        for i in range(len(a)):
            s = 0
            for j in range(i, len(a)):
                s += a[j]
                m[s] += 1

    count = sum(m1[k] * m2[target - k] for k in m1)

    return count

# Example usage:
a1 = [5,2,1,6,4]
a2 = [3,5]
target = 10

result = cp(a1, a2, target)
print(result)
