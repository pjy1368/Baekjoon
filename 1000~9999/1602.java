package no.jam1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static final int INF = 987654321;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		int[][] dist = new int[N + 1][N + 1]; // ���� ������ �ִܰŸ� �ð�
		int[][] cost = new int[N + 1][N + 1]; // ���� ������ �ִܰŸ� �ð�
		int[] dog = new int[N + 1];
		Integer[] lowDogTimeArr = new Integer[N + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			dog[i] = Integer.parseInt(st.nextToken());
			lowDogTimeArr[i] = i;
		}

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dist[i][j] = (i == j) ? 0 : INF;
				cost[i][j] = (i == j) ? dog[i] : INF;
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());

			dist[a][b] = dist[b][a] = d;
			cost[a][b] = cost[b][a] = d + Math.max(dog[a], dog[b]);
		}

		// ������ ���ع޴� �ð��� ���� ���� ������� ����
		Arrays.sort(lowDogTimeArr, 1, N + 1, new Comparator<Integer>() {

			@Override
			public int compare(Integer arg0, Integer arg1) {
				return dog[arg0] - dog[arg1];
			}

		});

		// �÷��̵� �ͼ� �˰���
		int idx = -1;
		for (int k = 1; k <= N; k++) {
			// ���İ��� ������ ������ ���ع޴� �ð��� ���� ���� ������ ����
			idx = lowDogTimeArr[k];
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (dist[i][idx] != INF && dist[idx][j] != INF) {
						// �Ϲ����� �ִܰŸ� �ʱ�ȭ ��
						if (dist[i][j] > dist[i][idx] + dist[idx][j]) {
							dist[i][j] = dist[i][idx] + dist[idx][j];
						}

						// ������ i, k, j �� ������ ���ع޴� �ð��� ���� �� ������
						// �������� ��뿡 �ð��� �߰��� ���� ��.
						if (cost[i][j] > dist[i][j] + Math.max(dog[i], Math.max(dog[idx], dog[j]))) {
							cost[i][j] = dist[i][j] + Math.max(dog[i], Math.max(dog[idx], dog[j]));
						}
					}
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		while (Q-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			sb.append(((cost[a][b] == INF) ? "-1" : cost[a][b]) + "\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}
