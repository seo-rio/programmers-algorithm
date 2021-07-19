package level.one.numberword;

import java.util.HashMap;
import java.util.Map;

/**
 * @숫자_문자열과_영단어 https://programmers.co.kr/learn/courses/30/lessons/81301
 */
public class Solution {

    static final String s = "one4seveneight";

    public static void main(String[] args) {
        System.out.println("Result ==> " + new Solution().solution(s));
    }

    public int solution(String s) {
        String answer = "";

        Map<String, Integer> workMap = new HashMap<>();
        workMap.put("zero", 0);
        workMap.put("one", 1);
        workMap.put("two", 2);
        workMap.put("three", 3);
        workMap.put("four", 4);
        workMap.put("five", 5);
        workMap.put("six", 6);
        workMap.put("seven", 7);
        workMap.put("eight", 8);
        workMap.put("nine", 9);

        char[] words = s.toCharArray();
        String findWord = "";
        for (int i = 0; i < words.length; i++) {
            if (Character.isDigit(words[i])) {
                System.out.println("숫자 => " + words[i]);
                answer += words[i];
            } else {
                System.out.println("문자 => " + words[i]);
                findWord += words[i];
            }

            if (findWord.length() == 2) {
                System.out.println("FIND WORD => " + findWord);
                for (String key : workMap.keySet()) {
                    String findKey = key.substring(0, 2);
                    int modKeyLen = key.length() - 2;

                    if (findKey.equals(findWord)) {
                        System.out.println("FIND KEY => " + workMap.get(key));
                        answer += workMap.get(key);
                        findWord = "";
                        i += modKeyLen;
                    }
                }
            }
        }

        return Integer.parseInt(answer);
    }

}
