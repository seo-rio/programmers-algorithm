package level.one.palindrome;

public class Solution {

    static final int n = 100;
    static final int m = 300;

    public static void main(String[] args) {
        System.out.println(new Solution().solution(n, m));
    }

    public int solution(int n, int m) {
        int answer = 0;

        for(int i = n; i <= m; i++) {
            String stringValue = String.valueOf(i);
            char[] charValue = stringValue.toCharArray();

            int compareCount = 0;
            for(int j=0; j<charValue.length; j++) {
                if(charValue[j] == charValue[((charValue.length - 1) - j)]) {
                    compareCount++;
                }
            }

            if(compareCount == charValue.length) {
                answer++;
            }
        }
        return answer;
    }
}
