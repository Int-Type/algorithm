import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;

        // n이 5로 나눠진다면 for문을 통해 5의 배수를 뺄셈
        for (int i = 0; i <= n / 5; i++) {
            int delivery = n - 5 * i;

            // 만약 n을 5로 빼고난 나머지를 3으로 나눴을 때 0이 된다면
            // min 값과 i + delivery / 3 의 값을 비교하고 min값 변경
            if (delivery % 3 == 0) {
                min = Math.min(min, i + delivery / 3);
            }
        }
        if (min == Integer.MAX_VALUE) min = -1;

        System.out.println(min);
    }
}
