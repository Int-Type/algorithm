import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static class Item {
        int weight, value;
        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
    private static int N, K;
    private static Item[] items;
    private static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 1. 물품의 수 N, 버틸 수 있는 무게 K 입력 받기
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        items = new Item[N];
        // 2. N개의 물품들의 무게 W, 가치 V 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            items[i] = new Item(W, V);
        }

        // 3. K + 1의 크기를 가진 배열 생성
        dp = new int[K + 1];

        // 4. 물품들을 하나씩 탐색
        for (int i = 0; i < N; i++) {
            int weight = items[i].weight;
            int value = items[i].value;

            // 5. 물품들이 들어갈 수 있는 경우의 수를 계산, 같은 물품들을 여러번 선택하지 않기 위해 뒤에서부터 탐색
            for (int j = K; j >= weight; j--) {
                // 지금 무게일 때 물품을 넣었을때와 넣지 않았을 때의 값을 비교해서 최댓값을 변경
                dp[j] = Math.max(dp[j], dp[j - weight] + value);
            }
        }
        // 6. 무게가 K일 때의 최댓값 출력
        System.out.println(dp[K]);
    }
}
