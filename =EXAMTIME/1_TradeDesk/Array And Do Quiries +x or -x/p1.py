class C1:
    def __init__(self):
        pass

    @staticmethod
    def calc1(hm, val, diff):
        ans = 0

        if val + diff in hm and val - diff in hm:
            ans += hm[val + diff] * hm[val - diff]
        if val + diff in hm and val + 2 * diff in hm:
            ans += hm[val + diff] * hm[val + 2 * diff]
        if val - diff in hm and val - 2 * diff in hm:
            ans += hm[val - diff] * hm[val - 2 * diff]

        return ans

    def helper(self, q, diff):
        hm = {}

        n = len(q)
        ans = 0

        for i in range(n):
            op = q[i][0]
            val = int(q[i][1:])
            if op == '+':
                ans += self.calc1(hm, val, diff)
                hm[val] = hm.get(val, 0) + 1
            else:
                ans -= self.calc1(hm, val, diff) * hm.get(val, 0)
                hm.pop(val, None)
            print("Result:", ans)

        # Print or use the result as needed


# Example usage
queries = ["+4", "+5", "+6", "+4", "+3", "-4"]
difference = 1
code_instance = C1()
code_instance.helper(queries, difference)
