class Solution {
    public int solution(String A, String B) {
        if (A.equals(B)) {
            return 0;
        }

        String rotated = A;
        for (int i = 1; i < A.length(); i++) {
            rotated = rotated.charAt(rotated.length() - 1) + rotated.substring(0, rotated.length() - 1);
            if (rotated.equals(B)) {
                return i;
            }
        }
        
        return -1;
    }
}
