package level.two.interceptsystem;

import java.util.Arrays;

/**
 * @요격_시스템 https://school.programmers.co.kr/learn/courses/30/lessons/181188?language=java
 */
public class Solution {

    private static final int[][] targets = {{4, 5}, {4, 8}, {10, 14}, {11, 13}, {5, 12}, {3, 7}, {1, 4}};
//    private static final int[][] targets = {{11, 13}, {1, 4}};
//    private static final int[][] targets = {{0, 1}, {0, 1}, {0, 1}};

    public static void main(String[] args) {
        System.out.println(new Solution().solution(targets));
    }

    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (a, b) -> a[1] - b[1]);

        for (int i = 0; i < targets.length; i++) {

            int start = targets[i][0];
            int end = targets[i][1];

            System.out.println("===== Search Index [" + i + "] =====");
            System.out.print("Cur Point => " + start + ", " + end + "\n");

            while (i < targets.length - 1) {
                System.out.print("Check => " + targets[i + 1][0] + ", " + targets[i + 1][1] + "\n");
                if(end <= targets[i + 1][0]) {
                    break;
                } else {
                    i = i + 1;
                }
            }

            answer++;

        }

        return answer;
    }
}

