import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new boolean[n + 1];

        ArrayList<Integer>[] lists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lists[x].add(y);
            lists[y].add(x);
        }

        int cnt = 0;

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                bfs(lists, i);
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static void bfs(ArrayList<Integer>[] lists, int n) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(n);
        visited[n] = true;

        while (!queue.isEmpty()) {
            int temp = queue.poll();

            for (int next : lists[temp]) {
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
    }

}
