import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int max;
	static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로

		map = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		max = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				bruteForcing(i, j);
			}
		}

		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void bruteForcing(int x, int y) {
		int total = 0;

		// ㅡ
		if (y + 3 <= M) {
			total += map[x][y];
			total += map[x][y + 1];
			total += map[x][y + 2];
			total += map[x][y + 3];
		}

		max = Math.max(max, total);
		total = 0;

		// ㅣ
		if (x + 3 <= N) {
			total += map[x][y];
			total += map[x + 1][y];
			total += map[x + 2][y];
			total += map[x + 3][y];
		}

		max = Math.max(max, total);
		total = 0;

		// ㅁ
		if (x + 1 <= N && y + 1 <= M) {
			total += map[x][y];
			total += map[x][y + 1];
			total += map[x + 1][y];
			total += map[x + 1][y + 1];
		}

		max = Math.max(max, total);
		total = 0;

		// ㄴ
		if (x + 2 <= N && y + 1 <= M) {
			total += map[x][y];
			total += map[x + 1][y];
			total += map[x + 2][y];
			total += map[x + 2][y + 1];
		}

		max = Math.max(max, total);
		total = 0;

		// ㄴ 반전
		if (x + 2 <= N && y + 1 <= M) {
			total += map[x][y + 1];
			total += map[x + 1][y + 1];
			total += map[x + 2][y + 1];
			total += map[x + 2][y];
		}

		max = Math.max(max, total);
		total = 0;

		// 긴 ㄴ
		if (x + 1 <= N && y + 2 <= M) {
			total += map[x][y];
			total += map[x + 1][y];
			total += map[x + 1][y + 1];
			total += map[x + 1][y + 2];
		}

		max = Math.max(max, total);
		total = 0;

		// 긴 ㄴ 반전
		if (x + 1 <= N && y + 2 <= M) {
			total += map[x][y + 2];
			total += map[x + 1][y + 2];
			total += map[x + 1][y + 1];
			total += map[x + 1][y];
		}
		max = Math.max(max, total);
		total = 0;

		// 긴 ㄱ
		if (x + 2 <= N && y + 1 <= M) {
			total += map[x][y];
			total += map[x][y + 1];
			total += map[x + 1][y + 1];
			total += map[x + 2][y + 1];
		}

		max = Math.max(max, total);
		total = 0;

		// 긴 ㄱ 반전
		if (x + 2 <= N && y + 1 <= M) {
			total += map[x][y + 1];
			total += map[x][y];
			total += map[x + 1][y];
			total += map[x + 2][y];
		}

		max = Math.max(max, total);
		total = 0;

		// ㄱ
		if (x + 1 <= N && y + 2 <= M) {
			total += map[x][y];
			total += map[x][y + 1];
			total += map[x][y + 2];
			total += map[x + 1][y + 2];
		}

		max = Math.max(max, total);
		total = 0;

		// ㄱ 반전
		if (x + 1 <= N && y + 2 <= M) {
			total += map[x][y];
			total += map[x + 1][y];
			total += map[x][y + 1];
			total += map[x][y + 2];
		}

		max = Math.max(max, total);
		total = 0;

		// ㄴ에 아래 ㅣ
		if (x + 2 <= N && y + 1 <= M) {
			total += map[x][y];
			total += map[x + 1][y];
			total += map[x + 1][y + 1];
			total += map[x + 2][y + 1];
		}

		max = Math.max(max, total);
		total = 0;

		// ㄴ에 아래 ㅣ 반전
		if (x + 2 <= N & y + 1 <= M) {
			total += map[x][y + 1];
			total += map[x + 1][y + 1];
			total += map[x + 1][y];
			total += map[x + 2][y];
		}

		max = Math.max(max, total);
		total = 0;

		// ㄱ에 아래 ㅡ
		if (x + 1 <= N && y + 2 <= M) {
			total += map[x][y];
			total += map[x][y + 1];
			total += map[x + 1][y + 1];
			total += map[x + 1][y + 2];
		}

		max = Math.max(max, total);
		total = 0;

		// ㄱ에 아래 ㅡ 반전
		if (x + 1 <= N && y + 2 <= M) {
			total += map[x][y + 1];
			total += map[x][y + 2];
			total += map[x + 1][y + 1];
			total += map[x + 1][y];
		}

		max = Math.max(max, total);
		total = 0;

		// ㅓ
		if (x + 2 <= N && y + 1 <= M) {
			total += map[x][y + 1];
			total += map[x + 1][y];
			total += map[x + 1][y + 1];
			total += map[x + 2][y + 1];
		}

		max = Math.max(max, total);
		total = 0;
		// ㅏ
		if (x + 2 <= N && y + 1 <= M) {
			total += map[x][y];
			total += map[x + 1][y];
			total += map[x + 1][y + 1];
			total += map[x + 2][y];
		}
		max = Math.max(max, total);
		total = 0;
		// ㅗ
		if (x + 1 <= N && y + 2 <= M) {
			total += map[x][y + 1];
			total += map[x + 1][y];
			total += map[x + 1][y + 1];
			total += map[x + 1][y + 2];
		}
		max = Math.max(max, total);
		total = 0;
		// ㅜ
		if (x + 1 <= N && y + 2 <= M) {
			total += map[x][y];
			total += map[x][y + 1];
			total += map[x][y + 2];
			total += map[x + 1][y + 1];
		}
		max = Math.max(max, total);
		total = 0;
	}

}
