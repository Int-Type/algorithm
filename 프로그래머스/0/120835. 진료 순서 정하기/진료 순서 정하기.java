import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        int n = emergency.length;
        int[] sorted = emergency.clone();
        int[] rank = new int[n];
        
        Arrays.sort(sorted);
        for(int i = 0; i < n / 2; i++) {
            int temp = sorted[i];
            sorted[i] = sorted[n - i - 1];
            sorted[n - i - 1] = temp;
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(emergency[i] == sorted[j]) {
                    rank[i] = j + 1;
                    break;
                }
            }
        }
        return rank;
    }
}