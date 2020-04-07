package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[][] arr = new int[N + 1][M + 1];
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] part = partialSum(arr);

		int K = Integer.parseInt(br.readLine());
		while (K-- > 0) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			bw.write(gridSum(part, i, j, x, y) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static int[][] partialSum(int[][] arr) {
		int[][] ret = new int[arr.length][arr[0].length];

		for (int i = 1; i < ret.length; i++) {
			ret[i][1] = arr[i][1];
			for (int j = 2; j < ret[0].length; j++) {
				ret[i][j] += ret[i][j - 1] + arr[i][j];
			}
		}

		for (int i = 1; i < ret[0].length; i++) {
			for (int j = 2; j < ret.length; j++) {
				ret[j][i] += ret[j - 1][i];
			}
		}

		return ret;
	}

	public static int gridSum(int[][] part, int y1, int x1, int y2, int x2) {
		int ret = part[y2][x2];

		if (y1 > 0) {
			ret -= part[y1 - 1][x2];
		}

		if (x1 > 0) {
			ret -= part[y2][x1 - 1];
		}

		if (y1 > 0 && x1 > 0) {
			ret += part[y1 - 1][x1 - 1];
		}

		return ret;
	}
}