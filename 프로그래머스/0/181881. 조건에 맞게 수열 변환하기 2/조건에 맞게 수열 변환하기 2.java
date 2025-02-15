import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        int count = 0;
        while (true) {
            int[] newArr = Arrays.copyOf(arr, arr.length); 
            boolean changed = false;
            
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= 50 && arr[i] % 2 == 0) {
                    newArr[i] = arr[i] / 2;
                } else if (arr[i] < 50 && arr[i] % 2 == 1) {
                    newArr[i] = arr[i] * 2 + 1;
                }
                if (newArr[i] != arr[i]) {
                    changed = true;
                }
            }

            if (!changed) break; 
            arr = newArr;
            count++;
        }
        return count;
    }
}