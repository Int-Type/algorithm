import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int n, nomalCnt, colorBlindCnt;
    private static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        char[][] normalMap = new char[n][n];
        char[][] colorBlindMap = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                normalMap[i][j] = c;
                if (c == 'G') {
                    colorBlindMap[i][j] = 'R';
                } else {
                    colorBlindMap[i][j] = c;
                }
            }
        }

        nomalCnt = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    view(i, j, normalMap, normalMap[i][j]);
                    nomalCnt++;
                }
            }
        }

        colorBlindCnt = 0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    view(i, j, colorBlindMap, colorBlindMap[i][j]);
                    colorBlindCnt++;
                }
            }
        }

        System.out.println(nomalCnt + " " + colorBlindCnt);
    }
    
    private static void view(int x, int y, char[][] map, char c) {
        if (visited[x][y]) return;

        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nr = x + delta[i][0];
            int nc = y + delta[i][1];

            if (isRange(nr, nc) && !visited[nr][nc] && map[nr][nc] == c) {
                view(nr, nc, map, c);
            }
        }
    }

    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < n && nc >= 0 && nc < n;
    }
}
