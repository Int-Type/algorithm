import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Stone {
        int number, idx;
        public Stone(int number, int idx) {
            this.number = number;
            this.idx = idx;
        }
    }
    private static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Stone> queue = new ArrayDeque<>();

        int[] list = new int[N];
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            list[i] = num;
        }
        int start = Integer.parseInt(br.readLine()) - 1;
        queue.add(new Stone(list[start], start));
        visited[start] = true;
        int size = 0;
        int[] delta = {-1, 1};
        while (!queue.isEmpty()) {
            Stone temp = queue.poll();

            for (int j : delta) {
                int next = temp.idx + temp.number * j;
                if (isRange(next) && !visited[next]) {
                    visited[next] = true;
                    queue.add(new Stone(list[next], next));
                }
            }
            size++;
        }
        System.out.println(size);
    }

    private static boolean isRange(int n) {
        return n >= 0 && n < N;
    }
}
