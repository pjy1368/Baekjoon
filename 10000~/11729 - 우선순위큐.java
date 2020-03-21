package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());

			if (temp == 0) {
				if (pq.isEmpty()) {
					bw.write("0\n");
				} else {
					bw.write((pq.poll()) + "\n");
				}
			} else {
				pq.offer(temp);
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
