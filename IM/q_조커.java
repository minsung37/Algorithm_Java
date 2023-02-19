package algorithm.IM;

import java.io.IOException;

public class q_조커 {
    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        List<Integer> cardList = new ArrayList<>();
//        List<Integer> result = new ArrayList<>();
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int zeroCount = 0;
//        for (int i = 0; i < n; i++) {
//            int number = Integer.parseInt(st.nextToken());
//            if (number == 0)
//                zeroCount++;
//            else
//                cardList.add(number);
//        }
//        int[] cardArray = cardList.stream().mapToInt(i->i).toArray();
//        Arrays.sort(cardArray);
//        int length = 0;
//        for (int i = 0; i < cardArray.length - 1; i++) {
//            if (cardArray[i + 1] - cardArray[i] == 1) {
//                length++;
//            } else {
//                if (length > 0) {
//                    result.add(length);
//                    length = 0;
//                }
//            }
//        }
//        if (length > 0)
//            result.add(length);
//        int[] resultArray = result.stream().mapToInt(i->i).toArray();
//        Integer[] tmp = Arrays.stream(resultArray).boxed().toArray(Integer[]::new);
//        Arrays.sort(tmp, Comparator.reverseOrder());
//
//        int answer = 0;
//        int copyZoreCount = zeroCount;
//        for (int i = 0; i < copyZoreCount; i++) {
//            if (i < tmp.length) {
//                answer = answer + tmp[i] + 1;
//                zeroCount--;
//            } else {
//                break;
//            }
//        }
//        System.out.println(answer + zeroCount);
    }
}
