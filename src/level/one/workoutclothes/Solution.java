package level.one.workoutclothes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @체육복 https://programmers.co.kr/learn/courses/30/lessons/42862
 */
public class Solution {

    static final int n = 7;
    static final int[] lost = {2, 3, 4, 6};
    static final int[] reserve = {1, 2, 3}; // => 5

    public static void main(String[] args) {
        System.out.println("\t\t\t === Solution Start ===");
        long start = System.currentTimeMillis();
        System.out.println("result => " + new Solution().solution(n, lost, reserve));
        long end = System.currentTimeMillis();
        System.out.println("수행 시간 : " + (end - start)/1000.0);
    }

    public int solution(int n, int[] lost, int[] reserve) {
        int lostCnt = lost.length;

        int dupCnt = 0;
        List<Integer> dupList = new ArrayList<>();

        for(int reserveItem : reserve) {
            if(Arrays.stream(lost).anyMatch(s -> s == reserveItem)) {
                dupCnt++;
                dupList.add(reserveItem);
            }
        }

        for(int i = 0; i < reserve.length; i++) {
            int findI = i;
            if(Arrays.stream(dupList.toArray()).anyMatch(s -> (int) s == reserve[findI])) {
                reserve[findI] = -1;
            }
        }

        for(int i = 0; i < lost.length; i++) {
            int findI = i;
            if(Arrays.stream(dupList.toArray()).anyMatch(s -> (int) s == lost[findI])) {
                lost[findI] = -1;
            }
        }

        for(int lostNum : lost) {
            if(lostNum != -1) {
                int prevNum = lostNum - 1;
                int nextNum = lostNum + 1;
                System.out.println(prevNum + "<" + lostNum + ">" + nextNum);
                for(int i = 0; i < reserve.length; i++) {
                    int findI = i;
                    if(reserve[i] == prevNum || reserve[i] == nextNum) {
                        System.out.println(lostNum + "번 find! => " + reserve[i]);
                        if(Arrays.stream(lost).noneMatch(s -> s == reserve[findI])) {
                            System.out.println("살아남음 " + reserve[findI]);
                            reserve[i] = -1;
                            lostCnt--;
                            break;
                        }
                    }
                }
                System.out.println("Lost Cnt => " + lostCnt);
            }

        }
        return n - (lostCnt - dupCnt);
    }
}
