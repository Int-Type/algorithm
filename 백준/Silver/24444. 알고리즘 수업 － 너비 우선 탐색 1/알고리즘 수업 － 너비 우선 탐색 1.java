import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

        list = new List[N + 1];
        visited = new boolean[N + 1];
        result = new int[N + 1];

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
            Collections.sort(integers);
        }

        order = 1;
        bfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(result[i]);
        }
    }

    private static void bfs(int R) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.addAll(list[R]);
        visited[R] = true;
        result[R] = order++;

        while (!queue.isEmpty()) {
            int n = queue.poll();

            if (!visited[n]) {
                visited[n] = true;
                result[n] = order++;
                queue.addAll(list[n]);
            }
        }
    }
}
