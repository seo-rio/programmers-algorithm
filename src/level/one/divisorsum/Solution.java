package level.one.divisorsum;

import java.util.stream.IntStream;

/**
 * @약수의_개수와_덧셈 https://programmers.co.kr/learn/courses/30/lessons/77884
 */
public class Solution {

    static final int left = 13;
    static final int right = 17;

    public static void main(String[] args) {
        System.out.println("Result ==> " + new Solution().solution(left, right));
    }

    public int solution(int left, int right) {
        int answer = 0;

        for(int i=left; i<=right; i++) {
            int currentNum = i;
            int divisorCount = (int) IntStream.rangeClosed(1, currentNum).filter(num -> currentNum % num == 0).count();
            if(divisorCount % 2 == 0) {
                answer += i;
            }else{
                answer -= i;
            }
        }
        return answer;
    }
}
