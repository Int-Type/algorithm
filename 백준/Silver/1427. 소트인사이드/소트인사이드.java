import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String n = br.readLine();
        ArrayList<Integer> number = new ArrayList<>();

        for (int i = 0; i < n.length(); i++) {
            int num = Integer.parseInt(String.valueOf(n.charAt(i)));
            number.add(num);
        }
        Collections.sort(number);
        Collections.reverse(number);

        for (Integer i : number) {
            System.out.print(i);
        }
    }
}
