import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String S, T;
    private static boolean result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        T = br.readLine();

        result = false;
        dfs(T);
        System.out.println(result ? 1 : 0);
    }

    private static void dfs(String now) {
        if (result) return;
        if (now.length() == S.length()) {
            if (now.equals(S)) result = true;
            return;
        }

        if (now.endsWith("A")) dfs(now.substring(0, now.length() - 1));

        if (now.startsWith("B")) {
            StringBuilder sb = new StringBuilder(now).reverse();
            dfs(sb.substring(0, sb.length() - 1));
        }
    }
}
