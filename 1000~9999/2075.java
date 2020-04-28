package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());

				if (pq.size() < N) {
					pq.offer(temp);
				} else {
					if (pq.peek() < temp) {
						pq.poll();
						pq.offer(temp);
					}
				}
			}
		}

		bw.write(pq.poll() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
