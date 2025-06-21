import java.util.*;

class Solution {
    static final int SIZE = 102; // 2배 좌표로 처리 (50*2 + 여유)
    static int[][] map = new int[SIZE][SIZE];
    static boolean[][] visited = new boolean[SIZE][SIZE];
    static int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        // 좌표 2배 처리
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2, y1 = rect[1] * 2;
            int x2 = rect[2] * 2, y2 = rect[3] * 2;

            // 전체 내부 채우기
            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    map[x][y] = 1;
                }
            }
        }

        // 내부 제거 (외곽만 남기기)
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2, y1 = rect[1] * 2;
            int x2 = rect[2] * 2, y2 = rect[3] * 2;

            for (int x = x1 + 1; x < x2; x++) {
                for (int y = y1 + 1; y < y2; y++) {
                    map[x][y] = 0;
                }
            }
        }

        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }

    private int bfs(int startX, int startY, int targetX, int targetY) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            if (x == targetX && y == targetY) {
                return dist;
            }

            for (int[] d : directions) {
                int nx = x + d[0], ny = y + d[1];

                if (nx >= 0 && ny >= 0 && nx < SIZE && ny < SIZE) {
                    if (!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny, dist + 1});
                    }
                }
            }
        }

        return -1; // 도달 불가한 경우
    }
}
