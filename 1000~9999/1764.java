package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		Set<String> set = new HashSet<>();
		Vector<String> v = new Vector<>();
		for (int i = 0; i < N + M; i++) {
			String input = br.readLine();
			if (set.contains(input)) {
				v.add(input);
			} else {
				set.add(input);
			}
		}

		bw.write(v.size() + "\n");
		Collections.sort(v);
		for (int i = 0; i < v.size(); i++) {
			bw.write(v.get(i) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
