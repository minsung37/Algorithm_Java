package algorithm.programmers.Lv1;

// 제일 작은 수 제거하기
// https://school.programmers.co.kr/learn/courses/30/lessons/12935
public class 제일_작은_수_제거하기 {
    public int[] solution(int[] arr) {

        if(arr.length == 1){
            int[] answer = {-1};
            return answer;
        }

        int[] answer = new int[arr.length-1];

        int min = arr[0];

        for(int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }

        int index = 0;

        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == min) {
                continue;
            }
            answer[index++] = arr[i];
        }

        return answer;
    }
}
