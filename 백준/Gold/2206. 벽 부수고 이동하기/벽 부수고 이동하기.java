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
        int broken;
        public Coordinate(int x, int y, int broken) {
            this.x = x;
            this.y = y;
            this.broken = broken;
        }
    }
    private static int N, M;
    private static int[][] map;
    private static boolean[][][] visited;
    private static final int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}}; // 상, 하, 좌, 우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = line.charAt(j);
                map[i][j] = Integer.parseInt(String.valueOf(c));
            }
        }
        System.out.println(bfs());
    }

    private static int bfs() {
        Queue<Coordinate> queue = new ArrayDeque<>();
        queue.add(new Coordinate(0,0,0));
        visited[0][0][0] = true;

        int cnt = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Coordinate temp = queue.poll();

                if (temp.x == N - 1 && temp.y == M - 1) return cnt + 1;

                if (temp.broken < 1) {
                    for (int j = 0; j < 4; j++) {
                        int nr = temp.x + delta[j][0];
                        int nc = temp.y + delta[j][1];

                        if (isRange(nr, nc) && map[nr][nc] == 1 && !visited[nr][nc][temp.broken + 1]) {
                            visited[nr][nc][temp.broken + 1] = true;
                            queue.add(new Coordinate(nr, nc, temp.broken + 1));
                        }
                    }
                }

                for (int j = 0; j < 4; j++) {
                    int nr = temp.x + delta[j][0];
                    int nc = temp.y + delta[j][1];

                    if (isRange(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc][temp.broken]) {
                        visited[nr][nc][temp.broken] = true;
                        queue.add(new Coordinate(nr, nc, temp.broken));
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < M;
    }
}
