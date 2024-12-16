class Solution {
    public String solution(String rsp) {
        StringBuilder result = new StringBuilder();
        
        for(char c : rsp.toCharArray()) {
            if(c == '2') {
                result.append('0');
            } else if (c == '0') {
                result.append('5');
            } else if (c == '5') {
                result.append('2');
            }
        }
        
        return result.toString();
    }
}