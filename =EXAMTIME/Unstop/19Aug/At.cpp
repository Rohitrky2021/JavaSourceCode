Problem Name: Longest Palindromic Concatenation

Problem Statement:
You are given N strings (all characters lowercase), you can choose any two strings out of these N strings and if their concatenation can be rearranged to a palindrome. Then this concatenated string is valid.
Among all possible valid concatenated strings, return the length of the longest one.
 
Note: If N=1, then output is 1.


Brute Force Method:
Observation: Any string can be rearranged to a palindrome if the no. of distinct characters with odd occurrences <= 1. Now, we will store the character frequency of the ith string, in array cnt[ i ]. Now to check if two strings ( s[ i ], s[ j ] ) can be concatenated resulting in palindrome, by simply combining cnt[ i ] and cnt[  j ], and calculating how many distinct characters are there with odd occurrences. We will make two nested loops, one for i and the second for j.


Time complexity : O((n^2) )

The time complexity is determined by the number of operations performed in the algorithm:

Loop for i  will iterate n times every time
Loop for j will iterate n times at max.  
Combining cnt[ i ] and cnt [ j ] takes 26 operations

However, it's essential to consider the number of operations within the innermost loop, which is the most significant factor in determining the overall time complexity.
In this case, the innermost loop checks each character frequency count from cnt[i] and cnt[j] to calculate the count of characters with odd frequencies. This loop iterates over 26 characters, so it can be considered constant time, i.e., O(1).
Therefore, the correct time complexity is not O(26×n2), but rather O(n2).

Space complexity: O( n*26 )

The space complexity is O(N * 26) due to the storage of a 2D array (i.e. cnt)  where each string's character frequencies are kept. This array is essential for quick access to character counts, which are crucial for determining the palindromic potential of concatenated strings.


Implementation:

For each valid pair of strings, the algorithm computes the concatenated string's character frequencies and checks for palindromic potential by counting odd occurrences.
It then updates the maximum length if this pair produces a longer valid palindrome than previously found.
This approach directly compares every possible pair, ensuring all combinations are considered but at a high computational cost.
The loop structure allows for comprehensive checking but is inefficient for large datasets due to its quadratic time complexity.


CODE

#include <bits/stdc++.h>
using namespace std;

int main()
{
    int n; 
    cin >>n;
    
    // Check if there's only one string of length 1
    if (n == 1) {
        string singleString;
        cin >> singleString;
        cout << 1 << endl;
        return 0;
    }

    vector<string> arr(n);
    for (auto  &v: arr){
        cin>> v;
        }
    
    vector<vector<int>> cnt(n ,vector<int> (26));
    for (int i=0;i<n;i++){
        for (auto v: arr[i]){
            cnt[i][v-'a']++;
        }
    }
    int ans = 0;
    for (int i=0;i<n;i++){
        for (int j=i + 1;j<n;j++){
            int oddcnt = 0;
            for (int k=0;k<26;k++){
                if ((cnt[i][k] + cnt[j][k])%2!=0)
                    oddcnt++;
            }
            if (oddcnt <= 1 && ans <(int)arr[i].size() + (int)arr[j].size() ){
                ans = (int)arr[i].size() + (int)arr[j].size();
            }
        }
    }  
    cout << ans<< endl;  
     	
    return 0;
}




Code Explanation

Input Reading:
Reads an integer n representing the number of strings to be input.
If n=1, then reads the only string in string  ‘singleString’ and ‘1’ is printed and the function is returned. Else,
Reads a vector arr of n strings.

Character Counting:
Initializes a 2D vector cnt of size n x 26 to store the count of each character in each string.
Uses nested loops to iterate through each string, counting the occurrences of each character

Pairwise Comparison:++++++++++
Uses nested loops to iterate over pairs of strings (i and j).
For each pair, it calculates the count of characters that have an odd frequency when considering both strings.

