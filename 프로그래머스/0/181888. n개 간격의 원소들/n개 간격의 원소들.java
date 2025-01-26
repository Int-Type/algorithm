import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> solution(int[] num_list, int n) {
        List<Integer> result = new ArrayList<>();
        
        // 첫 번째 원소부터 n 간격으로 추가
        for (int i = 0; i < num_list.length; i += n) {
            result.add(num_list[i]);
        }
        
        return result;
    }

    // 테스트를 위한 메인 메서드
    public static void main(String[] args) {
        Solution sol = new Solution();
    }
}
