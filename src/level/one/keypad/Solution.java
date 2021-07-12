package level.one.keypad;

import java.util.HashMap;
import java.util.Map;

/**
 * @키패드_누르기 https://programmers.co.kr/learn/courses/30/lessons/67256
 */
public class Solution {

//    static final int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
    static final int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2};
//    static final String hand = "right";
    static final String hand = "left";


    /**
     * [0,0] [0,1] [0,2]
     * [1,0] [1,1] [1,2]
     * [2,0] [2,1] [2,2]
     * [3,0] [3,1] [3,2]
     */

    public static void main(String[] args) {
        System.out.println("Result => " + new Solution().solution(numbers, hand));
    }

    public String solution(int[] numbers, String hand) {
        String answer = "";
        String[] numPosArr = {"0,0", "0,1", "0,2", "1,0", "1,1", "1,2", "2,0", "2,1", "2,2", "3,1"};
        Map<String, String> posMap = new HashMap<>();
        final String LEFT_POS = "L";
        final String RIGHT_POS = "R";

        posMap.put(LEFT_POS, "3,0");
        posMap.put(RIGHT_POS, "3,2");

        for(int num : numbers) {
            String pos = numPosArr[num != 0 ? num - 1 : numPosArr.length - 1];
            int rightPos = Integer.parseInt(pos.substring(pos.indexOf(",") + 1));
            int leftPos = Integer.parseInt(pos.substring(0, pos.indexOf(",")));

            String pickHand = "";

            if(rightPos == 0) {
                pickHand = LEFT_POS;
                posMap.put(LEFT_POS, pos);
            }else if(rightPos == 2){
                pickHand = RIGHT_POS;
                posMap.put(RIGHT_POS, pos);
            }else{
                int prevRHandRPos = Integer.parseInt(posMap.get(RIGHT_POS).substring(posMap.get(RIGHT_POS).indexOf(",") + 1));
                int prevRHandLPos = Integer.parseInt(posMap.get(RIGHT_POS).substring(0, posMap.get(RIGHT_POS).indexOf(",")));
                int prevLHandRPos = Integer.parseInt(posMap.get(LEFT_POS).substring(posMap.get(LEFT_POS).indexOf(",") + 1));
                int prevLHandLPos = Integer.parseInt(posMap.get(LEFT_POS).substring(0, posMap.get(LEFT_POS).indexOf(",")));

                int subtractLHand = Math.abs(leftPos - prevLHandLPos) + Math.abs(rightPos - prevLHandRPos);
                int subtractRHand = Math.abs(leftPos - prevRHandLPos) + Math.abs(rightPos - prevRHandRPos);

                if(subtractLHand > subtractRHand) {
                    pickHand = RIGHT_POS;
                    posMap.put(RIGHT_POS, pos);
                }else if(subtractLHand < subtractRHand) {
                    pickHand = LEFT_POS;
                    posMap.put(LEFT_POS, pos);
                }else{
                    if(hand.equals("right")) {
                        pickHand = RIGHT_POS;
                        posMap.put(RIGHT_POS, pos);
                    }else{
                        pickHand = LEFT_POS;
                        posMap.put(LEFT_POS, pos);
                    }
                }
            }
            answer += pickHand;
        }

        return answer;
    }
}
