import java.util.*;

public class C {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt(); // Number of test cases

        while (t-- > 0) {
            int n = scanner.nextInt(); // Number of sets
            if (n == 1) {
                System.out.println(0);
                break;
            }
            Set<Integer> unionSet = new HashSet<>();
            List<Set<Integer>> candidateSets = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int k = scanner.nextInt(); // Number of elements in the set
                Set<Integer> currentSet = new HashSet<>();

                for (int j = 0; j < k; j++) {
                    int element = scanner.nextInt();
                    currentSet.add(element);
                }

                candidateSets.add(currentSet);

            }

            // Find the set with the least size among the candidate sets
            int minSize = Integer.MAX_VALUE;
            for (Set<Integer> set : candidateSets) {
                minSize = Math.min(minSize, set.size());
            }

            Set<Integer> smallestSet = null;
            int maxIntersection = 0;

            for (Set<Integer> set : candidateSets) {
                int intersectionCount = 0;

                for (Set<Integer> otherSet : candidateSets) {
                    if (set != otherSet) { // Ensure we're not comparing a set with itself
                        Set<Integer> temp = new HashSet<>(set);
                        temp.retainAll(otherSet); // Calculate the intersection

                        if (temp.size() > intersectionCount) {
                            intersectionCount = temp.size();
                        }
                    }
                }

                if (set.size() < smallestSet.size() || smallestSet == null) {
                    smallestSet = set;
                    maxIntersection = intersectionCount;
                }
            }

            System.out.println(maxIntersection);

            // Calculate the answer
            Set<Integer> answerSet = new HashSet<>();
            for (Set<Integer> set : candidateSets) {
                if (set.size() == minSize) {
                    answerSet.addAll(set);
                }
            }

            System.out.println(answerSet.size());

            // Check if this set has any elements already in the union set
            boolean containsUnionElements = false;
            for (int element : currentSet) {
                if (unionSet.contains(element)) {
                    containsUnionElements = true;
                    break;
                }
            }

            if (!containsUnionElements) {
                candidateSets.add(currentSet);
            }

            // Update the union set
            unionSet.addAll(currentSet);
        }
    }
}
