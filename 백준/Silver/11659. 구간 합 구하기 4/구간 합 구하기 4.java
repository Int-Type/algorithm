import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[] arr, prefixSum;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        makeList();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            // 만약 x와 y가 같다면 누적합 배열이 아닌 입력받았던 배열에서 값을 sb에 저장
            if (x == y) {
                sb.append(arr[x - 1]).append(" ");
            } else {
                // index 값을 위해 x와 y에서 -1
                sum(x - 1, y - 1);
            }
        }

        br.close();
        System.out.println(sb);
    }

    // 누적합 배열 생성
    private static void makeList() {
        prefixSum = new int[n];
        // 첫번째 값은 누적합 적용 x
        prefixSum[0] = arr[0];
        // 누적합의 전 값 + arr[i]번째의 값
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i];
        }
    }

    private static void sum(int x, int y) {
        int total = prefixSum[y];
        // x가 0이 아니면 기존 누적합 - 바로 전 누적합
        if (x != 0) total -= prefixSum[x - 1];
        sb.append(total).append("\n");
    }
}
