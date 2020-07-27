package no.jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = null;
		int T = Integer.parseInt(br.readLine()); // �׽�Ʈ ���̽��� ����

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			int N = Integer.parseInt(br.readLine()); // �迭�� ũ��

			sb.append(((N + 1) / 2) + "\n"); // �߾Ӱ��� ���� ���

			int cnt = 0; // �� ���� ���� ���� �뵵

			for (int i = 0; i < N; i++) {
				if (i % 10 == 0) {
					st = new StringTokenizer(br.readLine());
				}

				int x = Integer.parseInt(st.nextToken());

				// �Է¹޴� ������ �ϳ��� ���ʴ�� ����, �����ʿ� �ִ� ����.
				if (maxHeap.size() == minHeap.size()) {
					maxHeap.offer(x);
				} else {
					minHeap.offer(x);
				}

				// maxHeap�� �߾Ӱ� ������ ���ڸ� ������ ����.
				if (!minHeap.isEmpty()) {
					if (maxHeap.peek() > minHeap.peek()) {
						int t1 = maxHeap.poll();
						int t2 = minHeap.poll();

						maxHeap.offer(t2);
						minHeap.offer(t1);
					}
				}

				// �ε����� 0���� �����ϹǷ� ¦�� ��° �ε����� Ž���� ������
				// �߾Ӱ��� ����ϸ� ��.
				if (i % 2 == 0) {
					// �� ���� �ִ� 10���� ����.
					if (cnt == 9 || i == N - 1) {
						sb.append(maxHeap.peek() + "\n");
						cnt = 0;
					} else {
						sb.append(maxHeap.peek() + " ");
					}
					cnt++;
				}
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}