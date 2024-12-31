class Solution {
    public String solution(String cipher, int code) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < cipher.length(); i++) {
            if ((i + 1) % code == 0) { 
                result.append(cipher.charAt(i));
            }
        }

        return result.toString();
    }
}
