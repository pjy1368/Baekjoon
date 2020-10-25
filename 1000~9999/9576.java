import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			Point[] points = new Point[M + 1];
			for (int i = 1; i <= M; i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				points[i] = new Point(a, b);
			}

			// b를 기준으로 오름차순 정렬하되, b가 같을 경우
			// a를 기준으로 오름차순 정렬한다.
			Arrays.sort(points, 1, M + 1, (p1, p2) -> (p1.y == p2.y) ? p1.x - p2.x : p1.y - p2.y);

			int ans = 0;
			boolean[] check = new boolean[N + 1];
			for (int i = 1; i <= M; i++) {
				int a = points[i].x;
				int b = points[i].y;

				// 해당하는 범위 내에서
				// 가능한 가장 작은 번호의 책부터 뽑는다.
				for (int j = a; j <= b; j++) {
					if (!check[j]) {
						check[j] = true;
						ans++;
						break;
					}
				}
			}
			sb.append(ans + "\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}