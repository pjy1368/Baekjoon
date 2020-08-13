package no.jam1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge {
	int start;
	int end;
	int weight;

	Edge(int start, int end, int weight) {
		this.start = start;
		this.end = end;
		this.weight = weight;
	}
}

public class Main {
	static int[] parent;
	static ArrayList<Edge> edgeList;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		parent = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			parent[i] = i;
		}

		st = new StringTokenizer(br.readLine());

		// 발전소가 있는 위치를 -1로 초기화.
		for (int i = 0; i < K; i++) {
			int idx = Integer.parseInt(st.nextToken());

			parent[idx] = -1;
		}

		edgeList = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			edgeList.add(new Edge(u, v, w));
		}

		// 드는 비용을 기준으로 오름차순 정렬
		Collections.sort(edgeList, (e1, e2) -> e1.weight - e2.weight);

		int ans = 0;

		// 크루스칼 알고리즘 수행
		for (int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);

			if (find(edge.start) != find(edge.end)) {
				ans += edge.weight;

				union(edge.start, edge.end);

				// 모든 도시가 발전소에 의해 전기 공급을 받고 있는 경우
				if (isAllConnect()) {
					break;
				}
			}

		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static boolean isAllConnect() {
		for (int i = 1; i < parent.length; i++) {
			if (parent[i] != -1) {
				return false;
			}
		}

		return true;
	}

	public static int find(int x) {
		if (parent[x] == -1) {
			return -1;
		}

		if (x == parent[x]) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			if (x == -1) {
				parent[y] = x;
			} else if (y == -1) {
				parent[x] = y;
			} else {
				if (x == -1 && y == -1) {
					return;
				} else {
					parent[y] = x;
				}
			}
		}
	}

}
