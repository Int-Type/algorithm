import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n;
    private static int[] startS = {2, 3, 5, 7};
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            int s = startS[i];
            dfs(s, 1);
        }
        System.out.println(sb);
    }

    private static void dfs(int s, int cnt) {
        if (cnt == n) {
            sb.append(s).append("\n");
            return;
        }

        for (int i = 1; i <= 9; i += 2) {
            int temp = (s * 10) + i;
            if (isPrime(temp)) {
                dfs(temp, cnt + 1);
            }
        }
    }

    private static boolean isPrime(int num) {
        boolean isTrue = false;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                return false;
            } else {
                isTrue = true;
            }
        }
        return isTrue;
    }
}
