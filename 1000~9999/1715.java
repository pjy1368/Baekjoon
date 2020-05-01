package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		if (N == 1) {
			int temp = Integer.parseInt(br.readLine());
			bw.write(temp + "\n");
			bw.close();
			br.close();
			return;
		}

		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());
			pq.offer(temp);
		}

		long sum = 0;
		while (true) {
			int A = pq.poll();

			if (pq.isEmpty()) {
				bw.write(sum + "\n");
				break;
			}

			int B = pq.poll();
			sum += (A + B);
			pq.offer(A + B);
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
