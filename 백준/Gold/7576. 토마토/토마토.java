import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 1. 상자의 크기를 나타내는 두 정수 M, N 입력받기
// 2, 상자에 저장된 토마토 정보 입력받기, 익은 토마토 : 1, 익지 않은 토마토 : 0, 토마토가 들어있지 않은 칸 : -1
// 3. 보관 후 하루가 지나면 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들이 익은 토마토의 영향을 받아 익게 된다.
// 3-1. 하나의 토마토의 인접한 곳은 왼쪽,오른쪽,앞,뒤 네 방향에 있는 토마토를 의미한다.
// 3-2. 대각선 방향은 영향 x, 토마토가 혼자 저절로 익는 경우x
// 4. 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 최소 일수 구하기

public class Main {
    static class Coordinate{
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static int M, N;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}}; // 상, 하, 좌, 우
    private static Queue<Coordinate> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 1. 상자의 크기를 나타내는 두 정수 M, N 입력받기
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];
        queue = new ArrayDeque<>();
        boolean allRipe = true;
        // 2, 상자에 저장된 토마토 정보 입력받기, 익은 토마토 : 1, 익지 않은 토마토 : 0, 토마토가 들어있지 않은 칸 : -1
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) queue.add(new Coordinate(i, j));
                if (map[i][j] == 0) allRipe = false;
                if (map[i][j] == -1) visited[i][j] = true;
            }
        }

        int cnt = 0;
        if (allRipe) {
            System.out.println(0);
            return;
        } else {
            cnt = bfs();
        }
        // 4. 창고에 보관된 토마토들이 며칠이 지나면 다 익게 되는지, 최소 일수 구하기
        System.out.println(cnt);
    }

    // 3. 보관 후 하루가 지나면 익은 토마토들의 인접한 곳에 있는 익지 않은 토마토들이 익은 토마토의 영향을 받아 익게 된다.
    private static int bfs() {
        int cnt = -1;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Coordinate temp = queue.poll();

                if (map[temp.x][temp.y] == 1 && !visited[temp.x][temp.y]) {
                    visited[temp.x][temp.y] = true;

                    for (int j = 0; j < 4; j++) {
                        int nr = temp.x + delta[j][0];
                        int nc = temp.y + delta[j][1];

                        if (isRange(nr, nc) && map[nr][nc] == 0) {
                            map[nr][nc] = 1;
                            queue.add(new Coordinate(nr, nc));
                        }
                    }
                }
            }
            cnt++;
        }
        // 3-1. 하나의 토마토의 인접한 곳은 왼쪽,오른쪽,앞,뒤 네 방향에 있는 토마토를 의미한다.
        // 3-2. 대각선 방향은 영향 x, 토마토가 혼자 저절로 익는 경우x
        if (allRipe()) return cnt;
        // 토마토가 모두 익지는 못하는 상황이라면 -1 출력
        return -1;
    }

    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < M;
    }

    private static boolean allRipe() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) return false;
            }
        }
        return true;
    }
}