Palindrome Check:
Checks if the count of characters with odd frequency is at most 1, indicating that the concatenated string can be rearranged to form a palindrome.
If the condition is satisfied, it updates the maximum length of valid concatenated strings.

Output:
Prints the maximum length of the valid concatenated strings.



Optimized Method:
In this, we’ll hash each string, ith bit of hash will be set only if the occurrence of ith character in the string is odd. and store this in a map ( mxHash ) along with their sizes i.e. mxHash[ h1 ] is a multiset of sizes of strings with hash = h1.


Now, two strings ( s[ i ] and s[ j ] ) can make palindromic concatenation if
hash [ i ] xor hash [ j ] have no. set bits <= 1
That means. It will be either 0 or some power of 2.

For each i, if i want the optimal j, it can be found like this.
Case1
hash[ i ] xor hash[ j ] == 0 
hash[ i ] = hash [ j ] 
Size of optimal s[ j ] = maximum value in mxHash[ hash [ i ] ] after removing hash[ i ].
 Case2
hash[ i ] xor hash[ j ] = 2^k
Hash[ i ] xor (2^k) = hash[ j ]
We will loop over value of k ( 0<=k<=25)
Size of optimal s[ j ] = mx value in mxHash[ hash[ i ] xor (2^k) ] .



// Time complexity 
 For every string, we are iterating for k ( 0<=k<=25), and then retrieving some value from the multiset
Thus Time complexity is O(n*26*logn) = O(26*nlogn)

// Space complexity 
O( n ) as for storing the array.
And O( n ) for mxHash.
Thus Space Complexity is O(2*n) = O(n)


Implementation:
By using a bitwise hash, we significantly reduce the number of necessary comparisons by grouping strings with the same palindromic potential.
It then utilizes these precomputed hashes to quickly identify potential pairs by checking hash conditions with XOR operations.
This method efficiently narrows down the search space using bitwise operations, allowing for faster comparisons.
By leveraging hash maps and sets, we can quickly access and update the best candidates for each string, optimizing the search for the longest palindrome.


CODE

#include <bits/stdc++.h>
using namespace std;


int main() {
    int n;
    cin >> n;


    if (n == 1) {
        string singleString;
        cin >> singleString;
        cout << 1 << endl;
        return 0;
    }


    vector<string> arr(n);
    for (auto &v : arr)
        cin >> v;


    map<int, multiset<int>> mxHash;
    vector<int> hash(n);
    int ans = 0;
   
    for (int i = 0; i < n; i++) {
        for (auto v : arr[i]) {
            hash[i] ^= (1ll << (v - 'a'));
        }
        mxHash[hash[i]].insert((int)arr[i].size());
    }


    for (int i = 0; i < n; i++) {
        int hs = hash[i];
        mxHash[hs].erase(mxHash[hs].find((int)arr[i].size()));
        if (!mxHash[hs].empty()) {
            ans = max(ans, (int)arr[i].size() + (*--mxHash[hs].end()));
        }
        for (int mid = 0; mid < 26; mid++) {
            if (mxHash.count(hs ^ (1ll << mid)) and !mxHash[hs^(1ll<<mid)].empty()) {
                ans = max(ans, (int)arr[i].size() + (*--mxHash[hs ^ (1ll << mid)].end()));
            }
        }
        mxHash[hs].insert(arr[i].size());
    }


    cout << ans << endl;


    return 0;
}


// Code Explanation:

// Input Reading:
// The program starts by reading an integer n representing the number of strings.
// If n=1, then reads the only string in string  ‘singleString’ and ‘1’ is printed and the function is returned. Else,
//  Reads n strings into a vector arr.

// Hashing and Multiset:
// It declares a map mxHash where the keys are integers (hash values) and the values are multisets of integers.
// It also declares a vector hash to store the hash values for each string.

// Hashing Strings:
// This loop iterates through each string in the vector arr, calculates a hash value for each string using bitwise XOR, and inserts the length of the string into the corresponding multiset in the map.

