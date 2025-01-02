import java.util.*;

class Solution {
    public String solution(String s) {
        Map<Character, Integer> charCount = new HashMap<>();

        for (char c : s.toCharArray()) {
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);
        }

        List<Character> uniqueChars = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            if (entry.getValue() == 1) {
                uniqueChars.add(entry.getKey());
            }
        }

        Collections.sort(uniqueChars);

        StringBuilder result = new StringBuilder();
        for (char c : uniqueChars) {
            result.append(c);
        }

        return result.toString();
    }
}
