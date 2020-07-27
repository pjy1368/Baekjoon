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
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스의 개수

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
			PriorityQueue<Integer> minHeap = new PriorityQueue<>();
			int N = Integer.parseInt(br.readLine()); // 배열의 크기

			sb.append(((N + 1) / 2) + "\n"); // 중앙값의 개수 출력

			int cnt = 0; // 줄 간격 띄우기 위한 용도

			for (int i = 0; i < N; i++) {
				if (i % 10 == 0) {
					st = new StringTokenizer(br.readLine());
				}

				int x = Integer.parseInt(st.nextToken());

				// 입력받는 값들을 하나씩 차례대로 왼쪽, 오른쪽에 넣는 느낌.
				if (maxHeap.size() == minHeap.size()) {
					maxHeap.offer(x);
				} else {
					minHeap.offer(x);
				}

				// maxHeap은 중앙값 이하의 숫자만 갖도록 조정.
				if (!minHeap.isEmpty()) {
					if (maxHeap.peek() > minHeap.peek()) {
						int t1 = maxHeap.poll();
						int t2 = minHeap.poll();

						maxHeap.offer(t2);
						minHeap.offer(t1);
					}
				}

				// 인덱스는 0부터 시작하므로 짝수 번째 인덱스를 탐색할 때마다
				// 중앙값을 출력하면 됨.
				if (i % 2 == 0) {
					// 한 줄의 최대 10개만 가능.
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