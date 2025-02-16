import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            Queue<int[]> queue = new ArrayDeque<>();
            List<Integer> priorities = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new int[]{i, priority});
                priorities.add(priority);
            }

            priorities.sort(Collections.reverseOrder());
            int cnt = 0;

            while (!queue.isEmpty()) {
                int[] front = queue.poll();
                int idx = front[0];
                int priority = front[1];

                if (priority == priorities.get(0)) {
                    cnt++;
                    priorities.remove(0);
                    if (idx == m) {
                        System.out.println(cnt);
                        break;
                    }
                } else {
                    queue.add(front);
                }
            }
        }
    }
}
