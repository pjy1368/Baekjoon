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
	static int v;
	static int e;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		a = new ArrayList<>();

		v = Integer.parseInt(br.readLine()); // 정점의 개수
		e = v - 1; // 경로의 개수

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

		int[] parents = new int[v + 1];
		bfs(parents, v, 1);

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= v; i++) {
			sb.append(parents[i] + "\n");
		}

		bw.write(sb.toString());
		bw.close();
		br.close();
	}

	public static void dfs(int[] parents, int n, int start, int parent) {
		parents[start] = parent;
		for (int item : a.get(start)) {
			if (item != parent) {
				dfs(parents, n, item, start);
			}
		}
	}

	public static void bfs(int[] parents, int n, int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		parents[start] = 1;

		while (!q.isEmpty()) {
			int parent = q.poll();

			for (int item : a.get(parent)) {
				if (parents[item] == 0) {
					parents[item] = parent;
					q.offer(item);
				}
			}
		}
	}

}
