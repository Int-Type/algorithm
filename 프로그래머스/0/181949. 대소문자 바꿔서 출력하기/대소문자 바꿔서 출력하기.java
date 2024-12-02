import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String result = "";
        
        for(int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            c = (c >= 'a' && c <='z') ? (char)(c - 32) : (char)(c + 32);
            result += c;
        }
        
        System.out.println(result);
    }
}