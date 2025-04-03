import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    static class Coordinate{
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static int N, K, result;
    private static int[][] map;
    private static boolean[][] visited;
    private static final int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 1. 총 테스트 케이스의 개수 T 입력 받기
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 2. 지도의 한변의 길이 N, 최대 공사 가능 깊이 K 입력받기
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            visited = new boolean[N][N];
            List<Coordinate> mountaintop = new ArrayList<>();
            int max = Integer.MIN_VALUE;

            // 3. 지도의 정보 입력받기
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    map[i][j] = num;
                    // 3-1. 최대 봉우리 정보를 저장하기 위해 num이 max보다 크다면 max의 값을 변경해주고 저장했던 봉우리 목록 초기화 후 저장
                    if (num > max) {
                        max = num;
                        mountaintop.clear();
                        mountaintop.add(new Coordinate(i, j));
                    }
                    // 3-2. 최대 봉우리 높이와 같다면 위치 저장
                    if (num == max) mountaintop.add(new Coordinate(i, j));
                }
            }

            result = Integer.MIN_VALUE;

            // 4. 최대 봉우리를 시작점으로 산책로 탐색
            for (Coordinate temp : mountaintop) {
                visited[temp.x][temp.y] = true;
                dfs(temp.x, temp.y, 1, false);
                visited[temp.x][temp.y] = false;
            }
            // 5. 해당 테스트 케이스의 최대 산책로 길이 저장
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }
        // 6. 저장된 결과 출력
        System.out.println(sb);
    }

    private static void dfs(int x, int y, int length, boolean useDig) {
        //
        if (length > result) result = length;

        // 4-1. 시작 봉우리에서 4방탐색 진행
        for (int i = 0; i < 4; i++) {
            int nr = x + delta[i][0];
            int nc = y + delta[i][1];

            // 4-2. 지도의 범위 안에 있고 방문하지 않았을 때
            if (isRange(nr, nc) && !visited[nr][nc]) {
                // 4-3. 지금 위치가 다음 위치보다 높은 위치라면
                if (map[x][y] > map[nr][nc]) {
                    visited[nr][nc] = true;
                    dfs(nr, nc, length + 1, useDig);
                    visited[nr][nc] = false;
                } else if (!useDig) { // 4-4. 지금 위치가 다음 위치보다 같거나 낮은 위치인데 지형을 깍지 않았다면
                    for (int j = 1; j <= K; j++) { // 4-5. 1~K까지 지형의 위치를 깍아주기
                        if (map[x][y] > map[nr][nc] - j) {
                            // 기존의 지형 저장
                            int original = map[nr][nc];
                            // 이동할 위치의 지형의 값을 변경
                            map[nr][nc] = map[nr][nc] - j;
                            visited[nr][nc] = true;
                            dfs(nr, nc, length + 1, true);
                            // 원상복구
                            visited[nr][nc] = false;
                            map[nr][nc] = original;
                        }
                    }
                }
            }
        }
    }

    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < N;
    }
}
