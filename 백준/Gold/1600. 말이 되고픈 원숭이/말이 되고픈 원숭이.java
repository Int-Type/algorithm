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
        int jump;
        public Coordinate(int x, int y, int jump) {
            this.x = x;
            this.y = y;
            this.jump = jump;
        }
    }
    private static int K, W, H;
    private static int[][] map;
    private static boolean[][][] visited;
    private static final int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}}; // 상, 하, 좌, 우
    private static final int[][] horse = {{-1,2},{-2,1},{-2,-1},{-1,-2},{1,2},{2,1},{2,-1},{1,-2}}; // 왼쪽부터 시계방향으로
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 정수 K 입력받기.
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 2. 가로길이 W, 세로길이 H 입력받기
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H][W];
        visited = new boolean[H][W][K + 1];

        // 3. 격자판 정보 입력받기
        // 3-1. 0은 평지, 1은 장애물
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 5. 맨 왼쪽 위에서 시작, 맨 오른쪽 아래 도착, 최소한의 동작으로 갈 수 있는 방법 완성, 갈 수 없을 경우 -1 출력
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

                if (temp.x == H - 1 && temp.y == W - 1) return cnt;

                // 4. 원숭이는 말의 이동방법을 총 K번만큼만 사용 할 수 있음
                if (temp.jump < K) {
                    for (int j = 0; j < 8; j++) {
                        int nr = temp.x + horse[j][0];
                        int nc = temp.y + horse[j][1];

                        if (isRange(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc][temp.jump + 1]) {
                            visited[nr][nc][temp.jump + 1] = true;
                            queue.add(new Coordinate(nr, nc, temp.jump + 1));
                        }
                    }
                }

                // 4-1. 그 외에는 인접한 방향으로 한칸 이동
                for (int j = 0; j < 4; j++) {
                    int nr = temp.x + delta[j][0];
                    int nc = temp.y + delta[j][1];

                    if (isRange(nr, nc) && map[nr][nc] == 0 && !visited[nr][nc][temp.jump]) {
                        visited[nr][nc][temp.jump] = true;
                        queue.add(new Coordinate(nr, nc, temp.jump));
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < H && nc >= 0 && nc < W;
    }
}