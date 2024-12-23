import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] dice = {a, b, c, d};
        Arrays.sort(dice); 

        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : dice) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        if (freq.size() == 1) {
            return 1111 * dice[0];
        } else if (freq.size() == 2) {
            List<Integer> keys = new ArrayList<>(freq.keySet());
            int p = keys.get(0);
            int q = keys.get(1);

            if (freq.get(p) == 3 || freq.get(q) == 3) {
                int major = freq.get(p) == 3 ? p : q;
                int minor = freq.get(p) == 1 ? p : q;
                return (int) Math.pow(10 * major + minor, 2);
            } else {
                return (p + q) * Math.abs(p - q);
            }
        } else if (freq.size() == 3) {
            int pair = -1;
            int product = 1;
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                if (entry.getValue() == 2) {
                    pair = entry.getKey();
                } else {
                    product *= entry.getKey();
                }
            }
            return product;
        } else {
            return dice[0]; 
        }
    }
}
