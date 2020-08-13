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

		// ������ �� �о��,
		// N�� M�� ������ 1�� ���� ���� �ʿ��ϴ�.
		N++;
		M++;

		edgeList = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			edgeList.add(new Edge(A, B, C));
		}

		parent = new int[N];
		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}

		Collections.sort(edgeList, (e1, e2) -> e1.weight - e2.weight); // ��������

		int cost1 = 0;

		// ����ġ�� 0�� ���������̶�� �����Ƿ� �������� �����Ѵ�� MST�� �����ϸ�
		// �־��� ��ΰ� �ȴ�.
		for (int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);

			if (find(edge.start) != find(edge.end)) {
				union(edge.start, edge.end);

				if (edge.weight == 0) {
					cost1++;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			parent[i] = i;
		}

		int cost2 = 0;

		// ����ġ�� 0�� ���������̶�� �����Ƿ� �������� ������ �Ͱ� �ݴ�� MST�� �����ϸ�
		// �ֻ��� ��ΰ� �ȴ�.
		for (int i = edgeList.size() - 1; i >= 0; i--) {
			Edge edge = edgeList.get(i);

			if (find(edge.start) != find(edge.end)) {
				union(edge.start, edge.end);

				if (edge.weight == 0) {
					cost2++;
				}
			}
		}

		int ans = cost1 * cost1 - cost2 * cost2;
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static int find(int x) {
		if (x == parent[x]) {
			return x;
		}

		return parent[x] = find(parent[x]);
	}

	public static void union(int x, int y) {
		x = find(x);
		y = find(y);

		if (x != y) {
			parent[y] = x;
		}
	}

}
