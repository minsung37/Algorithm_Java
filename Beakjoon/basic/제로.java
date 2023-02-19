package algorithm.Beakjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class 제로 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < n; i++){
            int number = Integer.parseInt(br.readLine());
            if (number != 0) {
                stack.add(number);
            } else {
                stack.pop();
            }
        }
        int result = 0;
        for (int i : stack)
            result = result + i;
        System.out.println(result);
    }
}
