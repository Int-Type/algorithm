import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;
    private static List<Integer>[] list;
    private static boolean[] visited;
    private static boolean found;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        visited = new boolean[N];
        found = false;
        for (int i = 0; i < N; i++) {
            dfs(i, 1);
            if (found) break;
        }
        System.out.println(found ? 1 : 0);
    }

    private static void dfs(int node, int cnt) {
        if (cnt == 5) {
            found = true;
            return;
        }

        visited[node] = true;
        for (int next : list[node]) {
            if (!visited[next]) {
                dfs(next, cnt + 1);
                if (found) return;
            }
        }
        visited[node] = false;
    }
}
