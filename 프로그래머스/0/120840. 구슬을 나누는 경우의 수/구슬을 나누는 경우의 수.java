class Solution {
    public long solution(int balls, int share) {
        return optimizedCombination(balls, share);
    }

    private long optimizedCombination(int n, int r) {
        if (r == 0 || n == r) {
            return 1; 
        }
        r = Math.min(r, n - r); 
        long result = 1;

        for (int i = 0; i < r; i++) {
            result *= (n - i);
            result /= (i + 1);
        }

        return result;
    }
}
