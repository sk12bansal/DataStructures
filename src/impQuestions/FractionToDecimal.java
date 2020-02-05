package impQuestions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FractionToDecimal {
    public static void main(String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            Long numr = sc.nextLong();
            Long denr = sc.nextLong();
            StringBuilder res = new StringBuilder();
            res.append(numr / denr);
            long remainder = numr % denr;
            if (remainder == 0) {
                System.out.println(res);
            } else {
                res.append(".");
                Map<Long, Integer> map = new HashMap<>();
                while (!map.containsKey(remainder)) {
                    map.put(remainder, res.length());
                    res.append(10 * remainder / denr);
                    remainder = 10 * remainder % denr;
                }
                int index = map.get(remainder);
                res.insert(index, "(");
                res.append(")");
                String ans = res.toString().replace("(0)", "");
                System.out.println(ans);

            }
            t -= 1;
        }
    }
}
