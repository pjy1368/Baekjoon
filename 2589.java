import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	int cnt;

	Point(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}

}

public class Main {
	static int N, M;
	static char[][] map;
	static int[] rangeX = { -1, 0, 1, 0 };
	static int[] rangeY = { 0, 1, 0, -1 };
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new char[N][M];

		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'L') {
					BFS(i, j);
				}
			}
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void BFS(int x, int y) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(x, y, 0));

		boolean[][] visit = new boolean[N][M];
		visit[x][y] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();
			
			ans = Math.max(ans, p.cnt);
			
			int dx, dy;
			for (int i = 0; i < 4; i++) {
				dx = p.x + rangeX[i];
				dy = p.y + rangeY[i];

				if (dx < 0 || dy < 0 || dx >= N || dy >= M) {
					continue;
				}

				if (map[dx][dy] == 'W') {
					continue;
				}

				if (!visit[dx][dy]) {
					visit[dx][dy] = true;
					q.offer(new Point(dx, dy, p.cnt + 1));
				}
			}
		}
	}
}
