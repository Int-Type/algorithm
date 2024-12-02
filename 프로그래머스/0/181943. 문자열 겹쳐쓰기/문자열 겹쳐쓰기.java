class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        StringBuilder answer = new StringBuilder();
        
        answer.append(my_string.substring(0, s));
        answer.append(overwrite_string);
        if (s + overwrite_string.length() < my_string.length()) {
            answer.append(my_string.substring(s + overwrite_string.length()));
        }

        return answer.toString();
    }
}