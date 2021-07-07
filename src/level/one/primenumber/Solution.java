package level.one.primenumber;

/**
 * @소수_만들기 https://programmers.co.kr/learn/courses/30/lessons/12977
 */
public class Solution {

    final static int[] nums1 = {1, 2, 3, 4};
    final static int[] nums2 = {1, 2, 7, 6, 4};

    public static void main(String[] args) {
        System.out.println(solution(nums1));
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
    public static int solution(int[] nums) {
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
