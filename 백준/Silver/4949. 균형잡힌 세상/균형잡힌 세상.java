import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line.equals(".")) break;

            System.out.println(isBalanced(line) ? "yes" : "no");
        }
    }

    public static boolean isBalanced(String str) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[') {
                stack.addLast(c);
            }
            else if (c == ')') {
                if (stack.isEmpty() || stack.peekLast() != '(') return false;
                stack.removeLast();
            }
            else if (c == ']') {
                if (stack.isEmpty() || stack.peekLast() != '[') return false;
                stack.removeLast();
            }
        }

        return stack.isEmpty();
    }
}
