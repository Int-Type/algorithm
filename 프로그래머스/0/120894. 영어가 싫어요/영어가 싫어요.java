class Solution {
    public long solution(String numbers) {
        String[] words = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        StringBuilder result = new StringBuilder();

        int i = 0;
        while (i < numbers.length()) {
            for (int j = 0; j < words.length; j++) {
                if (numbers.startsWith(words[j], i)) {
                    result.append(j); 
                    i += words[j].length(); 
                    break;
                }
            }
        }

        return Long.parseLong(result.toString());
    }
}
