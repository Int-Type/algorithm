import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int T, K;
    private static int[][] magnets;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 1. 테스트 케이스의 개수 T 입력받기
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            // 2. 자석을 회전시키는 횟수 K 입력받기
            K = Integer.parseInt(br.readLine());
            // 2-1. 4개의 자석, 8개의 날의 정보를 저장하기 위해 magnets 2차원 배열 생성
            magnets = new int[4][8];

            // 3. 4개의 자석, 8개의 날 정보 입력받기
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    magnets[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 4. K번 만큼 자석을 1칸씩 회전시키는 회전 정보 입력받기
            for (int i = 0; i < K; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                // index를 맞추기 위해 -1
                int magnetIdx = Integer.parseInt(st.nextToken()) - 1;
                int direction = Integer.parseInt(st.nextToken());

                // 4-1. 회전할 방향을 저장할 배열 생성
                int[] rotation = new int[4];
                rotation[magnetIdx] = direction;

                // 5. 회전 진행 (2, 6번째 인덱스)
                // 5-1. 왼쪽 방향 탐색
                for (int j = magnetIdx - 1; j >= 0; j--) {
                    // 5-2. 현재 자석의 오른쪽 극과 오른쪽 자석의 왼쪽 극을 비교
                    if (magnets[j][2] != magnets[j + 1][6]) {
                        rotation[j] = -rotation[j + 1];
                    } else { // 서로 같은 극이라면 탐색 중지
                        break;
                    }
                }

                // 5-3. 오른쪽 방향 탐색
                for (int j = magnetIdx + 1; j < 4; j++) {
                    // 왼쪽 자석의 오른쪽 극과 현재 자석의 왼쪽 극을 비교
                    if (magnets[j - 1][2] != magnets[j][6]) {
                        rotation[j] = -rotation[j - 1];
                    } else { // 서로 같은 극이라면 탐색 중지
                        break;
                    }
                }

                // 6. 탐색 결과로 자석 회전 처리
                for (int j = 0; j < 4; j++) {
                    if (rotation[j] == 1) {
                        clockwise(j);
                    } else if (rotation[j] == -1) {
                        counterClockwise(j);
                    }
                }
            }
            
            int score = 0;
            // 7. 최종 점수 계산
            for (int i = 0; i < 4; i++) {
                if (magnets[i][0] == 1) {
                    score += (1 << i);
                }
            }
            sb.append("#").append(tc).append(" ").append(score).append("\n");
        }
        System.out.println(sb);
    }

    // 시계 방향 회전
    private static void clockwise(int idx) {
        int temp = magnets[idx][7];
        for (int i = 7; i >= 1; i--) {
            magnets[idx][i] = magnets[idx][i - 1];
        }
        magnets[idx][0] = temp;
    }

    // 반시계 방향 회전
    private static void counterClockwise(int idx) {
        int temp = magnets[idx][0];
        for (int i = 0; i < 7; i++) {
            magnets[idx][i] = magnets[idx][i + 1];
        }
        magnets[idx][7] = temp;
    }
}
