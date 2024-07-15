from typing import List, Tuple

class Code:
    @staticmethod
    def solve(mem: List[int], queries: List[List[int]]) -> List[int]:
        alloc = {}
        id = 1
        res = []

        for q in queries:
            if q[0] == 0:
                x = q[1]
                start = -1
                count = 0

                for i in range(len(mem)):
                    if mem[i] == 0:
                        if start == -1 and i % 8 == 0:
                            start = i
                        if start != -1:
                            count += 1
                        if count == x:
                            break
                    else:
                        start = -1
                        count = 0

                if count == x:
                    mem[start:start + x] = [1] * x
                    alloc[start] = (id, x)
                    res.append(start)
                    id += 1
                else:
                    res.append(-1)
            else:
                erase_id = q[1]
                length = -1

                for key, value in list(alloc.items()):
                    if value[0] == erase_id:
                        mem[key:key + value[1]] = [0] * value[1]
                        length = value[1]
                        del alloc[key]
                        break

                res.append(length)

        return res

# Example usage:
# Example usage:
mem_initial = [0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1, 1, 1]
queries_example = [
    [0, 2],
    [0, 1],
    [0, 1],
    [1, 1],
 
     [0, 3],
      [1, 4],
       [0, 4]
]

result = Code.solve(mem_initial, queries_example)
print(result)
