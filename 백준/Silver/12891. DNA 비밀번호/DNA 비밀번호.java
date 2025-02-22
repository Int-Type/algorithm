import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int resultCnt, p;
    private static int[] useCnt, tryCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int s = Integer.parseInt(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        useCnt = new int[4];
        tryCnt = new int[4];
        resultCnt = 0;
        String dna = br.readLine();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            useCnt[i] = Integer.parseInt(st.nextToken());
        }

        // 최초 p만큼 업데이트
        for (int i = 0; i < p; i++) {
            char c = dna.charAt(i);
            updatePassword(c, 1);
        }

        // 최초 상태 확인
        if (canMakePassword(tryCnt)) resultCnt++;

        // 슬라이딩윈도우 사용
        for (int i = 0; i < s - p; i++) {
            char before = dna.charAt(i);
            char after = dna.charAt(i + p);
            updatePassword(before, -1);
            updatePassword(after, 1);
            // 업데이트 된 상태 확인
            if (canMakePassword(tryCnt)) resultCnt++;
        }
        sb.append(resultCnt);
        System.out.println(sb);
    }

    private static void updatePassword(char c, int add) {
        if (c == 'A') {
            tryCnt[0] += add;
        } else if (c == 'C') {
            tryCnt[1] += add;
        } else if (c == 'G') {
            tryCnt[2] += add;
        } else if (c == 'T') {
            tryCnt[3] += add;
        }
    }

    // 주어진 DNA 문자열에서 부분문자열에 포함되어야 할 최소 개수를 충족시키는지 확인
    private static boolean canMakePassword(int[] cntList) {
        for (int i = 0; i < 4; i++) {
            if (cntList[i] < useCnt[i]) {
                return false;
            }
        }
        return true;
    }
}
