Recursion -> memoization -> tabulation -> space optimization

 - memoization - top to bottom
 - tabulation - bottom-up 

 * Recursion -> solve every sub problem 
 - (there is overlapping of sub problems in recursion)
 * Memoization - tend to store the value of sub problems in some map / table.

 * Tabulation - bottom-up, from base case to required answer

 * Space optimization - for space optimization, you need to find the pattern in the problem.

### 3 step to solve every dp problem : 
    1) Express the problem in terms of indexes.
    2) Try out all possible choices at a given index.
    3) Take the maximum/minmum of all choices (according to question)
### tabulation -
    1. copy the base case of recursion
    2. for loops for changing states 
    3. copy the recursion

**If you are doing recursion step from 0th index to n-1th index, Tabulation will always be its opposite.**

unknown error while using general tabulation approach so use **shifting of index** technique
where i means index[i-1] to tackle ```if(i < 0 )``` testcase of recursion
because we can't store negative index in dp as dp[-1].