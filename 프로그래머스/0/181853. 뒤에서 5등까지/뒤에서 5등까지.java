import java.util.Arrays;

class Solution {
    public int[] solution(int[] num_list) {
        Arrays.sort(num_list);
        int[] answer = {num_list[0],num_list[1],num_list[2],num_list[3],num_list[4]};
        return answer;
    }
}