import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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
    private static Coordinate start;
    private static int n, m, max;
    private static boolean[][] visited;
    private static char[][] map;
    private static final int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}}; // 상, 하, 좌, 우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = line.charAt(j);
                map[i][j] = c;
                if (c == 'I') start = new Coordinate(i, j);
            }
        }

        max = 0;
        visited[start.x][start.y] = true;
        dfs(start.x, start.y);

        System.out.println(max > 0 ? max : "TT");
    }

    private static void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nr = x + delta[i][0];
            int nc = y + delta[i][1];

            if (isRange(nr, nc) && !visited[nr][nc] && map[nr][nc] != 'X') {
                visited[nr][nc] = true;
                if (map[nr][nc] == 'P') max++;
                dfs(nr, nc);
            }
        }
    }

    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < n && nc >= 0 && nc < m;
    }
}