// Main Logic:
// The main logic is contained within the second loop. 
// It iterates through each string again and tries to find the maximum possible length of concatenated strings with distinct characters. 
// The result is stored in the variable ans, which is eventually printed.

// Finding Maximum Length:
// The loop checks for various conditions to determine the maximum length. 
// It involves comparing the lengths of current and other strings with different hash values.

// Output:
// Finally, the maximum length is printed.













Problem Name: Longest Palindromic Concatenation

Topic: Hashing

Tags: Hashing, Bit Manipulation 

Level: Hard

Language Used: C++

Problem Statement:
You are given N strings(all characters lowercase), you can choose any two strings out of these N strings and if their concatenation can be rearranged to a palindrome. Then this concatenated string is valid. Among all possible valid concatenated strings, return the length of the longest one. // grammatical error in second line.

Note: If N=1, then the length of the longest concatenated string would be the length of the single input string itself.

Input Format:

The first line of input contains one integer N - count of strings.// number of strings given 
Next N lines of input contain 1 string each - s[ i ] i.e. ith string.
Output Format:

Print the length of the longest valid concatenated string.
Constraints:

     1<= N <=10000
     1<=  |s[ i || <= 10000
     2<=Sum of the length of any two strings <= 20000//extra information not needed 


Sample Input 1:

 4
abbc
cbba
de
ed

Sample Output 1:

8



Explanation for Sample Case 1:

Concatenation of string 1,2 = “abbccbba”

The strings "abbc" and "cbba" can be concatenated to form "abbccbba". This concatenated string is a palindrome itself, so the length of this palindrome is 8, which is the length of the longest valid concatenated string in this case.

Sample Input 2:

4
aasd
dassd
ssss
eeee

Sample Output 2:

9

Explanation for Sample Case 1:

Concatenation of string 2,3 = “dassdssss”
Which can be rearranged into “sssdadsss”

The strings "dassd" and "ssss" can be concatenated to form "dassdssss". Although not a palindrome directly, it can be rearranged to form "sssdadsss", a palindrome. The length of this longest possible palindrome is 9.

OR 

Concatenation of string 2,4 = “dassdeeee”
Which can be rearranged into “eesdadsee”

The strings "dassd" and "eeee" can be concatenated to form "dassdeeee". Although not a palindrome directly, it can be rearranged to form "eesdadsee", a palindrome. The length of this longest possible palindrome is also 9.





Code:
#include <bits/stdc++.h>
using namespace std;


int main() {
    int n;
    cin >> n;


    if (n == 1) {
        string singleString;
        cin >> singleString;
        cout << 1 << endl;
        return 0;
    }


    vector<string> arr(n);
    for (auto &v : arr)
        cin >> v;


    map<int, multiset<int>> mxHash;
    vector<int> hash(n);
    int ans = 0;
   
    for (int i = 0; i < n; i++) {
        for (auto v : arr[i]) {
            hash[i] ^= (1ll << (v - 'a'));
        }
        mxHash[hash[i]].insert((int)arr[i].size());
    }


    for (int i = 0; i < n; i++) {
        int hs = hash[i];
        mxHash[hs].erase(mxHash[hs].find((int)arr[i].size()));
        if (!mxHash[hs].empty()) {
            ans = max(ans, (int)arr[i].size() + (*--mxHash[hs].end()));
        }
        for (int mid = 0; mid < 26; mid++) {
            if (mxHash.count(hs ^ (1ll << mid)) and !mxHash[hs^(1ll<<mid)].empty()) {
                ans = max(ans, (int)arr[i].size() + (*--mxHash[hs ^ (1ll << mid)].end()));
            }
        }
        mxHash[hs].insert(arr[i].size());
    }


    cout << ans << endl;


    return 0;
}


//solution provided is correct ,


One Compiler: One_Compiler/Longest_Palindromic_Concatenation
