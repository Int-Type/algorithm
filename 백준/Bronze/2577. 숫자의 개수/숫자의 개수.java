import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        int total = a * b * c; 
        String s = String.valueOf(total); 
        int[] arr = new int[10];  

        for (int i = 0; i < s.length(); i++) {
            int temp = s.charAt(i) - '0';  
            arr[temp]++;
        }

        for (int i = 0; i < 10; i++) { 
            System.out.println(arr[i]);
        }
    }
}