package level.one.nplus;

public class Solution {

    private static final int n = 456789;
    public static void main(String[] args) {
        System.out.println(new Solution().solution(n));
    }

    public int solution(int n) {
        int answer = 0;

        char[] charN = String.valueOf(n).toCharArray();

        System.out.println("RESULT :" + sum(charN));
        return answer;
    }

    int sum(char[] charN) {
        int sumValue = 0;
        if(charN.length != 1) {
            for(char n : charN) {
                sumValue += Integer.parseInt(String.valueOf(n));
            }
            return sum(String.valueOf(sumValue).toCharArray());
        }
        return Integer.parseInt(String.valueOf(charN));
    }

}
