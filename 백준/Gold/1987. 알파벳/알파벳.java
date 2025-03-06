import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int r, c, max;
    private static char[][] map;
    private static boolean[] check;
    public static final int[][] DELTA = {{-1,0},{1,0},{0,-1},{0,1}}; // 상, 하, 좌, 우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j);
            }
        }

        max = 0;
        // 지나온 알파벳을 저장할 배열 생성, 좌측 상단 값을 true로 변경
        check = new boolean[26];
        check[map[0][0] - 'A'] = true;

        move(0,0, 1);

        System.out.println(max);
    }

    private static void move(int x, int y, int cnt) {
        if (cnt > max) max = cnt;

        for (int[] delta : DELTA) {
            int nr = x + delta[0];
            int nc = y + delta[1];

            // 범위 안에 해당
            if (isRange(nr, nc)) {
                // 사용하지 않은 알파벳이라면
                if (!check[map[nr][nc] - 'A']) {
                    // true로 변경해주고 재귀 호출
                    check[map[nr][nc] - 'A'] = true;
                    move(nr, nc, cnt + 1);
                    // 원상복구
                    check[map[nr][nc] - 'A'] = false;
                }
            }
        }
    }

    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < r && nc >= 0 && nc < c;
    }
}
