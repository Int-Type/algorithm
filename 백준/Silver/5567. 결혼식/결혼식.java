import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int N, M;
	
	public static void main(String[] args) throws IOException{
		//--------------솔루션 코드를 작성하세요.--------------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		
		List<Integer>[] listA = new List[N + 1];
		List<Integer>[] listB = new List[N + 1];
		
		for(int i = 0; i <= N; i++) {
			listA[i] = new ArrayList<>();
		}
		
		for(int i = 0; i <= N; i++) {
			listB[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			listA[a].add(b);
			listB[b].add(a);
		}
		
		boolean[] visited = new boolean[N + 1];

		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(1);
		
		int cnt = 0;
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			for(int i = 0; i < size; i++) {
				int temp = queue.poll();
				
				if(!visited[temp] && cnt < 3) {
					visited[temp] = true;
					for(int j = 0; j < listA[temp].size(); j++) {
						queue.add(listA[temp].get(j));
					}
					
					for(int j = 0; j < listB[temp].size(); j++) {
						queue.add(listB[temp].get(j));
					}
				}
			}
			cnt++;
		}
		
		int result = 0;
		for(int i = 2; i <= N; i++) {
			if(visited[i]) result++;
		}
		
		System.out.println(result);
	}

}
