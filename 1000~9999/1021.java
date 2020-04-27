package no.jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Deque<Integer> deque = new ArrayDeque<>();
		for (int i = 1; i <= N; i++) {
			deque.offer(i);
		}

		st = new StringTokenizer(br.readLine());
		int cnt = 0;
		while (st.hasMoreTokens()) {
			int temp = Integer.parseInt(st.nextToken());

			if (deque.getFirst() == temp) {
				deque.removeFirst();
			} else {
				int midDif = deque.size() / 2;
				
				Iterator<Integer> it = deque.iterator();
				int tempDif = 0;
				while(it.hasNext()) {
					int pos = it.next();
					if(pos == temp) {
						break;
					}
					tempDif++;
				}
				
				while (deque.getFirst() != temp) {
					if (tempDif <= midDif) {
						int x = deque.removeFirst();
						deque.addLast(x);
					} else {
						int x = deque.removeLast();
						deque.addFirst(x);
					}
					cnt++;
				}
				deque.removeFirst();
			}
		}

		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}