import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class p {
    public static String processLogs(List<String> logs) {
        Map<String, Set<String>> branches = new HashMap<>();
        String currentBranch = "main";

        for (String log : logs) {
            String[] parts = log.split("\\s");
            String action = parts[0];

            if (action.equals("switch")) {
                currentBranch = parts[1];
            } else if (action.equals("push")) {
                String fileName = parts[1];

                branches.computeIfAbsent(currentBranch, k -> new HashSet<>()).add(fileName);
            }
        }

        String maxBranch = "";
        int maxCount = 0;

        for (Map.Entry<String, Set<String>> entry : branches.entrySet()) {
            int branchSize = entry.getValue().size();
            if (branchSize > maxCount) {
                maxCount = branchSize;
                maxBranch = entry.getKey();
            }
        }

        return maxBranch;
    }

    public static void main(String[] args) {
        List<String> inputList = List.of("switch A", "push 1", "push 2", "switch B", "push 3", "push 4", "push 5", "switch A", "push 6");
        String result = processLogs(inputList);
        System.out.println(result);
    }
}
