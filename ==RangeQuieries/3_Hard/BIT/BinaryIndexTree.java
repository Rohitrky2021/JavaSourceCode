// Sum of Interval and Update with Number of Divisors
// Time Complexity for answering Q queries will be O(Q * log(N)).
// Auxiliary Space: O(N)

import java.util.*;

// public class Main {
public class BinaryIndexTree {

	static int[] divisors = new int[100];
	static int[] BIT = new int[100];

	// structure for queries with members type,
	// leftIndex, rightIndex of the query
	static class Query {
		int type, l, r;

		public Query(int type, int l, int r) {
			this.type = type;
			this.l = l;
			this.r = r;
		}
	}

	// function to calculate the number
	// of divisors of each number
	static void calcDivisors() {
		for (int i = 1; i < 100; i++) {
			for (int j = i; j < 100; j += i) {
				divisors[j]++;
			}
		}
	}
	// function for updating the value

	static void update(int x, int val, int n) {
		for (int i = x; i <= n; i += i & -i) {
			BIT[i] += val;
		}
	}

	// function for calculating the required
	// sum between two indexes
	static int sum(int x) {
		int s = 0;
		for (int i = x; i > 0; i -= i & -i) {
			s += BIT[i];
		}
		return s;
	}
	// function to return answer to queries

	static void answerQueries(int[] arr, Query[] que, int n, int q) {
		// Declaring a Set
		Set<Integer> s = new TreeSet<>();
		for (int i = 1; i < n; i++) {
			// inserting indexes of those numbers
			// which are greater than 2
			if (arr[i] > 2)
				s.add(i);
			update(i, arr[i], n);
		}

		for (int i = 0; i < q; i++) {
			// update query
			if (que[i].type == 1) {
				while (true) {
					// find the left index of query in
					// the set using binary search
					Iterator<Integer> it = s.iterator();
					int idx = 0;
					while (it.hasNext()) {
						idx = it.next();
						if (idx >= que[i].l
								&& idx <= que[i].r)
							break;
					}
					if (idx > que[i].r)
						break;
					que[i].l = idx;
					// update the value of arr[i] to
					// its number of divisors
					update(idx,
							divisors[arr[idx]] - arr[idx],
							n);
					arr[idx] = divisors[arr[idx]];
					// if updated value becomes less than or
					// equal to 2 remove it from the set
					if (arr[idx] <= 2)
						s.remove(idx);
					que[i].l++;
				}
			}
			// sum query
			else {
				System.out.println(sum(que[i].r)
						- sum(que[i].l - 1));
			}
		}
	}

	// Driver's code
	public static void main(String[] args) {
		calcDivisors();
		int q = 4;
		int[] arr = { 0, 6, 4, 1, 10, 3, 2, 4 };
		int n = arr.length;
		// declaring array of structure of type queries
		Query[] que = new Query[q + 1];
		que[0] = new Query(2, 1, 7);
		que[1] = new Query(2, 4, 5);
		que[2] = new Query(1, 3, 5);
		que[3] = new Query(2, 4, 4);
		answerQueries(arr, que, n, q);
	}
}
