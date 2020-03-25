package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point {
	int pos;
	int time;

	Point(int pos, int time) {
		this.pos = pos;
		this.time = time;
	}
}

public class Main {
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		if (N == K) {
			bw.write("0\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}

		if (N > K) {
			bw.write((N - K) + "\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}

		ans = 0;
		BFS(N, K);

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void BFS(int N, int K) {
		Queue<Point> q = new LinkedList<>();
		q.offer(new Point(N, 0));
		boolean[] visited = new boolean[100001];
		visited[N] = true;

		while (!q.isEmpty()) {
			Point p = q.poll();

			if (p.pos == K) {
				ans = p.time;
				return;
			}
			
			// 큐에 들어가는 순서에 따라 걸리는 시간이 달라질 수 있음을 꼭 기억하자.
			if (p.pos - 1 >= 0 && !visited[p.pos - 1]) {
				visited[p.pos - 1] = true;
				q.offer(new Point(p.pos - 1, p.time + 1));
			}

			if (p.pos * 2 <= 100000 && !visited[p.pos * 2]) {
				visited[p.pos * 2] = true;
				q.offer(new Point(p.pos * 2, p.time));
			}

			if (p.pos + 1 <= 100000 && !visited[p.pos + 1]) {
				visited[p.pos + 1] = true;
				q.offer(new Point(p.pos + 1, p.time + 1));
			}
		}
	}

}