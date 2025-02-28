import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n, m;
    private static int[][] map, prefixSum;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeList();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            // index 값을 위해 각 값들에 -1
            sum(x1 - 1, y1 - 1, x2 - 1, y2 - 1);
        }
        br.close();
        System.out.println(sb);
    }

    // 누적합 2차원 배열 생성
    private static void makeList() {
        prefixSum = new int[n][n];

        // 누적합 2차원 배열에 첫번째 값들을 map 첫번째 값으로 설정
        for (int i = 0; i < n; i++) {
            prefixSum[i][0] = map[i][0];
        }

        // 각 배열마다 누적합 계산 후 저장
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                prefixSum[i][j] = prefixSum[i][j - 1] + map[i][j];
            }
        }
    }

    private static void sum(int x1, int y1, int x2, int y2) {
        int total = 0;

        // 만약 y1 (시작점)의 전값이 0보다 크거나 같다면 [i][y2]번째 누적합에서 [i][y-1]번째 누적합의 값을 뺌
        if (y1 - 1 >= 0) {
            for (int i = x1; i <= x2; i++) {
                total += prefixSum[i][y2] - prefixSum[i][y1 - 1];
            }
            // 만약 y1 (시작점)의 전값이 0보다 작다면 그 전 누적값이 존재하지 않기 때문에 누적합만 계산
        } else {
            for (int i = x1; i <= x2; i++) {
                total += prefixSum[i][y2];
            }
        }
        sb.append(total).append("\n");
    }
}
