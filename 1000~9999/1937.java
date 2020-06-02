package no.jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] rangeX = { -1, 0, 1, 0 };
	static int[] rangeY = { 0, 1, 0, -1 };
	static int N;
	static int[][] map; // �볪�� ��
	static int[][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		dp = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int ans = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				ans = Math.max(ans, DFS(i, j));
			}
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static int DFS(int x, int y) {
		// dp�� ����� ���� ���� ��� �� ���� ��ȯ.
		if (dp[x][y] != 0) {
			return dp[x][y];
		}
		
		// �Ǵٰ� �볪�� ������ �ּ��� 1���� �� �� �����Ƿ�
		// dp[x][y] = 1�� �ʱ�ȭ �� �� ����.
		dp[x][y] = 1;

		int dx, dy;
		// �����¿� �˻�.
		for (int i = 0; i < 4; i++) {
			dx = x + rangeX[i];
			dy = y + rangeY[i];
			
			// �������� ����� ��� continue.
			if (dx < 0 || dy < 0 || dx >= N || dy >= N) {
				continue;
			}
			
			// ���� �볪�� ������ �� ���� ���� �볪���� �ִ� ���.
			if (map[x][y] < map[dx][dy]) {
				// �����¿� �߿��� ���� �������� ������ �� �ִ� �Ⱓ�� ����Ѵ�.
				dp[x][y] = Math.max(dp[x][y], DFS(dx, dy) + 1);
				DFS(dx, dy);
			}
		}
		return dp[x][y];
	}

}