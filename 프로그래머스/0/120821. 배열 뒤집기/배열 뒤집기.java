import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i = num_list.length - 1; i >= 0; i--) {
            answer.add(num_list[i]);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}