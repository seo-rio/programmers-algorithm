package level.one.nonumbersum;

import java.util.Arrays;

/**
 * @없는_숫자_더하기 https://programmers.co.kr/learn/courses/30/lessons/86051
 */
public class Solution {

    static final int[] numbers = {1,2,3,4,6,7,8,0};

    public static void main(String[] args) {
        System.out.println(new Solution().solution(numbers));
    }

    public int solution(int[] numbers) {
        return 45 - Arrays.stream(numbers).sum();
    }

}
