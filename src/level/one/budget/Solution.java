package level.one.budget;

import java.util.Arrays;

public class Solution {

    final static int[] d = {2,2,3,3};
//    final static int[] d = {1,3,2,5,4};
//    final static int[] d = {1, 5, 6, 2};
//    final static int budget = 9;
    final static int budget = 10;
//    final static int budget = 8;

    // 1,5
    // 1,6
    // 1,2
    // 1,5,6
    // 1,5,2
    // 1,5,6,2
    // 5,6
    // 5,2
    // 5,6,2
    // 6,2
    public static void main(String[] args) {
        System.out.println(new Solution().solution(d, budget));
    }

    public int solution(int[] d, int budget) {
        int answer = 0;
        Arrays.sort(d);
        for (int i : d) {
            budget = budget - i;
            if (budget < 0) {
                break;
            }
            answer++;
        }
        return answer;
    }
}
