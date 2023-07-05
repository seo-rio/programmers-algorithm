package level.two.partialsequence;

/**
 * @연속된_부분_수열의_합 https://school.programmers.co.kr/learn/courses/30/lessons/178870?language=java
 */
public class Solution {

    //        private static final int[] sequence = {1, 2, 3, 4, 5};
//        private static final int[] sequence = {1, 1, 1, 2, 3, 4, 5};
    private static final int[] sequence = {2, 2, 2, 2, 2};
    //        private static final int k = 7;
//    private static final int k = 5;
    private static final int k = 6;

    public static void main(String[] args) {
        System.out.println(new Solution().solution(sequence, k));
    }

    public int[] solution(int[] sequence, int k) {
        int[] answer = {};
        int leftPos = 0;
        int rightPos = 1;
        int sum = 0;
        int len = sequence.length;
        int resultLeft = 0;
        int resultRight = 1;
        int resultLen = 0;
        while (true) {
            System.out.println("LEFT POS => " + leftPos + " & RIGHT POS => " + rightPos);
            if (leftPos == rightPos) {
                sum = sequence[rightPos];
            } else {
                sum = sum == 0 ? sequence[leftPos] + sequence[rightPos] : sum + sequence[rightPos];
            }

            System.out.println("SUM => " + sum);
            if (sum < k) {
                if (leftPos == rightPos) {
                    break;
                }
                rightPos++;
            } else {
                if (sum == k) {
                    resultLeft = leftPos;
                    resultRight = rightPos;
                    System.out.println("RESULT LEFT POS => " + leftPos + " & RIGHT POS => " + rightPos);
                    if (len >= rightPos - leftPos && rightPos - leftPos != 0) {
                        len = rightPos - leftPos;
                        leftPos++;
                        rightPos = leftPos + 1;
                        if (rightPos == sequence.length - 1) {
                            rightPos--;
                        }
                        sum = 0;
                        resultLen = len;
                    }
                    System.out.println("LEN => " + len);
                } else {
                    leftPos++;
                    rightPos = leftPos + 1;

                    if (rightPos == sequence.length) {
                        rightPos--;
                    }

                    sum = 0;

                }
            }
        }

        System.out.println("[RESULT] LEFT POS => " + resultLeft + " & RIGHT POS => " + resultRight + " & LEN => " + resultLen);
        return answer;
    }
}
