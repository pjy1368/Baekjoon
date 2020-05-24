package no.jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Vector;

class Point {
	int r;
	int c;
	int s;

	Point(int r, int c, int s) {
		this.r = r;
		this.c = c;
		this.s = s;
	}
}

public class Main {
	static int N, M, K;
	static int[][] arr;
	static int[][] copyArr;

	static Point[] points;
	static boolean[] select;

	static Vector<Point> v;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		arr = new int[N + 1][M + 1];
		copyArr = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				copyArr[i][j] = arr[i][j];
			}
		}

		points = new Point[K];
		select = new boolean[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			points[i] = new Point(r, c, s);
		}

		v = new Vector<>();

		ans = Integer.MAX_VALUE;
		backTracking(0);

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	// 원래 배열로 복구
	public static void init() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				copyArr[i][j] = arr[i][j];
			}
		}
	}

	// 최솟값 구하기
	public static void calMin() {
		for (int i = 1; i <= N; i++) {
			int total = 0;
			for (int j = 1; j <= M; j++) {
				total += copyArr[i][j];
			}
			ans = Math.min(ans, total);
		}
	}

	// 순열
	public static void backTracking(int num) {
		if (num == K) {
			for (int i = 0; i < v.size(); i++) {
				spin(v.get(i));
			}
			calMin();

			init();
			return;
		}

		for (int i = 0; i < K; i++) {
			if (select[i]) {
				continue;
			}
			select[i] = true;
			v.add(points[i]);
			backTracking(num + 1);
			v.remove(v.size() - 1);
			select[i] = false;
		}

	}

	// 회전
	public static void spin(Point p) {
		int r = p.r;
		int c = p.c;
		int s = p.s;

		while (s > 0) {
			int i = r - s;

			int[][] copy = new int[4][50];

			copy[0][0] = copyArr[i + 1][c - s];

			int idx = 1;

			// 북쪽 가로줄
			for (int j = c - s; j < c + s; j++) {
				copy[0][idx++] = copyArr[i][j];
			}

			idx = 0;

			// 서쪽 세로줄
			for (int k = r - s; k < r + s; k++) {
				copy[1][idx++] = copyArr[k][c + s];
			}

			idx = 0;

			// 남쪽 가로줄
			for (int n = c - s + 1; n <= c + s; n++) {
				copy[2][idx++] = copyArr[r + s][n];
			}

			idx = 0;

			// 서쪽 세로줄
			for (int l = r - s + 2; l <= r + s; l++) {
				copy[3][idx++] = copyArr[l][c - s];
			}

			// copy 배열에 남은 북, 동, 남, 서 영역을 copyArr으로 옮긴다.
			for (int x = c - s; x <= copy[0].length + c - s; x++) {
				if (copy[0][x - (c - s)] == 0) {
					break;
				}

				copyArr[i][x] = copy[0][x - (c - s)];
			}

			for (int y = r - s + 1; y <= copy[1].length + r - s; y++) {
				if (copy[1][y - (r - s + 1)] == 0) {
					break;
				}

				copyArr[y][c + s] = copy[1][y - (r - s + 1)];
			}

			for (int w = c - s; w < copy[2].length + c - s; w++) {
				if (copy[2][w - (c - s)] == 0) {
					break;
				}

				copyArr[r + s][w] = copy[2][w - (c - s)];
			}

			for (int z = r - s + 1; z <= copy[3].length + r - s; z++) {
				if (copy[3][z - (r - s + 1)] == 0) {
					break;
				}

				copyArr[z][c - s] = copy[3][z - (r - s + 1)];
			}

			s--;
		}
	}

}