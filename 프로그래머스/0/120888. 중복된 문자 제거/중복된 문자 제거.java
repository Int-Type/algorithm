class Solution {
    public String solution(String my_string) {
        StringBuilder result = new StringBuilder();
        boolean[] seen = new boolean[128]; 

        for (char c : my_string.toCharArray()) {
            if (!seen[c]) { 
                result.append(c);
                seen[c] = true; 
            }
        }

        return result.toString();
    }
}
