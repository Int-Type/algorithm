import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] s, b;
    private static int n, min;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        s = new int[n];
        b = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
        }
        makeFood(0, 1, 0, 0);
        sb.append(min);
        System.out.println(sb);
    }

    private static void makeFood(int cnt, int sumS, int sumB, int useCnt) {
        // 신맛과 쓴맛의 차를 구하고 절대값으로 바꾼 뒤 min 보다 작으면 값 변경
        // 단, 재료를 1개 이상 사용해야 함
        if (cnt == n) {
            if (Math.abs(sumS - sumB) < min && useCnt > 0) min = Math.abs(sumS - sumB);
            return;
        }
        makeFood(cnt + 1, sumS * s[cnt], sumB + b[cnt], useCnt + 1);
        makeFood(cnt + 1, sumS, sumB, useCnt);
    }
}
