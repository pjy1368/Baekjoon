package no.jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] indegree = new int[N + 1];
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			a.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int first = Integer.parseInt(st.nextToken());
			int last = Integer.parseInt(st.nextToken());

			a.get(first).add(last);
			indegree[last]++; // Ư�� ������ ��ȣ���� ���� Ǯ����ϴ� ������ ����
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) { // ���� Ǯ����ϴ� ������ ���� ���
				pq.offer(i);
			}
		}

		StringBuilder sb = new StringBuilder();
		while (!pq.isEmpty()) {
			int now = pq.poll();
			sb.append(now + " ");

			// now�� ����� ������ �ִ��� Ȯ��.
			for (int next : a.get(now)) {
				// now�� �ش��ϴ� ������ Ǯ���⶧����
				// next���� ���� Ǯ����ϴ� ������ ������ 1�� �پ��.
				indegree[next]--;

				// ���� Ǯ����ϴ� ������ ���� ���
				// ���Ӱ� ť�� �����͸� ����ִ´�.
				if (indegree[next] == 0) {
					pq.offer(next);
				}
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}