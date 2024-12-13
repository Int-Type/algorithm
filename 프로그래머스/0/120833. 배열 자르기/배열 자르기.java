class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        int num = num2 - num1 + 1;
        int[] newNum = new int[num];
        int idx = 0;
        for(int i = num1; i <= num2; i++) {
            newNum[idx] = numbers[i];
            idx++;
        }
        return newNum;
    }
}