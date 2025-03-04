import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n, m, max, result;
	private static int[] card;
	private static boolean[] visited;
	private static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		// --------------솔루션 코드를 작성하세요.--------------------------------
		sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		card = new int[n];
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}

		result = 0;
		visited = new boolean[n];
		findCard(0, 0);
		sb.append(max);
		System.out.println(sb);
	}

	private static void findCard(int cnt, int idx) {
		if (cnt > 2) {
			if (result <= m && result > max)
				max = result;
			return;
		}
		
		for(int i = 0; i < n; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result += card[i];
				findCard(cnt + 1, idx + 1);
				visited[i] = false;
				result -= card[i];
			}
		}
	}
}
