package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> a;
	static int v, e;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		v = Integer.parseInt(br.readLine());
		e = Integer.parseInt(br.readLine());

		a = new ArrayList<>();
		for (int i = 0; i <= v; i++) {
			a.add(new ArrayList<>());
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());

			a.get(t).add(f);
			a.get(f).add(t);
		}

		ans = 0;
		BFS(1);

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void BFS(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		boolean[] visited = new boolean[v + 1];
		visited[start] = true;

		while (!q.isEmpty()) {
			int now = q.poll();

			for (int i : a.get(now)) {
				if (!visited[i]) {
					q.offer(i);
					visited[i] = true;
					ans++;
				}
			}
		}
	}

}
