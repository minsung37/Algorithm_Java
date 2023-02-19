package algorithm.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q_안경이_없어 {

    public static String zeroHole = "CEFGHIJKLMNSTUVWXYZ";
    public static String oneHole = "ADOPQR";
    public static String twoHole = "B";

    public static String CheckWord(String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (zeroHole.contains(word.substring(i, i + 1)))
                sb.append("0");
            else if (oneHole.contains(word.substring(i, i + 1)))
                sb.append("1");
            else if (twoHole.contains(word.substring(i, i + 1)))
                sb.append("2");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            if (CheckWord(st.nextToken()).equals(CheckWord(st.nextToken())))
                System.out.printf("#%d SAME\n", t + 1);
            else
                System.out.printf("#%d DIFF\n", t + 1);
        }
    }
}
