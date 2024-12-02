class Solution {
    public int solution(int[] arr1, int[] arr2) {
        int a = arr1.length;
        int b = arr2.length;    
        int answer = 0;
        
        if (a == b) {
            int totalOne = 0;
            int totalTwo = 0;
            for(int i = 0; i < arr1.length; i++) {
                totalOne += arr1[i];
                totalTwo += arr2[i];
            }
            if (totalOne == totalTwo) {
                answer = 0;
            } else if (totalOne > totalTwo){
                answer = 1;
            } else {
                answer = -1;
            }
        } else if(a > b) {
            answer = 1;
        } else {
            answer = -1;
        }
        
        return answer;
    }
}