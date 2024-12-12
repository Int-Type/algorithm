class Solution {
    public int solution(int n, int k) {
        int lamb = 12000;
        int drink = 2000;
        
        int freeDrink = n / 10;
        
        int total = (n * lamb) + ((k - freeDrink) * drink);
        
        return total;
    }
}