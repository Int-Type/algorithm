import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    private static int l, c;
    private static String[] word;
    private static HashSet<String> set;
    private static boolean[] visited;
    private static StringBuilder sb;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        word = new String[c];
        visited = new boolean[c];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            word[i] = st.nextToken();
        }

        Arrays.sort(word);
        makeVowel();
        makePassword(0,0,"");
        System.out.println(sb);
    }


    private static void makePassword (int cnt, int idx, String password) {
        if (cnt == l && canMake(password)) {
            sb.append(password).append("\n");
            return;
        }

        for (int i = idx; i < c; i++) {
            if (!visited[i]) {
                visited[i] = true;
                makePassword(cnt + 1, i + 1, password + word[i]);
                visited[i] = false;
            }
        }
    }

    private static boolean canMake(String password) {
        int vowelCnt = 0;
        int consonantCnt = 0;
        for (int i = 0; i < password.length(); i++) {
            String s = String.valueOf(password.charAt(i));
            if (set.contains(s)) {
                vowelCnt++;
            } else {
                consonantCnt++;
            }
            if (vowelCnt >= 1 && consonantCnt >= 2) return true;
        }
        return false;
    }

    private static void makeVowel() {
        set = new HashSet<>();
        set.add("a");
        set.add("e");
        set.add("i");
        set.add("o");
        set.add("u");
    }
}