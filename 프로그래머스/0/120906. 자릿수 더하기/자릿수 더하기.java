class Solution {
    public int solution(int n) {
        int sum = 0;

        String numStr = String.valueOf(n);
        for (char digit : numStr.toCharArray()) {
            sum += digit - '0'; 
        }

        return sum;
    }
}
