import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Coordinate {
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static int N, M, result;
    private static int[][] map;
    private static List<Coordinate> virus;
    private static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        virus = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                map[i][j] = num;
                if (num == 2) virus.add(new Coordinate(i, j));
            }
        }

        dfs(0);
        System.out.println(result);
    }

    private static void dfs(int cnt) {
        if (cnt == 3) {
            simulate();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(cnt + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void simulate() {
        int[][] copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            copyMap[i] = map[i].clone();
        }

        Queue<Coordinate> queue = new ArrayDeque<>();

        for (Coordinate temp : virus) {
            queue.add(temp);
        }

        while (!queue.isEmpty()) {
            Coordinate temp = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nr = temp.x + delta[i][0];
                int nc = temp.y + delta[i][1];
                if (isRange(nr, nc)) {
                    if (copyMap[nr][nc] == 0) {
                        copyMap[nr][nc] = 2;
                        queue.add(new Coordinate(nr, nc));
                    }
                }
            }
        }
        int safeCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] == 0) {
                    safeCnt++;
                }
            }
        }
        result = Math.max(result, safeCnt);
    }

    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < M;
    }
}
