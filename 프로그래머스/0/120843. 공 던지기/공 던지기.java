class Solution {
    public int solution(int[] numbers, int k) {
        int idx = (2 * (k - 1) % numbers.length);
        return numbers[idx];
    }
}