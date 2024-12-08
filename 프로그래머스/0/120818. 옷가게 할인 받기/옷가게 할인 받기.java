class Solution {
    public int solution(int price) {
        int answer = 0;
        double sale = 1.0;
        
        if (price >= 500000) {
            sale = 0.80; 
        } else if (price >= 300000) {
            sale = 0.90; 
        } else if (price >= 100000) {
            sale = 0.95; 
        }
        
        answer = (int) (price * sale); 
        return answer;
    }
}