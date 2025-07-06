import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // Set 자료구조를 사용하여 효율적 탐색
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        // 중복 제거: reserve와 lost 모두에 있는 학생 제거
        for (int l : lost) {
            lostSet.add(l);
        }

        for (int r : reserve) {
            if (lostSet.contains(r)) {
                // 도난당했지만 여벌도 가진 학생은 빌려줄 수 없음
                lostSet.remove(r);
            } else {
                reserveSet.add(r);
            }
        }

        // 빌려줄 수 있는 경우 확인
        for (int l : new HashSet<>(lostSet)) {
            if (reserveSet.contains(l - 1)) {
                reserveSet.remove(l - 1);
                lostSet.remove(l);
            } else if (reserveSet.contains(l + 1)) {
                reserveSet.remove(l + 1);
                lostSet.remove(l);
            }
        }

        // 전체 학생 수에서 체육복이 없는 학생 수를 뺀 값이 정답
        return n - lostSet.size();
    }
}
