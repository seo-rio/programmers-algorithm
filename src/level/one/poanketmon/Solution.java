package level.one.poanketmon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @폰켓몬 https://programmers.co.kr/learn/courses/30/lessons/1845?language=java
 */
public class Solution {

    final static int[] case1 = {3, 1, 2, 3};
    final static int[] case2 = {3, 3, 3, 2, 2, 4};
    final static int[] case3 = {3, 3, 3, 2, 2, 2};
    final static int[] case4 = {1, 3, 3, 2, 2, 2, 4, 4};
    final static int[] case5 = {3, 3, 3, 3, 3, 3, 3, 3};
    final static int[] case6 = {1, 3, 3, 3, 3, 3, 3, 3};
    final static int[] case7 = {3, 1, 3, 3};

    public static void main(String[] args) {
        List<int[]> numsList = new ArrayList<>();
        numsList.add(case1);
        numsList.add(case2);
        numsList.add(case3);
        numsList.add(case4);
        numsList.add(case5);
        numsList.add(case6);
        numsList.add(case7);

        for (int[] nums : numsList) {
            System.out.println("\t\t\t === Solution Start ===");
            int result = new Solution().solution(nums);
            System.out.println("result => " + result);
        }
    }

    public int solution(int[] nums) {
        int answer = 0;
        int numLen = nums.length;
        int pickCount = numLen / 2;
        int pickCase = 0;

        for (int i = 1; i < numLen; i++) {
            pickCase += i;
        }
        Arrays.sort(nums);
        int uniqCount = 0;
        int prevNum = 0;

        for (int num : nums) {
            if (prevNum != num) {
                prevNum = num;
                uniqCount++;
            }
        }

        if(pickCount == uniqCount) {
            answer = pickCase%numLen;
        }else{
            if(uniqCount > pickCount) {
                answer = pickCount;
            }else{
                answer = uniqCount;
            }
        }

        return answer;
    }
}
// 다른 수 3, 경우의 수 6 , 고를 수 있는 수 2, 총 개수 4 => 2 | 6/4  = 1 .. [2]

// 다른 수 3, 경우의 수 15, 고를 수 있는 수 3, 총 개수 6 => [3] | 15/6 = 2 .. 3
// 다른 수 2, 경우의 수 15, 고를 수 있는 수 3, 총 개수 6 => [2] | 15/6 = 2 .. 3

// 다른 수 4, 경우의 수 28, 고를 수 있는 수 4, 총 개수 8 => 4 | 28/8 = 3 .. [4]
// 다른 수 1, 경우의 수 28, 고를 수 있는 수 4, 총 개수 8 => 1 | 28/8 = 3 .. [4]
// 다른 수 2, 경우의 수 28, 고를 수 있는 수 4, 총 개수 8 => 2 | 28/8 = 3 .. [4]
// 다른 수 2, 경우의 수 6 , 고를 수 있는 수 2, 총 개수 4 => 2 | 6/4  = 1 .. [2]

// 1,2 / 1,3 / 1,4
// 2,2 / 2,3 / 2,4
//
//
// 3,4
//
//
//  [1,2,3,3]