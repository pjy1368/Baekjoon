package no.jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Position implements Comparable<Position> {
	int posNum;
	int weight;

	Position(int posNum, int weight) {
		this.posNum = posNum;
		this.weight = weight;
	}

	@Override
	public int compareTo(Position arg0) {
		return weight - arg0.weight;
	}

}

public class Main {
	static int N, M, R;
	static int[] item;
	static ArrayList<ArrayList<Position>> a;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		item = new int[N + 1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}

		a = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			a.add(new ArrayList<>());
		}

		for (int i = 1; i <= R; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			a.get(start).add(new Position(end, weight));
			a.get(end).add(new Position(start, weight));
		}

		dist = new int[N + 1];

		int ans = 0;
		for (int i = 1; i <= N; i++) {
			ans = Math.max(ans, dijkstra(i));
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static int dijkstra(int start) {
		Arrays.fill(dist, Integer.MAX_VALUE);
		PriorityQueue<Position> pq = new PriorityQueue<>();
		boolean[] check = new boolean[N + 1];
		pq.offer(new Position(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Position curPos = pq.poll();
			int pos = curPos.posNum;

			if (!check[pos]) {
				check[pos] = true;

				for (Position position : a.get(pos)) {
					if (!check[position.posNum] && dist[position.posNum] > dist[pos] + position.weight) {
						dist[position.posNum] = dist[pos] + position.weight;
						pq.add(new Position(position.posNum, dist[position.posNum]));
					}
				}
			}
		}

		int res = 0;
		for (int i = 1; i <= N; i++) {
			if (dist[i] <= M) {
				res += item[i];
			}
		}

		return res;
	}

}