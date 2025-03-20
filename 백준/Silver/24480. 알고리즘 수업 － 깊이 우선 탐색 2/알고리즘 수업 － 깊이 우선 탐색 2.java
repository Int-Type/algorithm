import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, M, order;
    private static int[] result;
    private static boolean[] visited;
    private static List<Integer>[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        result = new int[N + 1];

        list = new List[N + 1];
        for (int i = 0; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        for (List<Integer> integers : list) {
            integers.sort(Collections.reverseOrder());
        }

        order = 1;
        dfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(result[i]);
        }
    }

    private static void dfs(int idx) {
        visited[idx] = true;
        result[idx] = order++;
        for (int next : list[idx]) {
            if (!visited[next]){
                dfs(next);
            }
        }
    }
}
