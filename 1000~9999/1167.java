package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Graph {
	int vertex;
	int weight;

	Graph(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
}

public class Main {
	static int v;
	static ArrayList<ArrayList<Graph>> a;
	static boolean[] visited;
	static int maxV = 0, maxW = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		v = Integer.parseInt(br.readLine());

		a = new ArrayList<>();
		for (int i = 0; i <= v; i++) {
			a.add(new ArrayList<>());
		}

		int cnt = v;
		while (cnt-- > 0) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			while (true) {
				int f = Integer.parseInt(st.nextToken());

				if (f == -1) {
					break;
				}

				int w = Integer.parseInt(st.nextToken());

				a.get(t).add(new Graph(f, w));
			}
		}

		visited = new boolean[v + 1];
		DFS(1, 0);

		maxW = 0;
		DFS(maxV, 0);

		bw.write(maxW + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
	
	// Ʈ���� ������ ���ϴ� ���
	// ������ �� �ϳ�(A)�� ���Ѵ�.
	// A���� ���� �� ����(B)�� ã�´�.
	// B���� ���� �� ����(C)�� ã�´�.
	// B�� C�� �Ÿ��� Ʈ���� �����̴�.
	public static void DFS(int start, int dis) {
		visited[start] = true;

		for (Graph g : a.get(start)) {
			if (!visited[g.vertex]) {
				visited[g.vertex] = true;
				DFS(g.vertex, dis + g.weight);
			}
		}

		if (maxW < dis) {
			maxW = dis;
			maxV = start;
		}
		visited[start] = false;
	}

}