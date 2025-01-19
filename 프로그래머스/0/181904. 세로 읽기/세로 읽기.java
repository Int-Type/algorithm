class Solution {
    public String solution(String my_string, int m, int c) {
        StringBuilder result = new StringBuilder();
        int rows = my_string.length() / m; 

        for (int i = 0; i < rows; i++) {
            result.append(my_string.charAt(i * m + (c - 1))); 
        }

        return result.toString();
    }
}
