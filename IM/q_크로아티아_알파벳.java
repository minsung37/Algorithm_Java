package algorithm.IM;

import java.util.Scanner;

public class q_크로아티아_알파벳 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.next();

        String[] dic = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        for (int i = 0; i < dic.length; i++)
            word = word.replace(dic[i], "1");

        System.out.println(word.length());
    }
}