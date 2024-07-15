import java.util.*;

class Solution{
    // public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        
    // }

      public static int[] smallestSufficientTeam(String[] arr, List<List<String>> people) {
        Arrays.to
        int count = 1;
        List<Integer> ans = new ArrayList<>();
        List<List<String>> sortedPeople = new ArrayList<>(people); // Create a sorted copy of the people list
        Collections.sort(sortedPeople, new Comparator<List<String>>() {
            @Override
            public int compare(List<String> list1, List<String> list2) {
                return Integer.compare(list2.size(), list1.size());
            }
        });

        for (List<String> s : sortedPeople) {
            int originalIndex = people.indexOf(s); // Get the original index of the current list
    count=1;
            if (s.isEmpty()) {
                return ans.stream().mapToInt(Integer::intValue).toArray(); // Convert ans to int array and return
            }

            for (int j = 0; j < arr.length; j++) {
                if (s.contains(arr[j])) {
                    if(count==1){
                    ans.add(originalIndex);
                    count--;}
                    ans.remove(o)
                    arr
                    s.remove(arr[j]);
                }
            }
        }

        return ans.stream().mapToInt(Integer::intValue).toArray(); // Convert ans to int array and return
    }
}