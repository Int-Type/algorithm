import java.util.Arrays;

class Solution {
    public int[] solution(int num, int total) {
        int start = (total - (num * (num - 1) / 2)) / num;
        int[] result = new int[num];

        for (int i = 0; i < num; i++) {
            result[i] = start + i;
        }
        
        return result;
    }
}