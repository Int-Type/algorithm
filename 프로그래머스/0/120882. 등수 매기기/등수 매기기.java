import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(int[][] score) {
        int n = score.length;
        Double[] averages = new Double[n];

        for (int i = 0; i < n; i++) {
            averages[i] = (score[i][0] + score[i][1]) / 2.0;
        }

        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        Arrays.sort(indices, (a, b) -> Double.compare(averages[b], averages[a]));

        int[] ranks = new int[n];
        int rank = 1;
        for (int i = 0; i < n; i++) {
            if (i > 0 && averages[indices[i]].equals(averages[indices[i - 1]])) {
                ranks[indices[i]] = ranks[indices[i - 1]]; 
            } else {
                ranks[indices[i]] = rank;
            }
            rank++;
        }

        return ranks;
    }
}
