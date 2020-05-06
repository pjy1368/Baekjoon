package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		Integer[] crain = new Integer[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			crain[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(crain, Comparator.reverseOrder());

		int M = Integer.parseInt(br.readLine());
		Vector<Integer> boxes = new Vector<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			boxes.add(Integer.parseInt(st.nextToken()));
		}
		Collections.sort(boxes, Collections.reverseOrder());

		if (boxes.get(0) > crain[0]) {
			bw.write("-1\n");
			bw.close();
			br.close();
			return;
		}

		int cnt = 0;
		while (!boxes.isEmpty()) {
			int index = 0;

			for (int i = 0; i < boxes.size(); i++) {
				if (index == N) {
					break;
				}

				if (crain[index] >= boxes.get(i)) {
					index++;
					boxes.remove(i);
					i--;
				}
			}
			cnt++;
		}

		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
