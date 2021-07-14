package level.one.lottorank;

import java.util.Arrays;

/**
 * @로또의_최고_순위와_최저_순위 https://programmers.co.kr/learn/courses/30/lessons/77484
 */
public class Solution {

    //    static final int[] lottos = {44, 1, 0, 0, 31, 25};
//    static final int[] lottos = {0, 0, 0, 0, 0, 0};
    static final int[] lottos = {1, 2, 3, 4, 5, 6};
    //    static final int[] win_nums = {31, 10, 45, 1, 6, 19};
//    static final int[] win_nums = {8, 19, 20, 40, 15, 25};
    static final int[] win_nums = {8, 19, 20, 40, 15, 25};

    public static void main(String[] args) {
        System.out.println("Result => " + Arrays.toString(new Solution().solution(lottos, win_nums)));
    }

    public int[] solution(int[] lottos, int[] win_nums) {

        int zeroCnt = 0;
        int matchCnt = 0;

        for (int num : lottos) {
            if (num == 0)
                zeroCnt++;
            if (Arrays.stream(win_nums).anyMatch(n -> n == num)) {
                matchCnt++;
            }
        }
        int firstRank = 7 - ((zeroCnt + matchCnt) == 0 ? 1 : (zeroCnt + matchCnt));
        int lastRank = 7 - (matchCnt == 0 ? 1 : matchCnt);
        return new int[]{firstRank, lastRank};
    }
}
