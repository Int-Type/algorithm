import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

class Solution
{
    private static ArrayDeque<Character> stack;
    private static StringBuilder sb;
	public static void main(String args[]) throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        for (int tc = 0; tc < 10; tc++) {
            int n = Integer.parseInt(br.readLine());
            stack = new ArrayDeque<>();
            // 유효한 문자열인지 확인할 boolean 변수
            boolean isTrue = true;
            String s = br.readLine();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                // 괄호 문자 앞 부분들이면 stack에 push
                if (c == '(' || c == '[' || c == '{' || c == '<') {
                    stack.push(c);
                } else {
                    // 괄호 문자 뒷 부분인데 stack이 비어있으면 false, for문 종료
                    if (stack.isEmpty()) {
                        isTrue = false;
                        break;
                    }

                    // stack에 저장되어 있는 값을 꺼내서 입력받은 c와 페어를 이루는지 확인
                    char top = stack.pop();
                    if (!isPair(top, c)) {
                        // 페어가 아니라면 false, for문 종료
                        isTrue = false;
                        break;
                    }
                }
            }

            // 스택이 비어있지 않다면 유효한 문자열이 아니기 때문에 false
            if (!stack.isEmpty()) isTrue = false;

            // isTrue가 true면 1, false면 0
            sb.append("#").append(tc + 1).append(" ").append(isTrue ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }

    // 각 괄호가 페어가 맞는지 확인
    private static boolean isPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '[' && close == ']') ||
                (open == '{' && close == '}') ||
                (open == '<' && close == '>');
    }
}

