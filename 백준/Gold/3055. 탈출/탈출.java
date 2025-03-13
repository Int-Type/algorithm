import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Coordinate{
        int x;
        int y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static int R, C;
    private static char[][] map;
    private static Queue<Coordinate> waterQueue;
    private static Coordinate hedgehog;
    private static int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}}; // 상, 하, 좌, 우
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];

        waterQueue = new ArrayDeque<>();

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                char c = line.charAt(j);
                if (c == '*') waterQueue.add(new Coordinate(i,j));
                if (c == 'S') {
                    hedgehog = new Coordinate(i, j);
                    c = '.';
                }
                map[i][j] = c;
            }
        }

        int cnt = move();

        if (cnt == -1) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(cnt);
        }

    }

    private static void expansionWater() {
        int size = waterQueue.size();
        Queue<Coordinate> nextQueue = new ArrayDeque<>();

        for (int i = 0; i < size; i++) {
            Coordinate temp = waterQueue.poll();

            for (int j = 0; j < 4; j++) {
                int nr = temp.x + delta[j][0];
                int nc = temp.y + delta[j][1];

                if (isRange(nr, nc) && map[nr][nc] == '.') {
                    map[nr][nc] = '*';
                    nextQueue.add(new Coordinate(nr, nc));
                }
            }
        }
        waterQueue.addAll(nextQueue);
    }

    private static int move() {
        Queue<Coordinate> moveList = new ArrayDeque<>();
        moveList.add(hedgehog);

        boolean[][] visited = new boolean[R][C];
        visited[hedgehog.x][hedgehog.y] = true;

        int cnt = 0;

        while (!moveList.isEmpty()) {

            int size = moveList.size();
            expansionWater();

            for (int i = 0; i < size; i++) {
                Coordinate temp = moveList.poll();

                if (map[temp.x][temp.y] == 'D') return cnt;

                for (int j = 0; j < 4; j++) {
                    int nr = temp.x + delta[j][0];
                    int nc = temp.y + delta[j][1];

                    if (!isRange(nr, nc) || visited[nr][nc]) continue;
                    if (map[nr][nc] == 'X' || map[nr][nc] == '*') continue;
                    if (map[nr][nc] == 'D') return cnt + 1;

                    visited[nr][nc] = true;
                    moveList.add(new Coordinate(nr, nc));
                }
            }
            cnt++;
        }
        return -1;
    }

    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < R && nc >= 0 && nc < C;
    }
}
