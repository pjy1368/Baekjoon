package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

class Number implements Comparable<Number> {
	int num;

	Number(int num) {
		this.num = num;
	}

	@Override
	public int compareTo(Number o) {
		// TODO Auto-generated method stub
		int x = Math.abs(num);
		int y = Math.abs(o.num);
		if (x == y) {
			return num - o.num;
		}

		if (x < y) {
			return -1;
		} else {
			return 1;
		}

	}

}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		PriorityQueue<Number> pq = new PriorityQueue<>();
		while (N-- > 0) {
			int x = Integer.parseInt(br.readLine());
			if (x == 0) {
				if (pq.isEmpty()) {
					bw.write("0\n");
					continue;
				}

				Number res = pq.poll();
				bw.write(res.num + "\n");
			} else {
				pq.offer(new Number(x));
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}