package algorithm.SWEA;


import java.util.Scanner;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class 햄버거 {

    public static int n;
    public static int l;
    public static int[] scoreList;
    public static int[] kcalList;
    public static int result;

    public static void recursion(int score, int kcal, int index) {
        // 종료조건
        if (kcal > l)
            return;
        if (index == n) {
            result = Math.max(result, score);
            return;
        }

        recursion(score + scoreList[index], kcal + kcalList[index], index + 1);
        recursion(score, kcal, index + 1);
    }

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            n = sc.nextInt();
            l = sc.nextInt();
            scoreList = new int[n];
            kcalList = new int[n];
            for (int j = 0; j < n; j++) {
                scoreList[j] = sc.nextInt();
                kcalList[j] = sc.nextInt();
            }
            recursion(0, 0, 0);
            System.out.println("#" +  (i + 1) + " " + result);
        }
    }

}
