class Solution {
    public int solution(int[] array) {
        int count = 0;
        for (int num : array) {
            String str = String.valueOf(num);
            for (char ch : str.toCharArray()) {
                if (ch == '7') {
                    count++;
                }
            }
        }
        return count;
    }
}
