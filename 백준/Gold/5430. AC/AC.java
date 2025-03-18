import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 1. 테스트 케이스 개수 T 입력받기
        int T = Integer.parseInt(br.readLine());

        // 2. T 만큼 수행할 함수p, 배열에 들어있는 수의 개수 n, 배열에 들어가 있는 정수 입력받기
        for (int tc = 1; tc <= T; tc++) {
            String line = br.readLine();

            int p = Integer.parseInt(br.readLine());
            List<Integer> numbers = new ArrayList<>();

            String input = br.readLine();
            // 대괄호 제거
            input = input.replaceAll("[\\[\\]]", "");
            // , 를 기준으로 배열의 값들을 분리해서 temp에 저장
            String[] temp = input.split(",");

            // 빈 배열일 경우 체크
            if (!input.isEmpty()) {
                for (int i = 0; i < p; i++) {
                    numbers.add(Integer.parseInt(temp[i]));
                }
            }

            boolean isCan = true;
            boolean isReversed = false; // R이 홀수 번 나오면 true

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);
                if (c == 'R') {
                    isReversed = !isReversed; // R이 나올 때마다 상태 변경
                } else if (c == 'D') {
                    if (numbers.isEmpty()) { // 비어 있으면 에러 처리
                        isCan = false;
                        sb.append("error\n");
                        break;
                    }
                    if (isReversed) {
                        // 뒤집기를 해야한다면 뒤에서 제거
                        numbers.remove(numbers.size() - 1);
                    } else {
                        numbers.remove(0);
                    }
                }
            }

            // 주어진 함수를 모두 동작했다면
            if (isCan) {
                sb.append("[");
                // 뒤집기 진행
                if (isReversed) {
                    Collections.reverse(numbers);
                }
                for (int i = 0; i < numbers.size(); i++) {
                    sb.append(numbers.get(i));
                    if (i < numbers.size() - 1) sb.append(",");
                }
                sb.append("]\n");
            }
        }
        System.out.print(sb);
    }
}
