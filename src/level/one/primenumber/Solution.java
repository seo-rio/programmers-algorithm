package level.one.primenumber;

import java.util.ArrayList;
import java.util.List;

/**
 * @소수_만들기 https://programmers.co.kr/learn/courses/30/lessons/12977
 */
public class Solution {

    final static int[] case1 = {1, 2, 3, 4};
    final static int[] case2 = {1, 2, 7, 6, 4};

    public static void main(String[] args) {
        List<int[]> numsList = new ArrayList<>();
        numsList.add(case1);
        numsList.add(case2);

        for (int[] nums : numsList) {
            System.out.println("\t\t\t === Solution Start ===");
            long start = System.currentTimeMillis();

            int result = new Solution().solution(nums);
            System.out.println("result => " + result);

            long end = System.currentTimeMillis();
            System.out.println("수행 시간 : " + (end - start)/1000.0);
        }
    }

    // 1(0),2(1),3(2) = 6
    // 1(0),3(2),4(3) = 8

    // 2,3,4 = 9

    // 1(0),2(1),7(2) = 10
    // 1(0),2(1),6(3) = 9
    // 1(0),2(1),4(4) = 7
    // 1(0),7(2),6(3) = 14
    // 1(0),7(2),4(4) = 12
    // 1(0),6(3),4(4) = 11

    // 2(1),7(2),6(3) = 15
    // 2(1),7(2),4(4) = 13
    // 2(1),6(3),4(4) = 12

    // 7(2),6(3),4(4) = 17
    public int solution(int[] nums) {
        int answer = 0;
        int maxIdx = nums.length - 1;

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < maxIdx; j++) {
                for(int k = j; k < maxIdx; k++) {
                    int sum = nums[i] + nums[j] + nums[(k + 1)];
                    answer++;
                    for(int t = 1; t <= sum; t++) {
                        if(t != 1 && t != sum) {
                            if(sum % t == 0) {
                                answer--;
                                break;
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }
}
