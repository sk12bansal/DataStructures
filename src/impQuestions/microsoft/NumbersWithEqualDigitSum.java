package impQuestions.microsoft;

import java.util.HashMap;
import java.util.Map;

/*
 * https://leetcode.com/discuss/interview-question/365872/
 * */
public class NumbersWithEqualDigitSum {
    public static void main(String[] args) {
        int[] nums = {51, 17, 71, 42};
        Map<Integer, Integer> mp = new HashMap<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int digitSum = sumOfDigit(nums[i]);
            if (!mp.containsKey(digitSum)) {
                mp.put(digitSum, nums[i]);
            } else {
                max = Math.max(max, mp.get(digitSum) + nums[i]);
                mp.put(digitSum, Math.max(nums[i], mp.get(digitSum)));
            }
        }
        System.out.println(max);
    }

    private static int sumOfDigit(int num) {
        int sum = 0;
        while (num > 0) {
            int rem = num % 10;
            sum += rem;
            num /= 10;
        }
        return sum;
    }

}
