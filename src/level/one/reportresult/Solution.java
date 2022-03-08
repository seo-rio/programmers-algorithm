package level.one.reportresult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.stream.Collectors;
import javafx.print.Collation;

/**
 * @신고_결과_받기 https://programmers.co.kr/learn/courses/30/lessons/92334?language=java
 */
public class Solution {

    static final String[] id_list = {"muzi", "frodo", "apeach", "neo"};
    static final String[] report = {"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
    static final int k = 2;

    public static void main(String[] args) {
        new Solution().solution(id_list, report, k);
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};

        // <신고자 ID, 신고자가 신고한사람 목록> Map
        LinkedHashMap<String, ArrayList<String>> reporterMap = new LinkedHashMap<>();
        for (String p : id_list) {
            reporterMap.put(p, new ArrayList<>());
        }

        // <신고자 ID, 신고자가 신고한사람 목록> Map 세팅
        reporterMap.keySet().forEach(r -> {
            reporterMap.put(r, (ArrayList<String>) Arrays.stream(report)
                .filter(p -> p.substring(0, p.indexOf(" ")).equals(r))
                .map(rp -> rp.substring(rp.indexOf(" ") + 1))
                .collect(Collectors.toList()));
        });

        reporterMap.keySet().forEach(r -> {
            for(String data : reporterMap.get(r)) {
                System.out.println(r + " : " + data);
            }
        });


        // 신고된 사용자만 추출
        String[] reportedPerson = Arrays.stream(report).map(p -> p.substring(p.indexOf(" ") + 1)).toArray(String[]::new);
        LinkedHashMap<String, Integer> reportPersonCountMap = new LinkedHashMap<>();

        for (String p : id_list) {
            reportPersonCountMap.put(p, 0);
        }

        // 정지된 사람 목록
        ArrayList<String> suspendedPersonList = new ArrayList<>();

        reportPersonCountMap.keySet().forEach(p -> reportPersonCountMap.put(p, (int) Arrays.stream(reportedPerson).filter(rp -> rp.equals(p)).count()));
        reportPersonCountMap.keySet().forEach(p -> {
            if(reportPersonCountMap.get(p) >= k) {
                System.out.println(p);
                System.out.println(reportPersonCountMap.get(p));
                suspendedPersonList.add(p);
            }
        });

        // TODO: 신고한 사람 중에 정지된 사람이 몇명이나 있는지 확인하여야함
        reporterMap.keySet().forEach(r -> {
        });


        return Arrays.stream(id_list).mapToInt(reportPersonCountMap::get).toArray();
    }
}
