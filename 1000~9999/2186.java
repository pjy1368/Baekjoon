import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	char input;
	int index;

	Point(int x, int y, int index, char input) {
		this.x = x;
		this.y = y;
		this.index = index;
		this.input = input;
	}
}

public class Main {
	static int[] rangeX;
	static int[] rangeY;
	static int N, M, K;
	static char[][] map;
	static int[][][] dp;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로
		K = Integer.parseInt(st.nextToken()); // 갈 수 있는 칸의 개수

		map = new char[N][M];
		for (int i = 0; i < N; i++) {
			String input = br.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		String word = br.readLine();
		dp = new int[N][M][word.length()];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				for (int k = 0; k < word.length(); k++) {
					dp[i][j][k] = -1;
				}
			}
		}

		if (K == 1) {
			rangeX = new int[] { -1, 0, 1, 0 };
			rangeY = new int[] { 0, 1, 0, -1 };
		} else if (K == 2) {
			rangeX = new int[] { -2, -1, 0, 0, 1, 2, 0, 0 };
			rangeY = new int[] { 0, 0, 1, 2, 0, 0, -1, -2 };
		} else if (K == 3) {
			rangeX = new int[] { -3, -2, -1, 0, 0, 0, 1, 2, 3, 0, 0, 0 };
			rangeY = new int[] { 0, 0, 0, 1, 2, 3, 0, 0, 0, -1, -2, -3 };
		} else if (K == 4) {
			rangeX = new int[] { -4, -3, -2, -1, 0, 0, 0, 0, 1, 2, 3, 4, 0, 0, 0, 0 };
			rangeY = new int[] { 0, 0, 0, 0, 1, 2, 3, 4, 0, 0, 0, 0, -1, -2, -3, -4 };
		} else {
			rangeX = new int[] { -5, -4, -3, -2, -1, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 0, 0, 0, 0, 0 };
			rangeY = new int[] { 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 0, 0, 0, 0, 0, -1, -2, -3, -4, -5 };
		}

		ans = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == word.charAt(0)) {
					ans += DFS(i, j, 1, word);
				}
			}
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static int DFS(int x, int y, int Idx, String word) {
		if (Idx >= word.length()) {
			return 1;
		}
		
		if (dp[x][y][Idx] != -1) {
			return dp[x][y][Idx];
		}

		dp[x][y][Idx] = 0;
		for (int i = 0; i < 4 * K; i++) {
			int nx = x + rangeX[i];
			int ny = y + rangeY[i];

			if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
				continue;
			}

			if (map[nx][ny] != word.charAt(Idx)) {
				continue;
			}

			dp[x][y][Idx] += DFS(nx, ny, Idx + 1, word);
		}
		return dp[x][y][Idx];
	}

}
