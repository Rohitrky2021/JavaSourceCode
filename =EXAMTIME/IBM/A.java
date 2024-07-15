import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A {
    public static void main(String[] args) {
        String s1 = "{\"key1\":\"value1\",\"key2\":\"value2\",\"key3\":\"value3\"}";
        String s2 = "{\"key1\":\"value1\",\"key2\":\"valueX\",\"key3\":\"valueZ\"}";

        List<String> ans = findKeysWithDifferentValues(s1, s2);
        System.out.println(ans);
    }

    public static List<String> findKeysWithDifferentValues(String s1, String s2) {
        Map<String, String> map1 = parseStringToMap(s1);
        Map<String, String> map2 = parseStringToMap(s2);
        List<String> ans = new ArrayList<>();

        for (String key : map1.keySet()) {
            if (map2.containsKey(key) && !map1.get(key).equals(map2.get(key))) {
                ans.add(key);
            }
        }
        return ans;
    }

    public static Map<String, String> parseStringToMap(String input) {
        Map<String, String> map = new HashMap<>();
        Pattern pattern = Pattern.compile("\"(.*?)\":\"(.*?)\"");
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            map.put(matcher.group(1), matcher.group(2));
        }

        return map;
    }
}
