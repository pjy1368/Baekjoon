import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
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
	static int[] rangeX = { -1, 0, 1, 0 };
	static int[] rangeY = { 0, 1, 0, -1 };
	static int R, C;
	static char[][] map;
	static Set<Character> set; // 알파벳 중복 체크
	static int ans = 1;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken()); // 세로
		C = Integer.parseInt(st.nextToken()); // 가로

		map = new char[R + 1][C + 1];
		for (int i = 1; i <= R; i++) {
			String input = br.readLine();
			for (int j = 1; j <= C; j++) {
				map[i][j] = input.charAt(j - 1);
			}
		}

		set = new HashSet<>();
		set.add(map[1][1]);
		DFS(new Point(1, 1, 1));

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void DFS(Point p) {
		int dx, dy;
		for (int i = 0; i < 4; i++) {
			dx = p.x + rangeX[i];
			dy = p.y + rangeY[i];

			if (dx < 1 || dy < 1 || dx > R || dy > C) {
				continue;
			}

			if (!set.contains(map[dx][dy])) {
				set.add(map[dx][dy]);
				ans = Math.max(ans, p.cnt + 1);
				DFS(new Point(dx, dy, p.cnt + 1));
				set.remove(map[dx][dy]);
			}
		}
	}

}
