package no.jam1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] parent; // 유니온 파인드 루트 노드 배열
	static int[][] unit; // unit[x][y]의 거리는 r이다.

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			int N = Integer.parseInt(br.readLine());

			parent = new int[N];
			unit = new int[N][3];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());

				unit[i][0] = x;
				unit[i][1] = y;
				unit[i][2] = r;

				parent[i] = i;
			}

			int ans = N; // 처음에는 모두 1인 그룹을 형성.
			for (int i = 0; i < N; i++) {
				for (int j = i + 1; j < N; j++) {
					int x_dif = unit[i][0] - unit[j][0];
					int y_dif = unit[i][1] - unit[j][1];
					int r = unit[i][2] + unit[j][2];

					// 특정 두 정점의 통신 범위가 겹치는 경우
					if (x_dif * x_dif + y_dif * y_dif <= r * r) {
						if (find(i) != find(j)) {
							union(i, j); // 합집합 연산 수행
							ans--; // 1인 그룹 2개가 하나의 그룹을 형성하므로 ans를 1 줄여야 함.
						}
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

	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			if (x < y) {
				parent[y] = x;
			} else {
				parent[x] = y;
			}
		}
	}

}
