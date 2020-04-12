package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] indegree = new int[N + 1];
		Vector<Vector<Integer>> v = new Vector<>();

		for (int i = 0; i <= N; i++) {
			v.add(new Vector<>());
		}

		while (M-- > 0) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			indegree[B]++;
			v.get(A).add(B);
		}

		Queue<Integer> now = new LinkedList<>();
		for (int i = 1; i <= N; i++) {
			if (indegree[i] == 0) {
				now.offer(i);
			}
		}

		while (!now.isEmpty()) {
			int i = now.poll();
			bw.write(i + " ");

			for (int j = 0; j < v.get(i).size(); j++) {
				if (--indegree[v.get(i).get(j)] == 0) {
					now.offer(v.get(i).get(j));
				}
			}
		}

		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();
	}
}