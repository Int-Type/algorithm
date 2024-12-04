class Solution {
    public int solution(int a, int b) {
        String a1 = String.valueOf(a);
        String b1 = String.valueOf(b);
        
        String result1 = a1 + b1;
        String result2 = b1 + a1;
        
        int answer1 = Integer.parseInt(result1);
        int answer2 = Integer.parseInt(result2);
        
        int answer = Math.max(answer1, answer2);
        return answer;
    }
}