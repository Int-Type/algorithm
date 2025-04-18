import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] n = new int[5];
        int avg = 0;
        for (int i = 0; i < 5; i++) {
            n[i] = Integer.parseInt(br.readLine());
            avg += n[i];
        }
        avg /= 5;
        Arrays.sort(n);
        System.out.println(avg);
        System.out.println(n[2]);
    }
}
