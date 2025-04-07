import java.io.*;
import java.util.*;

public class Main {

    private static int N, remove, cnt, root;
    private static List<Integer>[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new List[N];
        for (int i = 0; i < N; i++) tree[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
            } else {
                tree[parent].add(i);
            }
        }

        remove = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            tree[i].remove(Integer.valueOf(remove));
        }

        cnt = 0;
        if (remove != root) {
            dfs(root);
        }
        System.out.println(cnt);
    }

    private static void dfs(int node) {
        if (tree[node].isEmpty()) {
            cnt++;
            return;
        }

        for (int child : tree[node]) {
            dfs(child);
        }
    }
}
