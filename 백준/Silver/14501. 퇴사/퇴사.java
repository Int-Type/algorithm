import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int max, N;
    private static int[] T, P;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        T = new int[N];
        P = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }
        max = 0;

        dfs(0, 0);
        System.out.println(max);
    }

    private static void dfs(int day, int sum) {
        if (day >= N) {
            max = Math.max(max, sum);
            return;
        }

        if (day + T[day] <= N) {
            dfs(day + T[day], sum + P[day]);
        }

        dfs(day + 1, sum);
    }
}
