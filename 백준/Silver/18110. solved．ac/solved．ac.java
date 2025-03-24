import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        Double check = n * 0.15;
        int check1 = (int) Math.round(check);

        long total = 0;
        long idx = 0;

        for (int i = check1; i < n - check1; i++) {
            total += arr[i];
            idx++;
        }

        System.out.println(Math.round((double) total / idx));
    }
}
