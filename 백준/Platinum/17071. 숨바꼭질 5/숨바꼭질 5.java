import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int N, K, time;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[500001][2];

        if (N == K) {
            System.out.println(0);
            return;
        }

        if (bfs()) {
            System.out.println(time);
        } else {
            System.out.println(-1);
        }
    }

    private static boolean bfs() {
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(N);
        visited[N][0] = true;
        time = 0;

        while (!queue.isEmpty()) {
            time++;
            K = K + time;
            if (K > 500000) return false;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int num = queue.poll();

                int[] nexts = new int[]{num - 1, num + 1, num * 2};

                for (int next : nexts) {
                    if (isRange(next) && !visited[next][time % 2]) {
                        visited[next][time % 2] = true;
                        queue.add(next);
                    }
                }
            }
            if (visited[K][time % 2]) return true;
        }
        return false;
    }

    private static boolean isRange(int n) {
        return n >= 0 && n <= 500000;
    }
}
