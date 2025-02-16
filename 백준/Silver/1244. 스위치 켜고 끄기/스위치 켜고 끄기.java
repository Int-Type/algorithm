import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[] switchCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        switchCnt = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            switchCnt[i] = Integer.parseInt(st.nextToken());
        }
        int studentCnt = Integer.parseInt(br.readLine());
        for (int i = 0; i < studentCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int studentGender = Integer.parseInt(st.nextToken());
            int switchNum = Integer.parseInt(st.nextToken());
            if (studentGender == 1) {
                ifMan(switchNum);
            } else {
                ifWoMan(switchNum);
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.print(switchCnt[i] + " ");
            if ((i + 1) % 20 == 0) {
                System.out.println();
            }
        }
    }

    // 학생이 남자일 때
    private static void ifMan(int n) {
        for (int i = 0; i < switchCnt.length; i++) {
            if ((i + 1) % n == 0) {
                switchReverse(i);
            }
        }
    }

    // 학생이 여자일 때
    private static void ifWoMan(int n) {
        int idx = n - 1;
        switchReverse(idx);
        check(idx, 1);
    }

    // 좌우 확인
    private static void check(int n, int m) {
        int left = n - m;
        int right = n + m;
        if (isRange(left, right) && switchCnt[left] == switchCnt[right]) {
            switchReverse(left);
            switchReverse(right);
            check(n, m + 1);
        }
    }

    // 범위 안
    private static boolean isRange(int left, int right) {
        return left >= 0 && right < n;
    }

    // 스위치 반전
    private static void switchReverse(int n) {
        switchCnt[n] = switchCnt[n] == 0 ? 1 : 0;
    }
}
