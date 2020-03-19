package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 사람의 수
		int K = Integer.parseInt(st.nextToken()); // 제거된 사람으로부터 떨어져 있는 거리

		Vector<Integer> v = new Vector<>();

		for (int i = 0; i < N; i++) {
			v.add(i + 1);
		}

		int index = -1;
		boolean isFirst = true;
		bw.write("<");
		while (!v.isEmpty()) {
			index = (index + K) % v.size();

			if (isFirst) {
				bw.write(String.valueOf(v.get(index)));
				isFirst = false;
			} else {
				bw.write(", " + v.get(index));
			}
			v.remove(index);
			index--;
		}

		bw.write(">\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
