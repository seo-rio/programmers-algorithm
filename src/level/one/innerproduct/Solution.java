package level.one.innerproduct;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @내적 https://programmers.co.kr/learn/courses/30/lessons/70128
 */
public class Solution {

    final static int[][] case1 = {{1,2,3,4}, {-3,-1,0,2}};
    final static int[][] case2 = {{-1,0,1}, {1,0,-1}};

    public static void main(String[] args) {

        List<int[][]> numsList = new ArrayList<>();
        numsList.add(case1);
        numsList.add(case2);

        for (int[][] ints : numsList) {
            int result = new Solution().solution(ints[0], ints[1]);
            System.out.println("Result => " + result);
        }
    }

    public int solution(int[] a, int[] b) {
        int answer = 0;
        int len = a.length;

        for(int i=0; i<len; i++) {
            answer += (a[i] * b[i]);
        }

        return answer;
    }
}
