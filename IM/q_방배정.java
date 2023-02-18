package algorithm.IM;

import java.util.HashMap;
import java.util.Scanner;


public class q_방배정 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<String, Double> map = new HashMap<String, Double>();
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		
		// 
		String key = "";
		for (int i = 0; i < n; i++) {
			String gender = scanner.next();
			String group = scanner.next();
			key = gender + group;
			try {
				Double count = map.get(key);
				map.put(key, count + 1);
			} catch (Exception e) {
				map.put(key, 1.0);
			}
		}
		
		// 방 계산
		int result = 0;
        for(String KEY : map.keySet()) {
            Double value = map.get(KEY);
            result = result + (int) Math.ceil(value / k);
        }
        System.out.println(result);
	}
}
