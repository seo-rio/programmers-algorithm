package level.one.minimumrectangle;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @최소_직사각형 https://programmers.co.kr/learn/courses/30/lessons/86491
 */
public class Solution {

    static final int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};

    public static void main(String[] args) {
        System.out.println(new Solution().solution(sizes));
    }

    public int solution(int[][] sizes) {
        int wMaxNum = 0;
        int hMaxNum = 0;


        for (int[] num : sizes) {
            int[] sortedNum = Arrays.stream(num).sorted().toArray();
            for (int i = 0; i < sortedNum.length; i++) {
                if (i == 0) {
                    if(wMaxNum < sortedNum[i]) {
                        wMaxNum = sortedNum[i];
                    }
                }else{
                    if(hMaxNum < sortedNum[i]) {
                        hMaxNum = sortedNum[i];
                    }
                }
            }
        }
        return wMaxNum * hMaxNum;
    }
}
