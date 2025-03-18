import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            num = 0;
            dfs(0, n, 0);
            sb.append(num).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int total, int idx, int cnt) {
        if (total == idx) {
            num++;
            return;
        }

        if (total > idx) return;

        dfs(total + 1, idx, cnt + 1);
        dfs(total + 2, idx, cnt + 1);
        dfs(total + 3, idx, cnt + 1);
    }
}
