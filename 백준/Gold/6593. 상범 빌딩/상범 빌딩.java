import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static class Coordinate {
        int x, y, z;
        public Coordinate(int z, int x, int y) {
            this.z = z;
            this.x = x;
            this.y = y;
        }
    }
    private static int L, R, C;
    private static char[][][] map;
    private static Coordinate people, exit;
    private static boolean[][][] visited;
    private static int[][] delta = {{0,0,1},{0,0,-1},{0,1,0},{0,-1,0},{1,0,0},{-1,0,0}}; //동서남북상하
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) break;

            map = new char[L][R][C];
            visited = new boolean[L][R][C];

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String line = br.readLine();
                    for (int k = 0; k < C; k++) {
                        char c = line.charAt(k);
                        if (c == 'S') {
                            people = new Coordinate(i, j, k);
                            c = '.';
                        }
                        if (c == 'E') {
                            exit = new Coordinate(i, j, k);
                            c = '.';
                        }
                        map[i][j][k] = c;
                    }
                }
                String line = br.readLine();
            }
            int cnt = bfs();
            if (cnt == -1) {
                sb.append("Trapped!").append("\n");
            } else {
                sb.append("Escaped in ").append(cnt).append(" minute(s).").append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int bfs() {
        Queue<Coordinate> queue = new ArrayDeque<>();
        queue.add(people);
        visited[people.z][people.x][people.y] = true;

        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Coordinate temp = queue.poll();

                if (temp.z == exit.z && temp.x == exit.x && temp.y == exit.y) return cnt;

                for (int j = 0; j < 6; j++) {
                    int nz = temp.z + delta[j][0];
                    int nr = temp.x + delta[j][1];
                    int nc = temp.y + delta[j][2];

                    if (isRange(nz, nr, nc) && !visited[nz][nr][nc] && map[nz][nr][nc] == '.') {
                        visited[nz][nr][nc] = true;
                        queue.add(new Coordinate(nz, nr, nc));
                    }
                }
            }
            cnt++;
        }
        return -1;
    }

    private static boolean isRange(int nz, int nr, int nc) {
        return nz >= 0 && nz < L && nr >= 0 && nr < R && nc >= 0 && nc < C;
    }
}
