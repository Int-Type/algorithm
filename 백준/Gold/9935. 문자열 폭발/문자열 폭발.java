import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 1. 문자열 입력받기
        String s = br.readLine();
        // 2. 폭발 문자열 입력받기
        String boom = br.readLine();
        // 2-1. 폭발 문자열 길이 저장
        int boomLength = boom.length();

        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            // 3. 메모리 절약을 위해 StringBuilder를 stack처럼 사용
            sb.append(s.charAt(i));
            // 3-1. 만약 sb 사이즈가 폭발 문자열 길이보다 길다면 폭발 문자열 탐색
            if (sb.length() >= boomLength) {
                boolean catchBoom = true;
                for (int j = 0; j < boomLength; j++) {
                    // 3-2. 탐색 중 문자열에 폭발 문자열이 없다면 catchBoom을 false 하고 for문 종료
                    if (sb.charAt(sb.length() - boomLength + j) != boom.charAt(j)) {
                        catchBoom = false;
                        break;
                    }
                }

                // 3-3. 폭발 문자열을 찾았다면 문자열에서 폭발 문자열 제거
                if (catchBoom) {
                    sb.setLength(sb.length() - boomLength);
                }
            }
        }

        // 4. sb 비어있다면 주어진 문자열 출력
        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            // 4-1. 비어있지 않다면 sb 출력
            System.out.println(sb);
        }
    }
}
