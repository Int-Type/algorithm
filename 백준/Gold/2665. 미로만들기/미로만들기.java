import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    static class Coordinate{
        int x,y,change;
        public Coordinate(int x, int y, int change) {
            this.x = x;
            this.y = y;
            this.change = change;
        }
    }
    private static int n, cnt, max;
    private static int[][] map;
    private static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n][50*50 + 1];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
                if(map[i][j] == 0) max++;
            }
        }

        bfs();
        System.out.println(cnt);
    }


    private static void bfs() {
        cnt = Integer.MAX_VALUE;
        Queue<Coordinate> queue = new ArrayDeque<>();
        visited[0][0][map[0][0]] = true;
        queue.add(new Coordinate(0,0,map[0][0] == 0 ? 1 : 0));

        int[][] delta = {{-1,0},{1,0},{0,-1},{0,1}};

        while (!queue.isEmpty()) {
            Coordinate temp = queue.poll();

            if (temp.x == n - 1 && temp.y == n - 1) {
                if (temp.change < cnt) cnt = temp.change;
            }

            for (int i = 0; i < 4; i++) {
                int nr = temp.x + delta[i][0];
                int nc = temp.y + delta[i][1];

                if (isRange(nr, nc) && !visited[nr][nc][temp.change] && temp.change < max) {
                    if (map[nr][nc] == 0) {
                        if (!visited[nr][nc][temp.change + 1]) {
                            queue.add(new Coordinate(nr, nc, temp.change + 1));
                            visited[nr][nc][temp.change + 1] = true;
                        }
                    } else {
                        queue.add(new Coordinate(nr, nc, temp.change));
                        visited[nr][nc][temp.change] = true;
                    }
                }
            }
        }

        if (cnt == Integer.MAX_VALUE) cnt = 0;
    }

    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < n && nc >= 0 && nc < n;
    }
}
