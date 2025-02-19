import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int k;
    private static String[] sign;
    private static boolean[] isUse;
    private static String numString, minString, maxString;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        sign = new String[k];
        isUse = new boolean[10];
        numString = "";
        minString = "";
        maxString = "";
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            sign[i] = st.nextToken();
        }
        
        for (int i = 0; i < 10; i++) {
            isUse[i] = true;
            numString = String.valueOf(i);
            test(i, 0);
            isUse[i] = false;
        }

        System.out.println(maxString);
        System.out.println(minString);
    }

    private static void test(int before, int cnt) {
        // cnt가 k일 때, min,maxString값이 비어있거나 min,maxString과 numString 값을 사전순으로 비교해서 값이 더 작거나 크다면 값 변경
        if (cnt == k) {
            if (minString.isEmpty() || minString.compareTo(numString) > 0) {
                minString = numString;
            }
            if (maxString.isEmpty() || maxString.compareTo(numString) < 0) {
                maxString = numString;
            }
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!isUse[i]) {
                // 부등호 관계를 확인할 변수 isTrue
                boolean isTrue = false;
                // 부등호 관계를 확인하고 isTrue값 변경
                if (sign[cnt].equals(">")) {
                    isTrue = before > i;
                } else if (sign[cnt].equals("<")) {
                    isTrue = before < i;
                }
                // 부등호 관계가 성립할 때 백트래킹
                if (isTrue) {
                    numString += String.valueOf(i);
                    isUse[i] = true;
                    test(i, cnt + 1);
                    // boolean 배열, numString 원상복구
                    isUse[i] = false;
                    numString = numString.substring(0, numString.length() - 1);
                }
            }
        }
    }
}
