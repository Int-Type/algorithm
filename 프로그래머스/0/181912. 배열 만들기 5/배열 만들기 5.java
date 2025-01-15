import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        List<Integer> result = new ArrayList<>();
        
        for (String str : intStrs) {
            String substring = str.substring(s, s + l);
            int value = Integer.parseInt(substring); 
            
            if (value > k) { 
                result.add(value);
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
