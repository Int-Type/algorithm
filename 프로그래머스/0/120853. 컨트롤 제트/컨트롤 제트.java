import java.util.Stack;

class Solution {
    public int solution(String s) {
        String[] tokens = s.split(" "); 
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("Z")) {
                if (!stack.isEmpty()) {
                    stack.pop(); 
                }
            } else {
                stack.push(Integer.parseInt(token)); 
            }
        }

        return stack.stream().mapToInt(Integer::intValue).sum();
    }
}
