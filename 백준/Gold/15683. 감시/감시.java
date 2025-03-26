import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Coordinate {
        int x, y;
        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static List<Coordinate> cctvList;
    private static int N, M, size, min;
    private static int[][] map, checkCCTV;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 1. 사무실의 세로 크기 N, 가로 크기 M 입력받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        checkCCTV = new int[N][M];
        min = Integer.MAX_VALUE;
        cctvList = new ArrayList<>();

        // 2. n x m 크기의 사무실 정보 입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) {
                    if (map[i][j] != 6) {
                        cctvList.add(new Coordinate(i, j));
                        checkCCTV[i][j] = 7;
                    } else {
                        checkCCTV[i][j] = 6;
                    }
                }
            }
        }
        size = cctvList.size();

        dfs(0);

        System.out.println(min);
    }

    private static void dfs(int idx) {
        //System.out.println("→ dfs 시작 idx = " + idx);
        if (idx == size) {
            int temp = checkCCTVArea(checkCCTV);
            if (min > temp) min = temp;
            return;
        }

        Coordinate where = cctvList.get(idx);
        List<int[][]> cctv = selectCCTV(map[where.x][where.y]);

        for (int[][] temp : cctv) {
            List<Coordinate> changed = new ArrayList<>();
            for (int[] delta : temp) {
                int goIdx = 1;
                while (true) {
                    int nr = where.x + (delta[0] * goIdx);
                    int nc = where.y + (delta[1] * goIdx);

                    if (!isRange(nr, nc)) break;
                    if (map[nr][nc] == 6) break;

                    if (map[nr][nc] == 0 && checkCCTV[nr][nc] != 7) {
                        checkCCTV[nr][nc] = 7;
                        changed.add(new Coordinate(nr, nc));
                    }
                    goIdx++;
                }
            }
            dfs(idx + 1);
            for (Coordinate coordinate : changed) {
                checkCCTV[coordinate.x][coordinate.y] = 0;
            }
        }
    }

    private static int checkCCTVArea(int[][] area) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (area[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }

    // 2-2. 1번은 한쪽 방향만, 2~3번은 두방향, 2번은 감시하는 방향이 서로 반대, 3번은 직각방향, 4번은 세방향, 5번은 4방향
    // 2-3. cctv는 회전시킬 수 있는데, 회전은 항상 90도 방향으로 해야하며, 감시하려고 하는 방향이 가로 또는 세로 방향이어야 한다.
    private static List<int[][]> selectCCTV (int n) {
        List<int[][]> list = new ArrayList<>();
        switch (n) {
            case 1 :
                list.add(new int[][]{{0, 1}});
                list.add(new int[][]{{0, -1}});
                list.add(new int[][]{{-1, 0}});
                list.add(new int[][]{{1, 0}});
                break;
            case 2 :
                list.add(new int[][]{{0,1},{0,-1}});
                list.add(new int[][]{{1,0},{-1,0}});
                break;
            case 3 :
                list.add(new int[][]{{-1,0},{0,1}});
                list.add(new int[][]{{0,1},{1,0}});
                list.add(new int[][]{{1,0},{0,-1}});
                list.add(new int[][]{{0,-1},{-1,0}});
                break;
            case 4 :
                list.add(new int[][]{{0,-1},{-1,0},{0,1}});
                list.add(new int[][]{{-1,0},{0,1},{1,0}});
                list.add(new int[][]{{0,1},{1,0},{0,-1}});
                list.add(new int[][]{{1,0},{0,-1},{-1,0}});
                break;
            case 5 :
                list.add(new int[][]{{-1,0},{0,1},{1,0},{0,-1}});
                break;
        }
        return list;
    }

    private static boolean isRange(int nr, int nc) {
        return nr >= 0 && nr < N && nc >= 0 && nc < M;
    }
}

// cctv가 바라보는 방향을 어떤식으로 돌려줘야할까?
// 1번은 2차원배열을 준다고 하고 다른것들은?
// 그렇다면 리스트 배열을 주고 한번씩?



// 1. 사무실의 세로 크기 N, 가로 크기 M 입력받기
// 2. n x m 크기의 사무실 정보 입력받기
// 2-1. 0은 빈칸, 1~ 5는 cctv, 6은 벽
// 2-2. 1번은 한쪽 방향만, 2~3번은 두방향, 2번은 감시하는 방향이 서로 반대, 3번은 직각방향, 4번은 세방향, 5번은 4방향
// 2-3. cctv는 회전시킬 수 있는데, 회전은 항상 90도 방향으로 해야하며, 감시하려고 하는 방향이 가로 또는 세로 방향이어야 한다.
// 2-4. cctv는 벽을 통과할 수 없고 cctv 끼리는 통과할 수 있다.
// 3. 사각 지대의 최소 크기를 구하는 프로그램 작성
