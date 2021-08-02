package level.one.budget;

public class Solution {

//    final static int[] d = {3,1,1,1};
//    final static int[] d = {1,3,2,5,4};
    final static int[] d = {1, 5, 6, 2};
//    final static int budget = 9;
    final static int budget = 3;
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
        int modLen = d.length;

        for (int i = 0; i < d.length; i++) {
            int loopCnt = 0;
            for(int j=1; j<=(modLen - (i+1)); j++){
//                System.out.println("j =" + j);
                loopCnt += j;
            }
            for(int j=0; j<loopCnt; j++){
                System.out.println("j =" + j);

            }
            System.out.println("i = " + d[i] + " modLen = " + loopCnt);
        }
        return answer;
    }
}
