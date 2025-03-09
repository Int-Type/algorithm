class Solution {
    public String solution(String myString, String pat) {
        int lastIdx = myString.lastIndexOf(pat);
        return myString.substring(0, lastIdx + pat.length());
    }
}