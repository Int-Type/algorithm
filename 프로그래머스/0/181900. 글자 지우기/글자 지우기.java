import java.util.HashSet;
import java.util.Set;

class Solution {
    public String solution(String my_string, int[] indices) {
        Set<Integer> indexSet = new HashSet<>();
        for (int index : indices) {
            indexSet.add(index);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < my_string.length(); i++) {
            if (!indexSet.contains(i)) { 
                result.append(my_string.charAt(i));
            }
        }
        
        return result.toString();
    }
}
