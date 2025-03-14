import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Coordinate {
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static int M, N, K;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}}; // 상, 하, 좌, 우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[M][N];

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[x][y] = 1;
            }

            visited = new boolean[M][N];
            int cnt = 0;

            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        needEarthworm(new Coordinate(i, j));
                        cnt++;
                    }
                }
            }
            System.out.println(cnt);
        }
    }

    private static void needEarthworm(Coordinate temp) {
        Queue<Coordinate> queue = new ArrayDeque<>();
        queue.add(temp);

        while (!queue.isEmpty()) {
            Coordinate cabbage = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = cabbage.x + delta[i][0];
                int nc = cabbage.y + delta[i][1];

                if (isRange(nr, nc) && !visited[nr][nc] && map[nr][nc] == 1) {
                    visited[nr][nc] = true;
                    queue.add(new Coordinate(nr, nc));
                }
            }
        }
    }

    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < M && nc >= 0 && nc < N;
    }
}
