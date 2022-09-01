package level.one.sentence;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    private static String sentence = "His comments came after Pyongyang announced it had a plan to fire four missiles near the US territory of Guam.";

    public static void main(String[] args) {
        System.out.println(new Solution().solution(sentence));
    }

    public String solution(String sentence) {
        
        String answer = "";
        List<Integer> asciiList = new ArrayList<>();
        for (int i = 97; i <= 122; i++) {
            asciiList.add(i);
        }

        char[] lowerSentence = sentence.toLowerCase().toCharArray();

        for (int i = 0; i < asciiList.size(); i++) {
            int existAscii = -1;
            for (char word : lowerSentence) {
                if ((int) word == asciiList.get(i)) {
                    existAscii = i;
                    break;
                }
            }
            if(existAscii == -1) {
                answer += ((char) Integer.parseInt(asciiList.get(i).toString()));
            }
        }

        return answer.equals("") ? "perfect" : answer;
    }

}
