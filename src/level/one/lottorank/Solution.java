package level.one.lottorank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @로또의_최고_순위와_최저_순위 https://programmers.co.kr/learn/courses/30/lessons/77484
 */
public class Solution {

    static final int[] lottos = {44, 1, 0, 0, 31, 25};
    static final int[] win_nums = {31, 10, 45, 1, 6, 19};

    public static void main(String[] args) {
        System.out.println("Result => " + Arrays.toString(new Solution().solution(lottos, win_nums)));
    }

    public int[] solution(int[] lottos, int[] win_nums) {

        int zeroCnt = 0;
        int matchCnt = 0;
        int firstRank = 0;
        int lastRank = 0;

        for(int num : lottos) {
            if(num == 0)
                zeroCnt++;
            if(Arrays.stream(win_nums).anyMatch(n -> n == num)) {
                matchCnt++;
            }
        }

        switch(zeroCnt + matchCnt) {
            case 6:
                firstRank = 1;
                break;
            case 5:
                firstRank = 2;
                break;
            case 4:
                firstRank = 3;
                break;
            case 3:
                firstRank = 4;
                break;
            case 2:
                firstRank = 5;
                break;
            case 1:
                firstRank = 6;
                break;
        }

        switch(matchCnt) {
            case 6:
                lastRank = 1;
                break;
            case 5:
                lastRank = 2;
                break;
            case 4:
                lastRank = 3;
                break;
            case 3:
                lastRank = 4;
                break;
            case 2:
                lastRank = 5;
                break;
            case 1:
                lastRank = 6;
                break;
        }

        System.out.println("1st => " + firstRank);
        System.out.println("last => " + lastRank);

        return new int[]{firstRank, lastRank};
    }

}
