def solve():
    import sys
    input = sys.stdin.read
    data = input().split()

    idx = 0
    t = int(data[idx])
    idx += 1
    results = []

    for _ in range(t):
        n = int(data[idx])
        m = int(data[idx + 1])
        idx += 2
        s = list(data[idx])
        idx += 1
        ind = list(map(int, data[idx:idx + m]))
        idx += m
        c = list(data[idx])
        idx += 1

        # Sort the characters in c to use the smallest characters first
        c.sort()
        
        # Count how many times each index is updated
        update_count = {}
        for i in ind:
            if i in update_count:
                update_count[i] += 1
            else:
                update_count[i] = 1

        # Track the position in c to place the smallest characters
        pos = 0
        for i in sorted(update_count.keys()):
            count = update_count[i]
            s[i - 1] = c[pos]
            pos += count

        results.append("".join(s))

    print("\n".join(results))

# This function can be called to execute the solution:
solve()
