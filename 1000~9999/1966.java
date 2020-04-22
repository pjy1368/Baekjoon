package no.jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Print {
	int major;
	int num;

	Print(int major, int num) {
		this.major = major;
		this.num = num;
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			Queue<Print> q = new LinkedList<>();
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				int major = Integer.parseInt(st.nextToken());
				q.offer(new Print(major, i));
			}

			int cnt = 1;
			while (!q.isEmpty()) {
				Print p1 = q.poll();

				Iterator<Print> it = q.iterator();
				boolean flag = false;
				while (it.hasNext()) {
					if (p1.major < it.next().major) {
						flag = true;
						break;
					}
				}

				if (flag) {
					q.offer(p1);
				} else {
					if (p1.num == M) {
						bw.write(cnt + "\n");
						break;
					}
					cnt++;
				}
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

}