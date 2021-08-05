package level.one.failurerate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @실패율 https://programmers.co.kr/learn/courses/30/lessons/42889
 */
public class Solution {

    private static final int N = 5;
    private static final int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(N, stages)));
    }

    public int[] solution(int N, int[] stages) {
        int[] answer = {};

        double[] resultArr = new double[N];
        Map<Integer, Double> failMap = new HashMap<>();
        for(int i=1; i<=N; i++) {
            System.out.println("I =>" + i);
            int failCount = 0;
            int reachCount = 0;
            for (int stage : stages) {
                if(i <= stage) {
                    reachCount++;
                }
                if(i == stage) {
                    failCount++;
                }
            }
            double result = ((double) failCount/ (double) reachCount);
            System.out.println(i + "번째 스테이지 실패율 => " + result);
            failMap.put(i, result);
            resultArr[i-1] = result;
        }

        System.out.println(Arrays.toString(resultArr));
        System.out.println(failMap);

        return answer;
    }
}
