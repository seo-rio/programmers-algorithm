package level.two.maze;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution {

    // 내칸에 전꺼 다음번째꺼랑 다음칸에 같은 Index
//    private static final String[] maps = {"SOOOL","XXXXO","OOOOO","OXXXX","OOOOE"};
//    private static final String[] maps = {"LOOXS","OOOOX","OOOOO","OOOOO","EOOOO"};
    private static final String[] maps = {"XOXXO", "XOSOO", "XXLXO", "XXXXO", "XXEOO"};

    // (2,1)
    // (2,1) (1,1)
    // (2,1) (1,1) (1,0)
    // (2,1) (1,1)
    // (2,1)
    // (2,1) (3,1)
    // (2,1) (3,1) (4,1)
    // (2,1) (3,1) (4,1) (4,0)
    // (2,1) (3,1) (4,1)
    // (2,1) (3,1) (4,1) (4,2)
    // (2,1) (3,1) (4,1) (4,2) (4,3)
    // (2,1) (3,1) (4,1) (4,2) (4,3) (4,4)
    // (2,1) (3,1) (4,1) (4,2) (4,3) (4,4)
    // (2,1) (3,1) (4,1) (4,2) (4,3) (4,4) (3,4)
    // (2,1) (3,1) (4,1) (4,2) (4,3) (4,4) (3,4)
    // (2,1) (3,1) (4,1) (4,2) (4,3) (4,4) (3,4) (2,4)
    // (2,1) (3,1) (4,1) (4,2) (4,3) (4,4) (3,4)
    // (2,1) (3,1) (4,1) (4,2) (4,3) (4,4)
    // (2,1) (3,1) (4,1) (4,2) (4,3)
    // (2,1) (3,1) (4,1) (4,2)
    // (2,1) (3,1) (4,1)
    // (2,1) (3,1)
    // (2,1)
    // (2,1) (2,2)
    // (2,1) (2,2) (2,1) ...
    // (2,1) (2,2) (2,1) (3,1) (4,1) (4,2) (4,3) (4,4) (3,4) (2,4)
    public static void main(String[] args) {
        System.out.println(new Solution().solution(maps));
    }

    public int solution(String[] maps) {
        ArrayList<ArrayList<Integer>> route = new ArrayList<>();
        int answer = 0;

        for (int i = 0; i < maps.length; i++) {
//            System.out.println(maps[i]);
            int colLen = maps[i].length();
            for (int j = 0; j < colLen; j++) {
//                System.out.println(maps[i].charAt(j));
                if (maps[i].charAt(j) == 'S') {
                    System.out.println("Start Index =>" + j + "," + i);

                    dfs(new int[]{j, i}, route);

                }
            }
        }

        boolean isEnd = true;
        System.out.println(route.get(0));
//        int[] startArr = route.get(0).;
//        dfs();
        return answer;

    }

    public void dfs(int[] pos, ArrayList<ArrayList<Integer>> route) {
        int x = pos[0];
        int y = pos[1];
        ArrayList<Integer> visitPos = new ArrayList<>();
        visitPos.add(x);
        visitPos.add(y);

        if(route.stream().anyMatch(r -> r.get(0) == x && r.get(1) == y)) {
//            System.out.println("기존에 있음!" + "[" + x + ", " + y + "]");
//            System.out.println("현재 POS => " + route);
//
//            for (int i = route.size() - 1; i > 0; i--) {
//                System.out.println("뭐야 => " + i);
//                route.remove(i);
//            }
//            System.out.println("지운 뒤 =>" + route);

            return;
        }

        route.add(visitPos);

        System.out.println("현재 X값 : " + x + ", 현재 Y값 : " + y);
        System.out.println("방문 POS => " + route);



        // 네 방향 좌표값 저장
        int[][] fourSidePos = new int[4][2];

        // 좌
        fourSidePos[0][0] = x - 1;
        fourSidePos[0][1] = y;

        // 상
        fourSidePos[1][0] = x;
        fourSidePos[1][1] = y - 1;

        // 우
        fourSidePos[2][0] = x + 1;
        fourSidePos[2][1] = y;

        // 하
        fourSidePos[3][0] = x;
        fourSidePos[3][1] = y + 1;

        System.out.println(Arrays.deepToString(fourSidePos));

        for (int i = 0; i < fourSidePos.length; i++) {
            System.out.println("찾기 =>" + Arrays.toString(fourSidePos[i]));

//            System.out.println("fourSidePos[i][1]" + fourSidePos[i][1]);
//            System.out.println("maps.length" + maps.length);
//            System.out.println(">>>>> 1 " + (fourSidePos[i][0] == -1));
//            System.out.println(">>>>> 2 " + (fourSidePos[i][1] == -1));
//            System.out.println(">>>>> 3 " + (fourSidePos[i][0]));
//            System.out.println(">>>>> 4 " + (maps[fourSidePos[i][1]].length()));
//            System.out.println(">>>>> 5 " + (fourSidePos[i][1] >= maps.length));
            if(fourSidePos[i][0] == -1 || fourSidePos[i][1] == -1 || fourSidePos[i][1] >= maps.length || fourSidePos[i][0] >= maps[fourSidePos[i][1]].length()) {
                System.out.println("더이상 그만!");
                continue;
            }

            char value = maps[fourSidePos[i][1]].charAt(fourSidePos[i][0]);
            System.out.println(value);
            if(value == 'O') {
                dfs(fourSidePos[i], route);
            } else if(value == 'L') {
                dfs(fourSidePos[i], route);
            } else if(value == 'E') {
                dfs(fourSidePos[i], route);
            }
//            if(maps[])
//            dfs(fourSidePos[i]);
        }

    }

}

/*
 * 01234
 * XOXXO 0
 * XOSOO 1
 * XXLXO 2
 * XXXXO 3
 * XXEOO 4
 *
 */

// (2,1)
// (2,1) (1,1)
// (2,1) (1,1) (1,0)
// (2,1) (1,1)
// (2,1)
// (2,1) (3,1)
// (2,1) (3,1) (4,1)
// (2,1) (3,1) (4,1) (4,0)
// (2,1) (3,1) (4,1)
// (2,1) (3,1) (4,1) (4,2)
// (2,1) (3,1) (4,1) (4,2) (4,3)
// (2,1) (3,1) (4,1) (4,2) (4,3) (4,4)
// (2,1) (3,1) (4,1) (4,2) (4,3) (4,4)
// (2,1) (3,1) (4,1) (4,2) (4,3) (4,4) (3,4)
// (2,1) (3,1) (4,1) (4,2) (4,3) (4,4) (3,4)
// (2,1) (3,1) (4,1) (4,2) (4,3) (4,4) (3,4) (2,4) // 캡쳐
// (2,1) (3,1) (4,1) (4,2) (4,3) (4,4) (3,4)
// (2,1) (3,1) (4,1) (4,2) (4,3) (4,4)
// (2,1) (3,1) (4,1) (4,2) (4,3)
// (2,1) (3,1) (4,1) (4,2)
// (2,1) (3,1) (4,1)
// (2,1) (3,1)
// (2,1)
// (2,1) (2,2)
// (2,1) (2,2) (2,3)
// (2,1) (2,2) (2,3) (1,3)
// (2,1) (2,2) (2,3) (1,3) (2,3) (2,2) (2,1) (3,1) (4,1) (4,2) (4,3) (4,4) (3,4) (2,4)
/*
 * 01234
 * XOXXO 0
 * XOSOO 1
 * XXOXO 2
 * XLOXO 3
 * XXEOO 4
 *
 */
