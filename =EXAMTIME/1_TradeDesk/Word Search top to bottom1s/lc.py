def solveLC(mat, words):
    m,n = len(mat), len(mat[0])
    res = []
    for w in words:
        cnt = 0
        for i in range(len(mat)):
            for j in range(len(mat[0])):
                for di,dj in [(0,1),(1,0)]:
                    x,y = i,j
                    if w[0] != mat[x][y]: continue
                    for k in range(1,len(w)):
                        x += di
                        y += dj
                        if x < 0 or y < 0 or x == m or y == n: break
                        if w[k] != mat[x][y]:
                            break
                        if x == m-1 or y == n-1:
                            di,dj = -di,-dj
                    else:
                        cnt += 1

        res.append(cnt)
    return sum(res)
# print(solveLC([['a','a','a'],['a','a','a']],['aaaa'])) 
# print(solveLC([['a','a','a'],['a','a','a']],['aaa']))
print(solveLC([['a','b','a','c'],['x','a','c','d'],['y','r','d','s']],["ac", "cat", "car", "bar", "acdc", "abacaba"]))
# print(solveLC([['a','b','a','c'],['x','a','c','d'],['y','r','d','s']],["ac"]))