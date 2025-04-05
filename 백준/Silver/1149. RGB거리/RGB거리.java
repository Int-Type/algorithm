import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int[][] dp;
    private static int[][] prices;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        prices = new int[N + 1][3];
        dp = new int[N + 1][3];
        dp[0][0] = 0;
        dp[0][1] = 0;
        dp[0][2] = 0;

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            prices[i][0] = Integer.parseInt(st.nextToken());
            prices[i][1] = Integer.parseInt(st.nextToken());
            prices[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + prices[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + prices[i][1];
            dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]) + prices[i][2];
        }
        int result = Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2]));
        System.out.println(result);
    }
}
