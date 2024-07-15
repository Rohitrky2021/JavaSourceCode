from collections import defaultdict

def cp(a1, a2, target):
    m1 = defaultdict(int)
    m2 = defaultdict(int)

    for i in range(len(a1)):
        s = 0
        for j in range(i, len(a1)):
            s += a1[j]
            m1[s] += 1

    for i in range(len(a2)):
        s = 0
        for j in range(i, len(a2)):
            s += a2[j]
            m2[s] += 1

    count = 0

    for entry in m1.items():
        c = target - entry[0]
        count += entry[1] * m2[c]

    return count

# Example usage:
a1 = [5,2,1,6,4]
a2 = [3,5]
target = 10

result = cp(a1, a2, target)
print(result)
