import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String> nameToNumber = new HashMap<>();
        HashMap<String, String> numberToName = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            String num = String.valueOf(i);
            nameToNumber.put(s, num);
            numberToName.put(num, s);
        }

        for (int i = 0; i < m; i++) {
            String s = br.readLine();

            if (nameToNumber.containsKey(s)) {
                System.out.println(nameToNumber.get(s));
            } else if (numberToName.containsKey(s)) {
                System.out.println(numberToName.get(s));
            }
        }

    }
}
