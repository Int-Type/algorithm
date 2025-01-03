class Solution {
    public int solution(String my_string) {
        String[] tokens = my_string.split(" "); 
        int result = Integer.parseInt(tokens[0]);

        for (int i = 1; i < tokens.length; i += 2) {
            String operator = tokens[i];
            int num = Integer.parseInt(tokens[i + 1]);

            if (operator.equals("+")) {
                result += num; 
            } else if (operator.equals("-")) {
                result -= num; 
            }
        }

        return result;
    }
}
