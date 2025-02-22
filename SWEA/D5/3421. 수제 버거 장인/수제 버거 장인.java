import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Solution
{
    private static int n, m, result;
    private static HashMap<Integer, List<Integer>> map;
    private static StringBuilder sb;
	public static void main(String args[]) throws IOException
	{
		// 화섭이가 사용할 수 있는 재료는 1번부터 n번까지
        // i번과 j번 재료가 서로 궁합이 안맞다면 이들을 동시에 포함한 버거는 만들 수 없음
        // 궁합이 맞지 않는 재료들 m개의 쌍 정보 제공
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        int t = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < t; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new HashMap<>();
            result = 0;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                // HashMap.putIfAbsent : key 값이 a인 value 호출, 비어있으면 new ArrayList 생성, 있으면 value 값 반환
                // 양방향 체크를 위해 a, b 두곳 다 저장
                map.putIfAbsent(a, new ArrayList<>());
                map.putIfAbsent(b, new ArrayList<>());
                map.get(a).add(b);
                map.get(b).add(a);
            }
            // 같은 쌍이 여러 번 주어질 수 있기 때문에 중복 제거를 위해 HashSet 사용
            makeBugger(1, new HashSet<>());

            sb.append("#").append(tc + 1).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void makeBugger(int idx, HashSet<Integer> recipe) {
        if (idx > n) {
            result++;
            return;
        }

        // 현재 idx를 포함하는 경우
        boolean canMake = true;

        // idx 값이 싫어하는 조합이 있을 때
        if (map.containsKey(idx)) {
            // 저장한 map에서 싫어하는 조합을 가져오기
            for (int hate : map.get(idx)) {
                // 만약 저장된 레시피 안에 싫어하는 조합이 있다면 canMake를 false로 변경
                if (recipe.contains(hate)) {
                    canMake = false;
                    break;
                }
            }
        }

        // 싫어하는 조합이 없다면
        if (canMake) {
            // 레시피에 idx 추가, idx + 1해서 백트래킹
            recipe.add(idx);
            makeBugger(idx + 1, recipe);
            recipe.remove(idx);
        }

        // 싫어하는 조합이라면 , 레시피에 값을 추가하지 않고 idx + 1
        makeBugger(idx + 1, recipe);
    }
}