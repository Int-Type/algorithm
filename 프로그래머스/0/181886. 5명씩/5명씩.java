import java.util.*;

class Solution {
    public List<String> solution(String[] names) {
        List<String> result = new ArrayList<>();

        // 5명씩 그룹을 나누면서, 각 그룹의 첫 번째 사람만 저장
        for (int i = 0; i < names.length; i += 5) {
            result.add(names[i]);
        }

        return result;
    }
}