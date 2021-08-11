package level.one.twozeroonesix;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @2016 https://programmers.co.kr/learn/courses/30/lessons/12901
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println("Result => " + new Solution().solution(1,10));
    }

    public String solution(int a, int b) {
        String answer = "";
        LocalDate time = LocalDate.of(2016,a, b);
        answer = time.getDayOfWeek().toString().substring(0,3);

        return answer;
    }
}
