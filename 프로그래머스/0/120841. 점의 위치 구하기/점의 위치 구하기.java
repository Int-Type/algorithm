class Solution {
    public int solution(int[] dot) {
        int answer = 0;
        int minus = 0;
        int idx = 0;
        for(int i = 0; i < dot.length; i++) {
            if(dot[i] < 0) {
                minus++;
                idx = i;
            }
        }
        
        if(minus == 0) {
            answer = 1;
        } else if (minus == 1 && idx == 0) {
            answer = 2;
        } else if (minus == 1 && idx == 1) {
            answer = 4;
        } else if (minus == 2) {
            answer = 3;
        }
        
        return answer;
    }
}