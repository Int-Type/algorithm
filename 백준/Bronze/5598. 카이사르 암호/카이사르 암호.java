import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length();i++) {
            char c = s.charAt(i);

            char move = (char) (c - 3);

            if (move < 'A') {
                move += 26;
            }

            sb.append(move);
        }
        System.out.println(sb);
    }
}
