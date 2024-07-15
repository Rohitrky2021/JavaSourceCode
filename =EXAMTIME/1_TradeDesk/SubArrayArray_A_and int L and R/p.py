class Code:
    @staticmethod
    def solve(a, l, r):
        s = set()
        m = {}
        i = 0
        ans = float('inf')

        for x in a:
            if x < l or x > r:
                i += 1
                continue
            else:
                if x not in m:
                    m[x] = i
                    s.add((i, x))
                else:
                    s.remove((m[x], x))
                    s.add((i, x))
                    m[x] = i

            if len(m) == r - l + 1:
                first_pair = min(s)
                ans = min(ans, i - first_pair[0] + 1)
            i += 1

        print(-1 if ans == float('inf') else ans)


if __name__ == "__main__":
    a = [2, 4, 1, 3, 5]
    l = 2
    r = 4

    Code.solve(a, l, r)


# The solve function takes a list of integers a and two integers l and r. 
# It seems to be designed to find the minimum subarray length that
# contains all values from l to r (inclusive). 
# The function uses a set (s) and a map (m) to keep track 
# of relevant information about the input array. 
# The variable ans is used to store the minimum subarray length.