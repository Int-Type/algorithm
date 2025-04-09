import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Coordinate {
        int x, y, broken, status;
        public Coordinate(int x, int y, int broken, int status) {
            this.x = x;
            this.y = y;
            this.broken = broken;
            this.status = status;
        }
    }
    private static int N, M, K, cnt;
    private static int[][] map;
    private static boolean[][][][] visited;
    private static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 1. N, M, K 입력받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        // 2. N x M 크기의 지도 정보 입력받기
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }
        // 3. 최단거리로 탈출할 수 있는지 확인
        if (bfs()) {
            // 3-1. 탈출할 수 있으면 최단거리 출력
            System.out.println(cnt);
        } else {
            // 3-2. 탈출하지 못하면 -1 출력
            System.out.println(-1);
        }
    }

    // 최단거리 탈출 탐색
    private static boolean bfs() {
        Queue<Coordinate> queue = new ArrayDeque<>();
        // 시작점 0,0, 벽 부순 횟수 0, 낮 정보를 큐에 저장하고 방문처리
        visited = new boolean[N][M][K + 1][2];
        queue.add(new Coordinate(0,0,0, 0));
        visited[0][0][0][0] = true;

        cnt = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Coordinate temp = queue.poll();
                // N,M 도착하면 종료
                if (temp.x == N - 1 && temp.y == M - 1) return true;

                // 4방탐색 진행
                for (int j = 0; j < 4; j++) {
                    int nr = temp.x + delta[j][0];
                    int nc = temp.y + delta[j][1];

                    // 범위 밖이면 pass
                    if (!isRange(nr, nc)) continue;

                    // 이동 가능한 빈칸이면 이동
                    if (map[nr][nc] == 0 && !visited[nr][nc][temp.broken][getReverse(temp.status)]) {
                        visited[nr][nc][temp.broken][getReverse(temp.status)] = true;
                        queue.add(new Coordinate(nr, nc, temp.broken, getReverse(temp.status)));
                    }

                    // 벽이지만 벽을 부실 수 있는 횟수가 남아있고 낮이라면 부시고 이동
                    if (map[nr][nc] == 1 && temp.status == 0 && temp.broken < K && !visited[nr][nc][temp.broken + 1][1]) {
                        visited[nr][nc][temp.broken + 1][1] = true;
                        queue.add(new Coordinate(nr, nc, temp.broken + 1, 1));
                    }
                }
                // 사방이 벽이고 밤이라 부시지 못하는 경우, 그 자리에서 기다리기
                if (temp.status == 1 && !visited[temp.x][temp.y][temp.broken][0]) {
                    visited[temp.x][temp.y][temp.broken][0] = true;
                    queue.add(new Coordinate(temp.x, temp.y, temp.broken, 0));
                }
            }
            cnt++;
        }
        // 목표에 도달하지 못했다면 false return
        return false;
    }

    // 상태(낮, 밤) 바꾸는 메서드
    private static int getReverse(int n) {
        if (n == 0) return 1;
        return 0;
    }

    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < M;
    }
}