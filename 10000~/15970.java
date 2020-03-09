import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, Integer> map = new HashMap<>();
		Scanner scan = new Scanner(System.in);
		int num = scan.nextInt(); // 점의 개수
		int point, color; // 점의 위치와 색깔
		
		for (int i = 0; i < num; i++) {
			point = scan.nextInt();
			color = scan.nextInt();
			map.put(point, color);
		}
		
		Iterator<Integer> it = map.keySet().iterator();
		int[] points = new int[num]; // map의 key를 정렬해서 담은 배열
		int count = 0;
		
		while (it.hasNext()) {
			points[count++] = it.next();
		}
		Arrays.sort(points);
		
		int total = 0; // 연결선 길이의 총합
		int leftLength = 0; // i 기준 왼쪽 탐색해서 얻은 길이
		int rightLength = 0; // i 기준 오른쪽 탐색해서 얻은 길이

		for (int i = 0; i < points.length; i++) {
			for (int j = 0; j < i; j++) { // i의 왼쪽 탐색
				if (map.get(points[i]).equals(map.get(points[j]))) {
					leftLength = points[i] - points[j];
				}
			}

			for (int k = i + 1; k < points.length; k++) { // i의 오른쪽 탐색
				if (map.get(points[i]).equals(map.get(points[k]))) {
					rightLength = points[k] - points[i];
					break;
				}
			}

			if (leftLength == 0 && rightLength != 0) {
				total += rightLength;
			} else if (leftLength != 0 && rightLength == 0) {
				total += leftLength;
			} else if (leftLength != 0 && rightLength != 0) {
				total += (leftLength > rightLength) ? rightLength : leftLength;
			}
			
			leftLength = rightLength = 0;
		}
		System.out.println(total);
		scan.close();
	}

}
