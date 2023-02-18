package algorithm.IM;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class q_영준이의_카드_카운팅 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            HashMap<Character, Set<String>> map = new HashMap<>();
            String cardInfo = br.readLine();
            Set<String> s = new HashSet<>();
            Set<String> d = new HashSet<>();
            Set<String> h = new HashSet<>();
            Set<String> c = new HashSet<>();
            map.put('S', s);
            map.put('D', d);
            map.put('H', h);
            map.put('C', c);
            for (int i = 0; i < cardInfo.length(); i = i + 3) {
                Character shape = cardInfo.charAt(i);
                String number = cardInfo.substring(i + 1, i + 3);
                Set<String> temp = map.get(shape);
                temp.add(number);
                map.put(shape, temp);
            }
            int S = map.get('S').size();
            int D = map.get('D').size();
            int H = map.get('H').size();
            int C = map.get('C').size();
            if (S + D + H + C != cardInfo.length() / 3) {
                System.out.println("#" + (t + 1) + " " + "ERROR");
            } else {
                System.out.println("#" + (t + 1) + " " + (13 - S) + " " + (13 - D) + " " + (13 - H) + " " + (13 - C));
            }
        }
    }
}