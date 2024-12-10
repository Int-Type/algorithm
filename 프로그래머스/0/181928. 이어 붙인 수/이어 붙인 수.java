class Solution {
    public int solution(int[] num_list) {
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        
        for (int i : num_list) {
            if (i % 2 == 0) {
                even.append(i);
            } else {
                odd.append(i);
            }
        }
        
        int oddNum = Integer.parseInt(odd.toString());
        int evenNum = Integer.parseInt(even.toString());
        
        return oddNum + evenNum;
    }
}