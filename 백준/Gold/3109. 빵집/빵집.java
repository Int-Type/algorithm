import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int r;
    private static int c;
    private static char[][] map;
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        visited = new boolean[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = s.charAt(j);
            }
        }
        int cnt = 0;
        for (int i = 0; i < r; i++) {
            if (move(i,0)) cnt++;
        }
        System.out.println(cnt);
    }

    private static boolean move(int x, int y) {
        // 마지막 지점에 도착했다면 true 리턴
        if (y == c - 1) return true;

        int[][] delta = {{-1,1},{0,1},{1,1}}; //우상, 우, 우하 순

        for (int i = 0; i < 3; i++) {
            int nr = x + delta[i][0];
            int nc = y + delta[i][1];
            if (isRange(nr, nc) && !visited[nr][nc] && map[nr][nc] == '.') {
                visited[nr][nc] = true;
                if (move(nr, nc)) return true; // 재귀로 경로 찾기
            }
        }
        return false; // 경로를 찾지 못하면 false 리턴
    }

    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < r && nc >= 0 && nc < c;
    }
}