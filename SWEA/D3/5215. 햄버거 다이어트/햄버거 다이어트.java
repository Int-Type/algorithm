import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution
{
    private static StringBuilder sb;
    private static int n, l, max;
    private static int[][] ingredient;
	public static void main(String args[]) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            ingredient = new int[n][2];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                // 점수
                ingredient[i][0] = Integer.parseInt(st.nextToken());
                // 칼로리
                ingredient[i][1] = Integer.parseInt(st.nextToken());
            }
            max = Integer.MIN_VALUE;
            makeBugger(0,0, 0);

            sb.append("#").append(tc + 1).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

    private static void makeBugger(int idx, int score, int calory) {
        // 칼로리가 제한 칼로리 보다 크다면 return
        if (calory > l) return;

        // 최대 점수 갱신
        max = Math.max(max, score);

        // n만큼 재료를 모두 사용했다면 종료
        if (idx == n) return;

        // 재료 사용
        makeBugger(idx + 1, score + ingredient[idx][0], calory + ingredient[idx][1]);

        // 재료 미사용
        makeBugger(idx + 1, score, calory);
    }
}
