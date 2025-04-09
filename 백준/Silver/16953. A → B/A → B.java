import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int a, b, cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        if (bfs()) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }

    }

    private static boolean bfs() {
        cnt = 1;
        boolean[] visited = new boolean[b + 1];

        Queue<Long> queue = new ArrayDeque<>();
        queue.add((long)a);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                long num = queue.poll();
                if (num == b) return true;

                long numX2 = num * 2;
                if (numX2 <= b && !visited[(int)numX2]) {
                    visited[(int)numX2] = true;
                    queue.add(numX2);
                }

                String longToString = num + "1";
                long stringToLong = Long.parseLong(longToString);
                if (stringToLong <= b && !visited[(int)stringToLong]) {
                    visited[(int)stringToLong] = true;
                    queue.add(stringToLong);
                }
            }
            cnt++;
        }
        return false;
    }
}
