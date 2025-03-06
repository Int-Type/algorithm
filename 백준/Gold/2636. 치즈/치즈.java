import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int c;
    private static int r;
    private static int before;
    private static int[][] map;
    private static boolean[][] visited;
    private static Queue<Cheese> check, changeC;
    public static final int[][] DELTA = {{-1,0},{1,0},{0,-1},{0,1}}; // 상, 하, 좌, 우
    static class Cheese {
        int x;
        int y;

        public Cheese(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        map = new int[c][r];
        for (int i = 0; i < c; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < r; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check = new ArrayDeque<>();
        changeC = new ArrayDeque<>();
        int time = 0;
        before = 0;

        while (true) {
            visited = new boolean[c][r];
            check.add(new Cheese(0,0));
            visited[0][0] = true;
            boolean can = search();
            if (!can) break;
            melting();
            time++;
        }

        System.out.println(time);
        System.out.println(before);
    }

    private static void melting() {
        while (!changeC.isEmpty()) {
            Cheese temp = changeC.poll();
            map[temp.x][temp.y] = 0;
        }
    }

    private static boolean search() {
        int cnt = 0;
        while (!check.isEmpty()) {
            Cheese temp = check.poll();

            for (int[] delta : DELTA) {
                int nr = temp.x + delta[0];
                int nc = temp.y + delta[1];

                if (isRange(nr, nc) && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    if (map[nr][nc] == 0) {
                        check.add(new Cheese(nr, nc));
                    } else if (map[nr][nc] == 1) {
                        changeC.add(new Cheese(nr, nc));
                        cnt++;
                    }
                }
            }
        }
        if (cnt != 0) {
            before = cnt;
            return true;
        }
        return false;
    }

    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < c && nc >= 0 && nc < r;
    }
}
