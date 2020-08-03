package no.jam1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 987654321;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[][] dist = new int[N + 1][N + 1]; // ���� �־��� �迭
		int[][] arr = new int[N + 1][N + 1]; // �÷��̵� �ͼ� �˰��� ���� �� �迭
		boolean[][] check = new boolean[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				dist[i][j] = Integer.parseInt(st.nextToken());
				arr[i][j] = dist[i][j];
			}
		}

		// �÷��̵� �ͼ� �˰��� ����
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					// i == k �� k == j�� ��츦 �Ÿ��� ������
					// ���İ��� �ʴ� ������ ������ ���ְ� �� �� ����.
					// ���� ��� i = 1, k = 1, j = 2�� ���
					// 1���� 2�� ���� ���� ���İ��� ������ ���µ�
					// 1 -> 2 ������ ���ְ� �� �� ����.
					if (i == j || i == k || k == j) {
						continue;
					}

					// dist�� �÷��̵� �ͼ� �˰����� �̹� ������ �����ε�
					// �� �ִܰŸ��� �ʱ�ȭ�� �κ��� ����� ���.
					if (dist[i][j] > dist[i][k] + dist[k][j]) {
						bw.write("-1\n");
						bw.flush();
						bw.close();
						br.close();
						return;
					}

					// ���İ��� ������ ���ؼ� �ִܰŸ��� �ʱ�ȭ�� �κ��� �ִٸ�
					// i -> j ������ ����.
					if (dist[i][j] == dist[i][k] + dist[k][j]) {
						arr[i][j] = INF;
					}
				}
			}
		}

		int ans = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (arr[i][j] != INF && i != j && !check[i][j]) {
					ans += arr[i][j];
					check[i][j] = check[j][i] = true;
				}
			}
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
