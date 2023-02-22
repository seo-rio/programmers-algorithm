package level.two.hotelrent;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @호텔_대실 https://school.programmers.co.kr/learn/courses/30/lessons/155651?language=java
 */
public class Solution {

    private static final String bookTime[][] = {{"15:00", "17:00"}, {"16:40", "18:20"}, {"14:20", "15:20"}, {"14:10", "19:20"}, {"18:20", "21:20"}};
//    private static final String bookTime[][] = {{"09:10", "10:10"}, {"10:20", "12:20"}};
//    private static final String bookTime[][] = {{"10:20", "12:30"}, {"10:20", "12:30"}, {"10:20", "12:30"}};

    public static void main(String[] args) {
        System.out.println(new Solution().solution(bookTime));
    }

    // "19:20", [["14:20", "15:20"], ["15:00", "17:00"], ["16:40", "18:20"], ["18:20", "21:20"]], 1
    // "15:20", [["15:00", "17:00"], ["16:40", "18:20"], ["18:20", "21:20"]], 1
    // "18:20", [["15:00", "17:00"], ["18:20", "21:20"]], 2
    // "17:00", [["18:20", "21:20"]], 2
    // "21:20", [], 3
    /*
     * 1. 시작 시간 기준 주어진 배열 정렬
     *  - [["14:10", "19:20"], ["14:20", "15:20"], ["15:00", "17:00"], ["16:40", "18:20"], ["18:20", "21:20"]]
     * 2. 가장 처음 데이터부터 검사시작
     * 3. 주어진 배열에 첫번째 종료 시간값 변수에 입력
     * 4. 입력한 값 배열에서 제거
     *  4-1. 주어진 배열 길이 -1이 0인 경우 종료
     * 5. 변수에 담긴 값 중 종료 시간 찾기
     * 6. 종료 시간 + 10분한 값 중 주어진 배열에서 시작 시간이 더 큰 첫번째 값 찾기
     *  6-1. 없으면 3으로가면서 카운트 1증가
     *  6-2. 있으면 변수에 입력 후 4로 이동
     */
    public int solution(String[][] book_time) {
        int answer = 0;
        int targetIndex = 0;

        ArrayList<ArrayList<Date>> bookTimeList = (ArrayList<ArrayList<Date>>) Arrays.stream(book_time).map(time -> {
            SimpleDateFormat format = new SimpleDateFormat("HH:mm");

            ArrayList<Date> dateList = new ArrayList<>();
            try {
                dateList.add(format.parse(time[0]));
                dateList.add(format.parse(time[1]));
                return dateList;
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }).sorted(Comparator.comparing(b -> b.get(0))).collect(Collectors.toList());

        while (bookTimeList.size() != 0) {
            Date targetEndTime = bookTimeList.get(targetIndex).get(1);
            bookTimeList.remove(targetIndex);

            System.out.println("bookTimeList ==> " + bookTimeList);

            System.out.println("targetEndTime ==> " + targetEndTime);

            Calendar cal = Calendar.getInstance();
            cal.setTime(targetEndTime);
            cal.add(Calendar.MINUTE, 10);
            System.out.println("cal.getTime() ==> " + cal.getTime());

            List<ArrayList<Date>> findDate = bookTimeList.stream().filter(time -> time.get(0).compareTo(cal.getTime()) >= 0).findFirst().stream()
                .collect(Collectors.toList());
            int findIndex = IntStream.range(0, bookTimeList.size()).filter(time -> bookTimeList.get(time).get(0).compareTo(cal.getTime()) >= 0)
                .findFirst().orElse(-1);

            if (findIndex == -1) {
                targetIndex = 0;
                answer++;
            } else {
                targetIndex = findIndex;
            }

            System.out.println("=========== CUT =============");

        }
        return answer;
    }
}
