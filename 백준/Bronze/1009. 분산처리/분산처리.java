import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		int[][] cycles = {
			{0},
			{1},
			{2, 4, 8, 6},
			{3, 9, 7, 1},
			{4, 6},
			{5},
			{6},
			{7, 9, 3, 1},
			{8, 4, 2, 6},
			{9, 1}
		};

		StringBuilder sb = new StringBuilder();
		for (int t = 0; t < T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			int last = a % 10;
			int[] cycle = cycles[last];
			int idx = (b - 1) % cycle.length;
			int digit = cycle[idx];

			sb.append(digit == 0 ? 10 : digit).append('\n');
		}
		System.out.print(sb.toString());
	}
}
