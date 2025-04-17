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
    private static int n;
    private static Coordinate[] list;
    private static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            n = Integer.parseInt(br.readLine());
            list = new Coordinate[n + 2];
            visited = new boolean[n + 2];

            // 0 = 상근이네 집, n + 1 = 페스티벌, 그외 편의점
            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list[i] = new Coordinate(x, y);
            }

            // 집에서 페스티벌까지 편의점을 안들려도 바로 갈 수 있다면 happy 저장 후 종료
            if (manhattan(list[0], list[n + 1]) <= 1000) {
                sb.append("happy").append("\n");
            } else {
                boolean result = bfs();
                if (result) {
                    sb.append("happy").append("\n");
                } else {
                    sb.append("sad").append("\n");
                }
            }
        }
        System.out.println(sb);
    }

    private static boolean bfs() {
        Queue<Coordinate> queue = new ArrayDeque<>();
        queue.add(new Coordinate(list[0].x, list[0].y));
        visited[0] = true;
        
        while (!queue.isEmpty()) {
            Coordinate temp = queue.poll();

            if (temp.x == list[n + 1].x && temp.y == list[n + 1].y) return true;

            for (int i = 1; i < n + 2; i++) {
                if (manhattan(temp, list[i]) <= 1000 && !visited[i]) {
                    visited[i] = true;
                    queue.add(new Coordinate(list[i].x, list[i].y));
                }
            }
        }
        return false;
    }

    private static int manhattan(Coordinate now, Coordinate next) {
        return Math.abs(now.x - next.x) + Math.abs(now.y - next.y);
    }
}
