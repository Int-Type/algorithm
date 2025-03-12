import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int R, C, K, result;
    private static char[][] map;
    private static final int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}}; // 상, 하, 좌, 우
    private static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 1. 첫 줄에 정수 R, C, K 입력 받기
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];
        result = 0;

        // 2. R x C 맵 정보 입력받기
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        // 시작 지점 : 왼쪽 아래점 : R - 1, 0 / 목표 지점 : 오른쪽 위 : 0, C - 1
        // 3. 시작 지점부터 탐색 시작
        visited[R-1][0] = true;
        move(R - 1, 0, 1);

        // 4. 결과 출력
        System.out.println(result);
    }
    
    private static void move(int x, int y, int cnt) {
        if (x == 0 && y == C - 1) {
            // 3-3. K번 만큼 이동했을 때, 목표지점이라면 result++;
            if (cnt == K) result++;
            return;
        }

        // 3-1. 사방탐색을 진행
        for (int i = 0; i < 4; i++) {
            int nr = x + delta[i][0];
            int nc = y + delta[i][1];

            // 3-2. 범위를 벗어나지 않고, 방문을 하지 않았고, T가 아니라면 방문처리 후 계속 이동
            if (isRange(nr, nc) && !visited[nr][nc] && map[nr][nc] != 'T') {
                visited[nr][nc] = true;
                move(nr, nc, cnt + 1);
                visited[nr][nc] = false;
            }
        }
    }

    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < R && nc >= 0 && nc < C;
    }
}
