import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Point[] points = new Point[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			points[i] = new Point(x, y);
		}
		Arrays.sort(points, (p1, p2) -> p1.x - p2.x); // x 좌표를 기준으로 오름차순 정렬.

		// y 좌표를 기준으로 오름차순 정렬하되, y 좌표가 같다면 x 좌표를 기준으로 오름차순 정렬.
		// set 사용하는 이유 : 한 번 탐색한 점은 또 탐색하지 않기 위해서.
		TreeSet<Point> set = new TreeSet<>((p1, p2) -> ((p1.y == p2.y) ? p1.x - p2.x : p1.y - p2.y));

		set.add(points[0]);
		set.add(points[1]);

		// 첫 번째와 두 번째 좌표 사이의 거리를 최단 거리라고 가정.
		int ans = dist(points[0], points[1]);

		int start = 0;

		for (int i = 2; i < N; i++) {
			Point now = points[i];

			// i - 1번째에서 i번째로 라인을 이동하면서
			// points[i]와 i - 1번째에 속해 있던 set의 요소들 사이의 거리가
			// ans보다 크면 그 요소를 삭제함.
			while (start < i) {
				Point point = points[start];
				int k = now.x - point.x;

				if (k * k > ans) {
					set.remove(point);
					start++;
				} else {
					break;
				}
			}

			// ans는 거리의 제곱이 되어 있는 상태이므로 루트를 씌어 준다.
			// 다만 근사값의 오차를 고려하여 넉넉하게 1을 더해 준다.
			int d = (int) Math.sqrt((double) ans) + 1;

			Point from = new Point(-100000, now.y - d);
			Point to = new Point(100000, now.y + d);

			// y좌표 기준으로 now.y - d부터 now.y + d까지 해당하는 점들
			// 사이의 거리를 구하면서 ans와 비교한다.
			for (Point point : set.subSet(from, to)) {
				ans = Math.min(ans, dist(now, point));
			}

			// 기존의 있던 set과의 비교 작업을 마쳤으면,
			// now도 set에 넣어주고 라인을 다음으로 이동함.
			set.add(now);
		}

		bw.write(ans + "\n");
		bw.close();
		br.close();
	}

	// 두 점 사이의 거리의 제곱.
	public static int dist(Point p, Point q) {
		return (p.x - q.x) * (p.x - q.x) + (p.y - q.y) * (p.y - q.y);
	}

}