import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Coordinate {
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int N, M;
    private static int[][] map, distance;
    private static Queue<Coordinate> queue;
    private static int[][] delta = {{0,1}, {1,0}, {0,-1}, {-1,0}};  // 상, 하, 좌, 우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        distance = new int[N][M];
        queue = new ArrayDeque<>();

        Coordinate target = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int n = Integer.parseInt(st.nextToken());
                if (n == 2) {
                    target = new Coordinate(i, j);  
                    n = 0;  
                }
                map[i][j] = n;
                distance[i][j] = -1; 
            }
        }

        bfs(target.x, target.y);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    System.out.print(0 + " "); 
                } else {
                    System.out.print(distance[i][j] + " ");  
                }
            }
            System.out.println();
        }
    }

    private static void bfs(int startX, int startY) {
        queue.offer(new Coordinate(startX, startY));
        distance[startX][startY] = 0;  

        while (!queue.isEmpty()) {
            Coordinate current = queue.poll();
            int x = current.x;
            int y = current.y;

            for (int i = 0; i < 4; i++) {
                int nx = x + delta[i][0];
                int ny = y + delta[i][1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if (map[nx][ny] == 1 && distance[nx][ny] == -1) {
                        distance[nx][ny] = distance[x][y] + 1;
                        queue.offer(new Coordinate(nx, ny));
                    }
                }
            }
        }
    }
}
