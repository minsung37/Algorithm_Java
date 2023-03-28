package algorithm.SWEA.A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class q_점심식사_시간 {

    public static int n, peopleCount, result;
    public static int[][] ground;
    public static List<Integer> people;
    public static List<Integer[]> stair;
    public static boolean[] group;

    public static void combination(int depth, int index) {
        if (depth == peopleCount / 2 + 1)
            return;
        gouping();
        for (int i = index; i < peopleCount; i++) {
            group[i] = true;
            combination(depth + 1, i + 1);
            group[i] = false;
        }
    }

    public static void gouping() {
        List<Integer> group1 = new ArrayList<>();
        List<Integer> group2 = new ArrayList<>();
        for (int i = 0; i < peopleCount; i++) {
            if (group[i])
                group1.add(people.get(i));
            else
                group2.add(people.get(i));
        }
        getArriveTime(group1, group2);
        getArriveTime(group2, group1);
    }

    public static void getArriveTime(List<Integer> group1, List<Integer> group2) {
        int[] time1 = new int[group1.size()];
        int[] time2 = new int[group2.size()];
        for (int i = 0; i < group1.size(); i++)
            time1[i] = distance(group1.get(i), stair.get(0)[0]);
        for (int i = 0; i < group2.size(); i++)
            time2[i] = distance(group2.get(i), stair.get(1)[0]);
        Arrays.sort(time1);
        Arrays.sort(time2);
        down(time1, time2);
    }

    public static void down(int[] group1, int[] group2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        boolean[] visited1 = new boolean[group1.length];
        boolean[] visited2 = new boolean[group2.length];
        int count = peopleCount;
        int time = 0;
        int removeCount = 0;
        while (count > 0) {
            time++;
            // 시간 다된사람 제거
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i) == time) {
                    removeCount++;
                    count--;
                }
            }
            for (int i = 0; i < removeCount; i++)
                list1.remove(0);
            removeCount = 0;
            for (int i = 0; i < list2.size(); i++) {
                if (list2.get(i) == time) {
                    removeCount++;
                    count--;
                }
            }
            for (int i = 0; i < removeCount; i++)
                list2.remove(0);
            removeCount = 0;

            // 1번 계단
            for (int i = 0; i < group1.length; i++) {
                // 도착했고 대기중인 사람인 경우
                if (group1[i] <= time && !visited1[i]) {
                    // 자리 있는 경우에만
                    if (list1.size() < 3) {
                        // 계단 빠져나올 시간 저장
                        if (group1[i] == time)
                            list1.add(group1[i] + stair.get(0)[1] + 1);
                        else
                            list1.add(time + stair.get(0)[1]);
                        visited1[i] = true;
                    }
                }
            }
            // 2번 계단
            for (int i = 0; i < group2.length; i++) {
                if (group2[i] <= time && !visited2[i]) {
                    if (list2.size() < 3) {
                        if (group2[i] == time)
                            list2.add(group2[i] + stair.get(1)[1] + 1);
                        else
                            list2.add(time + stair.get(1)[1]);
                        visited2[i] = true;
                    }
                }
            }
        }
        result = Math.min(result, time);
    }


    public static int distance(int a, int b) {
        return Math.abs(a / n - b / n) + Math.abs(a % n - b % n);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            ground = new int[n][n];
            people = new ArrayList<>();
            stair = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    ground[i][j] = temp;
                    if (temp == 1)
                        people.add(i * n + j);
                    if (temp > 1) {
                        Integer[] stairInfo = {i * n + j, temp};
                        stair.add(stairInfo);
                    }
                }
            }
            peopleCount = people.size();
            group = new boolean[peopleCount];
            result = Integer.MAX_VALUE;
            combination(0, 0);
            System.out.printf("#%d %d\n", t + 1, result);
        }
    }
}