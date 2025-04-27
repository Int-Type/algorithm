import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int[] chess = {1, 1, 2, 2, 2, 8};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] result = new int[6];
        for (int i = 0; i < result.length; i++) {
            int n = Integer.parseInt(st.nextToken());
            result[i] = chess[i] - n;
        }
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
