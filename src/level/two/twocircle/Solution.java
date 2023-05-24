package level.two.twocircle;

public class Solution {

    private static final int r1 = 2;
    private static final int r2 = 4;

    public static void main(String[] args) {
        System.out.println(new Solution().solution(r1, r2));
    }

    public long solution(int r1, int r2) {
        long answer = 0;

        long innerSquare = ((r1 - 1) * 2L + 1) * ((r1 - 1) * 2L + 1);
        long outerSquare = ((r2 - 1) * 2L + 1) * ((r2 - 1) * 2L + 1);

        System.out.println("innerSquare " + innerSquare);
        System.out.println("outerSquare " + outerSquare);
        System.out.println("outerSquare - innerSquare " + (outerSquare + 4 - innerSquare));
        return answer;
    }

}

// 4 - 2 => 8개 (4-2+6)
// 3 - 2 => 3개 (3-2+2)
// 3 - 1 => 4개 (3-1+2)
// 2 - 1 => 0개 (2-1-1)