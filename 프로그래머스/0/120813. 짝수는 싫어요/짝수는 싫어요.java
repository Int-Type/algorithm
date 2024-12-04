import java.util.ArrayList;

class Solution {
    public int[] solution(int n) {
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        
        for (int i = 1; i <= n; i += 2) {
            oddNumbers.add(i);
        }
        
        return oddNumbers.stream().mapToInt(i -> i).toArray();
    }
}