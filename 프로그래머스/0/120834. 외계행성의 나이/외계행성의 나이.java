class Solution {
    public String solution(int age) {
        StringBuilder answer = new StringBuilder();
        String ageString = String.valueOf(age);
        
        for(char c : ageString.toCharArray()) {
            answer.append((char)('a' + (c - '0')));
        }
        
        return answer.toString();
    }
}