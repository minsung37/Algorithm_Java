package algorithm.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class q_단어뒤집기 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String words = bf.readLine();
        Boolean is_tag = false;
        Stack<String> stack = new Stack<String>();

        for (int i = 0; i < words.length(); i++) {
            char word = words.charAt(i);
            if (word == '<') {
                is_tag = true;
                while (!stack.empty()){
                    sb.append(stack.pop());
                }
            }
            if (word == '>') {
                sb.append(">");
                is_tag = false;
                continue;
            }
            if (!is_tag)
                stack.push(word+"");
            if (is_tag)
                sb.append(word);
            if (word == ' ' && !is_tag) {
                stack.pop();
                while (!stack.empty()){
                    sb.append(stack.pop());
                }
                sb.append(" ");
            }
        }
        while (!stack.empty()){
            sb.append(stack.pop());
        }
        System.out.println(sb);
    }
}
