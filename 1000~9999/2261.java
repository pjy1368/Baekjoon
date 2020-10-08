import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		ArrayList<Point> arrList = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());

			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			arrList.add(new Point(x, y));
		}
		Collections.sort(arrList, (p1, p2) -> p1.x - p2.x); // x좌표 기준으로 오름차순 정렬.

		bw.write(closestPair(arrList, 0, N - 1) + "\n");
		bw.close();
		br.close();
	}

	// 두 점 사이의 거리의 제곱.
	public static int dist(Point p, Point q) {
		return (p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y);
	}

	// 완전 탐색으로 가장 가까운 거리 찾기.
	static int bruteForce(ArrayList<Point> arrList, int start, int end) {
		int minDist = Integer.MAX_VALUE;
		for (int i = start; i < end; i++) {
			for (int j = i + 1; j <= end; j++) {
				int k = dist(arrList.get(i), arrList.get(j));
				minDist = Math.min(k, minDist);
			}
		}

		return minDist;
	}

	public static int closestPair(ArrayList<Point> arrList, int start, int end) {
		int n = end - start + 1;

		// n이 3이하면 완전탐색으로 가장 가까운 두 점 사이의 거리를 찾음.
		if (n <= 3) {
			return bruteForce(arrList, start, end);
		}

		int mid = (start + end) / 2;

		// 중앙선을 기준으로 왼쪽 점들 중 가장 작은 거리(k1)
		// 오른쪽 점들 중 가장 작은 거리 (k2)
		// min(k1, k2)를 구하면 됨.
		int d = Math.min(closestPair(arrList, start, mid), closestPair(arrList, mid + 1, end));

		// 중앙선을 기준으로 양쪽으로 d 거리 이내에 들어오는 점들만 보면 됨.
		// 그리고 y좌표를 기준으로 오름차순 정렬.
		ArrayList<Point> band = new ArrayList<>();
		for (int i = start; i <= end; i++) {
			int t = arrList.get(mid).x - arrList.get(i).x;

			if (t * t < d) {
				band.add(arrList.get(i));
			}
		}
		Collections.sort(band, (p1, p2) -> p1.y - p2.y);

		// y좌표를 기준으로 오름차순 정렬된 band의 각 요소(P1, P2, ...)는
		// 자기보다 큰 요소만 보면서 거리를 측정함.
		for (int i = 0; i < band.size() - 1; i++) {
			for (int j = i + 1; j < band.size(); j++) {
				int t = band.get(j).y - band.get(i).y;

				if (t * t < d) {
					d = Math.min(d, dist(band.get(i), band.get(j)));
				} else { // y 좌표 기준으로 오름차순 정렬되어있으므로 d보다 거리가 큰 순간이 오면 반복문 종료.
					break;
				}
			}
		}

		return d;
	}

}