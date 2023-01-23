package algorithm.programmers.Lv1;

import java.util.ArrayList;
import java.util.Arrays;

// 나누어 떨어지는 숫자 배열
// https://school.programmers.co.kr/learn/courses/30/lessons/12910
public class 나누어_떨어지는_숫자_배열 {
    public int[] solution(int[] arr, int divisor) {

        int[] answer;
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int j : arr) {
            if (j % divisor == 0) arrayList.add(j);
        }

        if (arrayList.isEmpty()) {
            arrayList.add(-1);
        }

        answer = new int[arrayList.size()];

        for (int i=0; i<arrayList.size(); i++) {
            answer[i] = arrayList.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }
    public static void main(String[] args) {
        나누어_떨어지는_숫자_배열 sol = new 나누어_떨어지는_숫자_배열();
        int[] absolutes = { 5, 9, 7 };
        int b = 5;
        System.out.println(Arrays.toString(sol.solution(absolutes, b)));
    }
}
