import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        int maxFrequency = 0;
        int mode = -1;
        boolean isMultiple = false;

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int value = entry.getValue();
            if (value > maxFrequency) {
                maxFrequency = value;
                mode = entry.getKey();
                isMultiple = false; 
            } else if (value == maxFrequency) {
                isMultiple = true; 
            }
        }
        
        return isMultiple ? -1 : mode;
    }
}
