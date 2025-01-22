public class Solution {
    public int solution(int[] arr, int idx) {
        for (int i = idx; i < arr.length; i++) {
            if (arr[i] == 1) {
                return i; 
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution(new int[]{0, 0, 0, 1}, 1));
        System.out.println(sol.solution(new int[]{1, 0, 0, 1, 0, 0}, 4));
        System.out.println(sol.solution(new int[]{1, 1, 1, 1, 0}, 3)); 
    }
}
