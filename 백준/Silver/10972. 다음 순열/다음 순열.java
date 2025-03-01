import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int[] arr, result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        result = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        boolean isChange = np();

        if (isChange) {
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    private static boolean np() {
        int i = n - 1;
        while (i > 0 && arr[i - 1] >= arr[i]) --i;

        if (i == 0) return false;

        int j = n - 1;
        while (arr[i - 1] >= arr[j]) --j;

        swap(i - 1, j);

        int k = n - 1;
        while (i < k) swap(i++, k--);

        return true;
    }

    static void swap(int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
