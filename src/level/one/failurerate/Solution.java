package level.one.failurerate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @실패율 https://programmers.co.kr/learn/courses/30/lessons/42889
 */
public class Solution {

    private static final int N = 5;
    private static final int[] stages = {2,1,2,4,2,4,3,3};
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().solution(N, stages)));
    }

    public int[] solution(int N, int[] stages) {

        Map<Integer, Double> failMap = new HashMap<>();
        for (int i = 1; i <= N; i++) {
            System.out.println("I =>" + i);
            int failCount = 0;
            int reachCount = 0;
            for (int stage : stages) {
                if (i <= stage) {
                    reachCount++;
                }
                if (i == stage) {
                    failCount++;
                }
            }
            double result;
            if(failCount == 0 && reachCount == 0) {
                result = 0;
            }else{
                result = ((double) failCount / (double) reachCount);
            }
            failMap.put(i, result);
        }
        List<Integer> listKeySet = new ArrayList<>(failMap.keySet());

        listKeySet.sort((value1, value2) -> (failMap.get(value2).compareTo(failMap.get(value1))));
        List<Integer> answerList = new ArrayList<>(listKeySet);

        return answerList.stream().mapToInt(i->i).toArray();
    }
}
