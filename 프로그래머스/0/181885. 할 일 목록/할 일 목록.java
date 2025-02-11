import java.util.*;

class Solution {
    public List<String> solution(String[] todo_list, boolean[] finished) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < todo_list.length; i++) {
            if (!finished[i]) {  
                result.add(todo_list[i]);
            }
        }

        return result;
    }
}