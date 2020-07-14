package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int end;
	int weight;

	Node(int end, int weight) {
		this.end = end;
		this.weight = weight;
	}

	@Override
	public int compareTo(Node o) {
		return weight - o.weight;
	}

}

public class Main {
	static int v, e, k;
	static ArrayList<ArrayList<Node>> a;
	static int[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		v = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());

		k = Integer.parseInt(br.readLine());

		a = new ArrayList<>();
		dist = new int[v + 1];

		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int i = 0; i <= v; i++) {
			a.add(new ArrayList<>());
		}
		
		// 단방향 인접 리스트 구현.
		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			// start에서 end로 가는 weight (가중치)
			a.get(start).add(new Node(end, weight));
		}

		dijkstra(k);
		
		// 출력 부분
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= v; i++) {
			if (dist[i] == Integer.MAX_VALUE) {
				sb.append("INF\n");
			} else {
				sb.append(dist[i] + "\n");
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
	
	// 다익스트라 알고리즘
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		boolean[] check = new boolean[v + 1];
		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node curNode = pq.poll();
			int cur = curNode.end;

			if (!check[cur]) {
				check[cur] = true;

				for (Node node : a.get(cur)) {
					if (dist[node.end] > dist[cur] + node.weight) {
						dist[node.end] = dist[cur] + node.weight;
						pq.add(new Node(node.end, dist[node.end]));
					}
				}
			}
		}
	}
}