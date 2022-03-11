package level.one.reportresult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

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
        int[] answer = new int[id_list.length];

        // <신고자 ID, 신고자가 신고한사람 목록> Map
        LinkedHashMap<String, HashSet<String>> reporterMap = new LinkedHashMap<>();
        for (String p : id_list) {
            reporterMap.put(p, new HashSet<>());
        }

        // <신고자 ID, 신고자가 신고한사람 목록> Map 세팅
        reporterMap.keySet().forEach(r -> {
            reporterMap.put(r, (HashSet<String>) Arrays.stream(report)
                .filter(p -> p.substring(0, p.indexOf(" ")).equals(r))
                .map(rp -> rp.substring(rp.indexOf(" ") + 1))
                .collect(Collectors.toSet()));
        });

        ArrayList<String> reportedPersonList = new ArrayList<>();
        reporterMap.forEach((key, value) -> {
            reportedPersonList.addAll(value);
        });
        LinkedHashMap<String, Integer> reportPersonCountMap = new LinkedHashMap<>();

        for (String p : id_list) {
            reportPersonCountMap.put(p, 0);
        }

        // 정지된 사람 개수 목록
        ArrayList<String> suspendedPersonList = new ArrayList<>();

        reportPersonCountMap.keySet().forEach(p -> reportPersonCountMap.put(p, (int) reportedPersonList.stream().filter(rp -> rp.equals(p)).count()));
        reportPersonCountMap.forEach((key, value) -> {
            if(value >= k) {
                suspendedPersonList.add(key);
            }
        });

        // 신고한 사람 중에 정지된 사람이 몇명이나 있는지 확인하여야함
        AtomicInteger index = new AtomicInteger();
        reporterMap.forEach((key, value) -> {
            AtomicInteger count = new AtomicInteger();
            value.forEach(rp -> {
                suspendedPersonList.forEach(sp -> {
                    if(sp.equals(rp)) {
                        count.getAndIncrement();
                    }
                });
                answer[index.intValue()] = count.intValue();
            });
            index.getAndIncrement();
        });

        for(int i : answer) {
            System.out.println(i);
        }


        return answer;
    }
}
