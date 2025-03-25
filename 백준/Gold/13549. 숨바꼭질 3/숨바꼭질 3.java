import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Move {
        int x, second;
        public Move(int x, int second) {
            this.x = x;
            this.second = second;
        }
    }
    private static int N, K, min;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];
        min = Integer.MAX_VALUE;
        System.out.println(bfs());
    }

    private static int bfs() {
        Deque<Move> queue = new ArrayDeque<>();
        queue.add(new Move(N, 0));
        int cnt = 0;
        while (!queue.isEmpty()) {
            Move n = queue.poll();

            if (isRange(n.x) && !visited[n.x]) {
                if (n.x == K) return n.second;
                visited[n.x] = true;

                int n1 = n.x - 1;
                int n2 = n.x + 1;
                int n3 = n.x * 2;

                if (isRange(n1)) queue.addLast(new Move(n1, n.second + 1));
                if (isRange(n2)) queue.addLast(new Move(n2, n.second + 1));
                if (isRange(n3)) queue.addFirst(new Move(n3, n.second));
            }
        }
        return cnt;
    }

    private static boolean isRange(int x) {
        return x >= 0 && x < 100001;
    }
}
