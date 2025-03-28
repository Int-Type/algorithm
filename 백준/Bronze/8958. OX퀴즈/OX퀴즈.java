import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine()); 

        for (int i = 0; i < t; i++) {
            String input = br.readLine(); 
            int score = 0;  
            int consecutive = 0; 

            for (char ch : input.toCharArray()) {
                if (ch == 'O') {
                    consecutive++; 
                    score += consecutive; 
                } else {
                    consecutive = 0; 
                }
            }
            System.out.println(score);
        }
    }
}