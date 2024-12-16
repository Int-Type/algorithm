import java.util.*;

class Solution {
    public String solution(String letter) {
        Map<String, String> morseMap = new HashMap<>();
        String[] morseCodes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", 
                               ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", 
                               ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        String[] alphabets = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", 
                              "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        for(int i = 0; i < morseCodes.length; i++) {
            morseMap.put(morseCodes[i], alphabets[i]);
        }
        
        String[] morseWords = letter.split(" ");
        StringBuilder result = new StringBuilder();
        
        for(String morse : morseWords) {
            result.append(morseMap.get(morse));
        }
        
        return result.toString();
    }
}