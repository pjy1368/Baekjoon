package no.jam1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static final int INF = 987654321;
	static int[][] arr;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		arr = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i != j) {
					arr[i][j] = INF;
				}
			}
		}
		
		// ����� ������� ����
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			arr[x][y] = arr[y][x] = 1;
		}

		visited = new boolean[N + 1];
		
		ArrayList<Integer> readerList = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (!visited[i]) {
				readerList.add(findReader(i));
			}
		}
		
		// ������ ���� ���� ��� ���.
		StringBuilder sb = new StringBuilder();
		sb.append(readerList.size() + "\n");

		Collections.sort(readerList);
		for (int i = 0; i < readerList.size(); i++) {
			sb.append(readerList.get(i) + "\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static int findReader(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);

		visited[start] = true;
		
		ArrayList<Integer> arrList = new ArrayList<>(); // start�� ����� ����
		arrList.add(start);

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i = 1; i <= N; i++) {
				if (arr[now][i] != INF && !visited[i]) {
					visited[i] = true;
					q.offer(i);
					arrList.add(i);
				}
			}
		}
		
		// �ǻ� ���� �ð��� �������� �÷��̵� �ͼ� �˰��� ����
		for (int k = 1; k <= N; k++) {
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (arr[i][j] > arr[i][k] + arr[k][j]) {
						arr[i][j] = arr[i][k] + arr[k][j];
					}
				}
			}
		}

		int idx = -1;
		int res = INF;

		for (int i = 1; i <= N; i++) {
			if (!arrList.contains(i)) {
				continue;
			}

			int total = 0;
			for (int j = 1; j <= N; j++) {
				if (!arrList.contains(j)) {
					continue;
				}

				total = Math.max(total, arr[i][j]);
			}
			
			// �ǻ� ���� �ð��� �ִ��� �ּ��� �ε����� ã�ƾ� ��.
			if (res > total) {
				res = total;
				idx = i;
			}
		}

		return idx;
	}

}
