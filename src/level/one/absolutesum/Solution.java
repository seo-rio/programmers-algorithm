package level.one.absolutesum;

/**
 * @음양_더하기 https://programmers.co.kr/learn/courses/30/lessons/76501
 */
public class Solution {

    static final int[] absolutes = {4, 7, 12};
    static final boolean[] signs = {true, false, true};

    public static void main(String[] args) {
        System.out.println("Result => " + new Solution().solution(absolutes, signs));
    }

    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;

        for(int i = 0; i < absolutes.length; i++) {
            answer += signs[i] ? +absolutes[i] : -absolutes[i];
        }
        return answer;
    }
}
