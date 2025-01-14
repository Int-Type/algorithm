import java.util.regex.*;
import java.util.*;

class Solution {
    public int solution(String my_string) {
        int sum = 0;

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(my_string);

        while (matcher.find()) {
            sum += Integer.parseInt(matcher.group());
        }

        return sum;
    }
}
