class Solution {
    public String solution(String myString) {
        StringBuilder sb = new StringBuilder();

        for (char c : myString.toCharArray()) {
            if (c == 'a') {
                sb.append('A'); 
            } else if (c != 'A' && Character.isUpperCase(c)) {
                sb.append(Character.toLowerCase(c)); 
            } else {
                sb.append(c); 
            }
        }

        return sb.toString();
    }
}
