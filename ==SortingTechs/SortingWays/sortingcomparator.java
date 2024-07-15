public class sortingcomparator {

  }

  // To sort an array/Collections:

  Arrays.sort(array,(a,b)->a[0]-b[0]); // ascending sorting 2d array based on first index

  Arrays.sort(array,(a,b)->{if(a[1]==b[1])return 0;
                            if(a[1]<b[1])return-1;
                            return 1;  }
                            ); // to avoid overflow

  // Sorting map keys
  Map<Integer, Integer> count = new HashMap();for(
  int i:nums)
  {
    count.put(i, count.getOrDefault(i, 0) + 1);
}
List<Integer> candidates = new ArrayList(count
    .keySet());Collections.sort(candidates,(w1,w2)->count.get(w1).equals(count.get(w2))?w1.compareTo(w2):count.get(w2)-count.get(w1));

Priority Queue
PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> count[b] - count[a]);

// Places b on top of a in heap
// Max heap
PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());
Convert an
array to list:Arrays.asList(i,j
)