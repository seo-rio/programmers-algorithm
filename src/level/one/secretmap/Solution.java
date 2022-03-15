package level.one.secretmap;

/**
 * @비밀지도 https://programmers.co.kr/learn/courses/30/lessons/17681
 */
public class Solution {

//    static final int n = 5;
    static final int n = 6;
//    static final int[] arr1 = {9, 20, 28, 18, 11};
    static final int[] arr1 = {46, 33, 33 ,22, 31, 50};
//    static final int[] arr2 = {30, 1, 21, 17, 18};
    static final int[] arr2 = {27 ,56, 19, 14, 14, 10};

    public static void main(String[] args) {
        new Solution().solution(n, arr1, arr2);
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++) {
            String result = String.format("%0" + n + "d", Long.parseLong(Integer.toBinaryString(arr1[i] | arr2[i])));
            answer[i] = result.replaceAll("1", "#").replaceAll("0", " ");
        }
        return answer;
    }

}
