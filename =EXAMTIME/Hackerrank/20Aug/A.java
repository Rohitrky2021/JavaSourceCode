
    import java.util.HashMap;
    import java.util.Map;
    
    public class A {
    
        public static String getPhoneNumber(String str) {
            Map<String, String> mp = new HashMap<>();
            mp.put("zero", "0");
            mp.put("one", "1");
            mp.put("two", "2");
            mp.put("three", "3");
            mp.put("four", "4");
            mp.put("five", "5");
            mp.put("six", "6");
            mp.put("seven", "7");
            mp.put("eight", "8");
            mp.put("nine", "9");
    
            String[] words = str.split(" ");
            StringBuilder result = new StringBuilder();
    
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                if (word.equals("double")) {
                    i++;
                    if (i < words.length) {
                        String nextWord = words[i];
                        result.append(mp.get(nextWord)).append(mp.get(nextWord));
                    }
                } else if (word.equals("triple")) {
                    i++;
                    if (i < words.length) {
                        String nextWord = words[i];
                        result.append(mp.get(nextWord)).append(mp.get(nextWord)).append(mp.get(nextWord));
                    }
                } else {
                    result.append(mp.get(word));
                }
            }
    
            return result.toString();
        }
    
        public static void main(String[] args) {
            String input = "double four triple seven";
            String phoneNumber = getPhoneNumber(input);
            System.out.println(phoneNumber); // Output: "4477777"
        }
    }
    