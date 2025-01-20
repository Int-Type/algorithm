class Solution {
    public int[] solution(String my_string) {
        int[] count = new int[52]; 

        for (char ch : my_string.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                count[ch - 'A']++;
            } else if (Character.isLowerCase(ch)) {
                count[ch - 'a' + 26]++;
            }
        }

        return count;
    }
}
