package level.one.remainderone;

/**
 * @나머지가_1인_숫자_찾기 https://programmers.co.kr/learn/courses/30/lessons/87389
 */
public class Solution {

    static final int n = 10;

    public static void main(String[] args) {
        System.out.println(new Solution().solution(n));
    }

    public int solution(int n) {
        int answer = 0;
        for(int i=1; i<n; i++) {
            if(n % i == 1) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
