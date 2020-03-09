import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Graph {
	int node;
	int weight;

	Graph(int node, int weight) {
		this.node = node;
		this.weight = weight;
	}
}

public class Main {
	static ArrayList<ArrayList<Graph>> a;
	static int v, e;
	static int[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		a = new ArrayList<>();
		v = Integer.parseInt(br.readLine());

		for (int i = 0; i <= v; i++) {
			a.add(new ArrayList<>());
		}

		for (int i = 0; i < v - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int f = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			a.get(t).add(new Graph(f, w));
			a.get(f).add(new Graph(t, w));
		}

		dist = new int[v + 1];
		bfs(1, a.get(1).get(0).weight);
		
		int start = 1;
		for (int i = 2; i <= v; i++) {
			if (dist[start] < dist[i]) {
				start = i;
			}
		}

		dist = new int[v + 1];
		bfs(start, a.get(start).get(0).weight);
		Arrays.sort(dist);

		bw.write(dist[v] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void bfs(int start, int weight) {
		Queue<Graph> q = new LinkedList<>();
		q.add(new Graph(start, weight));
		boolean[] visit = new boolean[v + 1];
		visit[start] = true;

		while (!q.isEmpty()) {
			Graph g = q.poll();

			for (int i = 0; i < a.get(g.node).size(); i++) {
				Graph item = a.get(g.node).get(i);
				if (!visit[item.node]) {
					visit[item.node] = true;
					dist[item.node] = dist[g.node] + item.weight;
					q.add(new Graph(item.node, item.weight));
				}
			}

		}
	}
}
