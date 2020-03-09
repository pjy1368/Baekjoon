import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] rangeX = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] rangeY = { -1, 0, 1, 1, 1, 0, -1, -1 };

	public static void DFS(int x, int y, int[][] map, boolean[][] visit, int w, int h) {
		visit[x][y] = true;
		int dx = 0; // 높이
		int dy = 0; // 너비

		for (int i = 0; i < 8; i++) {
			dx = x + rangeX[i];
			dy = y + rangeY[i];

			if (dx < 1 || dy < 1 || (dx == x && dy == y) || dx > h || dy > w) {
				continue;
			}

			if (!visit[dx][dy] && map[dx][dy] == 1) {
				DFS(dx, dy, map, visit, w, h);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = "";
		StringTokenizer st;

		while (!(input = br.readLine()).equals("0 0")) {
			st = new StringTokenizer(input);
			int w = Integer.parseInt(st.nextToken()); // 너비
			int h = Integer.parseInt(st.nextToken()); // 높이
			int cnt = 0;

			int[][] map = new int[h + 1][w + 1];
			boolean[][] visit = new boolean[h + 1][w + 1];

			for (int i = 1; i <= h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j <= w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 1; i <= h; i++) {
				for (int j = 1; j <= w; j++) {
					if (!visit[i][j] && map[i][j] == 1) {
						DFS(i, j, map, visit, w, h);
						cnt++;
					}
				}
			}
			bw.write(cnt + "\n");
		}
		;

		bw.flush();
		br.close();
		bw.close();
	}

}
