class Solution {
    public int solution(int[][] lines) {
        int[] lineOverlap = new int[201]; 
        int totalOverlap = 0;

        for (int[] line : lines) {
            int start = line[0] + 100;
            int end = line[1] + 100;   
            for (int i = start; i < end; i++) {
                lineOverlap[i]++;
            }
        }

        for (int i = 0; i < lineOverlap.length; i++) {
            if (lineOverlap[i] > 1) {
                totalOverlap++;
            }
        }

        return totalOverlap;
    }
}
