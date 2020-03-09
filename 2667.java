import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
	static int[] rangeX = { -1, 0, 1, 0 };
	static int[] rangeY = { 0, 1, 0, -1 };
	static int N;
	static int[][] map;
	static boolean[][] visit;
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		map = new int[N + 1][N + 1];
		visit = new boolean[N + 1][N + 1];
		cnt = 0;

		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(String.valueOf(str.charAt(j - 1)));
			}
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (!visit[i][j] && map[i][j] == 1) {
					DFS(i, j);
					cnt++;
				}
			}
		}

		Map<Integer, Integer> addr = new HashMap<>();
		for (int i = 2; i <= cnt + 1; i++) {
			addr.put(i, 0);
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (map[i][j] != 0) {
					addr.put(map[i][j], addr.get(map[i][j]) + 1);
				}
			}
		}

		
		List<Integer> list = new ArrayList<>(addr.values());
		Collections.sort(list);
		
		StringBuilder sb = new StringBuilder();
		sb.append(cnt + "\n");
		for (int i = 0; i < list.size(); i++) {
			sb.append(list.get(i) + "\n");
		}
		bw.write(sb.toString());
		bw.flush();
		br.close();
		bw.close();
	}

	public static void DFS(int x, int y) {
		visit[x][y] = true;
		map[x][y] += cnt + 1;
		int dx, dy;

		for (int i = 0; i < 4; i++) {
			dx = x + rangeX[i];
			dy = y + rangeY[i];

			if (dx < 1 || dy < 1 || dx > N || dy > N) {
				continue;
			}

			if (!visit[dx][dy] && map[dx][dy] == 1) {
				DFS(dx, dy);
			}
		}
	}

}
