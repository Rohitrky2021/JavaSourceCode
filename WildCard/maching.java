import java.util.List;


// public class PlagiarismRemoval {
        public class maching {
    
        public static int countChangesToRemovePlagiarism(List<String> v) {
            int n = v.size();
            int m = v.get(0).length();
            int ans = 0;
    
            for (int i = 0; i < m; i++) {
                char last = v.get(0).charAt(i);
                for (int j = 0; j < n; j++) {
                    if (v.get(j).charAt(i) != '?' && last == '?')
                        last = v.get(j).charAt(i);
                    else if (v.get(j).charAt(i) != '?' && v.get(j).charAt(i) != last) {
                        ans++;
                        break;
                    }
                }
            }
    
            return ans;
        }
    
        public static void main(String[] args) {
            // Example usage
            List<String> table = List.of(
                    "abcde",
                    "ab?de",
                    "abfde",
                    "ab?de"
            );
    
            int changes = countChangesToRemovePlagiarism(table);
            System.out.println("Number of changes to remove plagiarism: " + changes);
        }
    }
    
