import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String X = br.readLine();
        int cnt = 0;

        while (X.length() > 1) {
            int sum = 0;
            for (int i = 0; i < X.length(); i++) {
                sum += X.charAt(i) - '0'; 
            }
            X = Integer.toString(sum);  
            cnt++;
        }

        sb.append(cnt).append("\n");
        int num = Integer.parseInt(X);
        if (num % 3 == 0) {
            sb.append("YES");
        } else {
            sb.append("NO");
        }
        System.out.println(sb);
    }
}
