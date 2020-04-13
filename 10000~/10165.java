package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.StringTokenizer;
import java.util.Vector;

class Bus implements Comparable<Bus> {
	int routeNum;
	int start;
	int end;

	Bus(int routeNum, int start, int end) {
		this.routeNum = routeNum;
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Bus o) {
		if (start == o.start) {
			return o.end - end;
		}
		return start - o.start;
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine()); // 버스 정류소의 개수
		int M = Integer.parseInt(br.readLine()); // 버스 노선의 수

		Vector<Bus> v = new Vector<>();
		int back = 0;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			v.add(new Bus(i + 1, A, B));
			if (v.get(i).start > v.get(i).end) {
				back = Math.max(back, v.get(i).end);
				v.get(i).end += N;
			}
		}
		Collections.sort(v);

		Deque<Bus> deq = new ArrayDeque<>();
		for (Bus b : v) {
			if (deq.isEmpty() || deq.getLast().end < b.end) {
				deq.addLast(b);
			}
		}

		while (!deq.isEmpty() && deq.getFirst().end <= back) {
			deq.removeFirst();
		}

		Vector<Bus> res = new Vector<>();
		while (!deq.isEmpty()) {
			res.add(deq.pop());
		}

		Collections.sort(res, new Comparator<Bus>() {

			@Override
			public int compare(Bus o1, Bus o2) {
				return o1.routeNum - o2.routeNum;
			}

		});

		for (Bus b : res) {
			bw.write(b.routeNum + " ");
		}

		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();

	}
}