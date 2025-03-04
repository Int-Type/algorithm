import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[][] map;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        int resultMax = 1;
        for(int i = 0; i < max; i++) {
            visited = new boolean[n][n];
            int result = 0;
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    if(!visited[j][k] && map[j][k] > i) {
                        visited[j][k] = true;
                        result++;
                        search(i, j, k);
                    }
                }
            }

            if(result > resultMax) resultMax = result;
        }
        System.out.println(resultMax);
    }

    private static void search(int check, int x, int y) {
        if(visited[x][y] && map[x][y] <= check) return;

        int[][] delta = {{1,0},{-1,0},{0,1},{0,-1}};

        for(int i = 0; i < 4; i++) {
            int nr = x + delta[i][0];
            int nc = y + delta[i][1];

            if(isRange(nr, nc) && !visited[nr][nc] && map[nr][nc] > check) {
                visited[nr][nc] = true;
                search(check, nr, nc);
            }
        }
    }

    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < n && nc >= 0 && nc < n;
    }
}
