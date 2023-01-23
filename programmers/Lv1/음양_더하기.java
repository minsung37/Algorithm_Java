package algorithm.programmers.Lv1;

// 음양 더하기
// https://school.programmers.co.kr/learn/courses/30/lessons/76501?language=java
public class 음양_더하기 {
    public int solution(int[] absolutes, boolean[] signs) {
        int sum = 0;

        for(int i=0; i<absolutes.length; i++){
            if (signs[i]) {
                sum = sum + absolutes[i];
            }
            else if (!signs[i]) {
                sum = sum - absolutes[i];
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        음양_더하기 sol = new 음양_더하기();

        // tc - 1
        int[] absolutes1 = { 1, 2, 3 };
        boolean[] signs1 = { false, false, true };

        // tc - 2
        int[] absolutes2 = { 1, 2, 3 };
        boolean[] signs2 = { false, false, true };

        System.out.println(sol.solution(absolutes1, signs1));
        System.out.println(sol.solution(absolutes2, signs2));
    }
}