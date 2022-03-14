package level.one.insufficientamount;

/**
 * @부족한_금액_계산하기 https://programmers.co.kr/learn/courses/30/lessons/82612
 */
public class Solution {


    static final int price = 3;
    static final int money = 20;
    static final int count = 4;

    public static void main(String[] args) {
        System.out.println(new Solution().solution(price, money, count));
    }

    public long solution(int price, int money, int count) {
        long sum = 0;

        for(int i=1; i<=count; i++) {
            sum += (long) price * i;
        }

        return sum <= money ? 0 : sum - money;
    }

}
