import java.util.Arrays;

public class code {
    public static String longestCommonSuffixPath(String[] paths) {
        if (paths == null || paths.length == 0) {
            return "";
        }

        Arrays.sort(paths);

        String firstPath = paths[0];
        String lastPath = paths[paths.length - 1];
        int minLength = Math.min(firstPath.length(), lastPath.length());

        int commonLength = 0;
        for (int i = 0; i < minLength; i++) {
            if (firstPath.charAt(i) == lastPath.charAt(i)) {
                commonLength++;
            } else {
                break;
            }
        }

        return commonLength > 0 ? firstPath.substring(0, commonLength) : "";
    }

    public static void main(String[] args) {
        String[] paths = {
            "/a/folder1/folder1/file",
            "/a/folder2/folder1/file",
            "/a/folder3/folder1/folder1"
        };

        String result = longestCommonSuffixPath(paths);
        System.out.println("Longest Common Suffix Path: " + result);
    }
}
