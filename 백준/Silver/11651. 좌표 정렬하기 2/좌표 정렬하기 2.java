import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] code = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            code[i][0] = Integer.parseInt(st.nextToken());
            code[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(code, ((o1, o2) -> {
            return (o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1]);
        }));

        for (int i = 0; i < n; i++) {
            System.out.println(code[i][0] + " " + code[i][1]);
        }
    }
}
