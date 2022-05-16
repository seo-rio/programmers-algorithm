package level.one.poanketmon;

import java.util.Arrays;

public class Solution2 {

    static final int[] nums = {1, 3, 3, 3, 3, 3, 3, 3};
    public static void main(String[] args) {
        System.out.println(new Solution2().solution(nums));
    }

     public int solution(int[] nums) {
        int answer = 0;

        int uniCount = (int) Arrays.stream(nums).distinct().count();
        int pickCount = nums.length / 2;

         if(pickCount > uniCount) {
             answer = uniCount;
         } else {
             answer = pickCount;
         }

        return answer;
    }
}
