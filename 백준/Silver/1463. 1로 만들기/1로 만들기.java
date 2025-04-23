import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        boolean[] visited = new boolean[n + 1];
        Queue<Integer> queue = new ArrayDeque<>();

        queue.add(n);
        visited[n] = true;
        int cnt = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int temp = queue.poll();
                
                if (temp == 1) {
                    System.out.println(cnt);
                    return;
                }

                if (temp % 3 == 0 && !visited[temp / 3]) {
                    visited[temp / 3] = true;
                    queue.add(temp / 3);
                }

                if (temp % 2 == 0 && !visited[temp / 2]) {
                    visited[temp / 2] = true;
                    queue.add(temp / 2);
                }

                if (temp - 1 >= 1 && !visited[temp - 1]) {
                    visited[temp - 1] = true;
                    queue.add(temp - 1);
                }
            }
            cnt++;
        }
        System.out.println(cnt);
    }
}
