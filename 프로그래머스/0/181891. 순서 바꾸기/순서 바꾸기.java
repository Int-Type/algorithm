import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        int len = num_list.length;
        int[] result = new int[len];

        System.arraycopy(num_list, n, result, 0, len - n);
        System.arraycopy(num_list, 0, result, len - n, n);

        return result;
    }
}
