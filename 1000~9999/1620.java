package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		String[] name = new String[N + 1];
		Map<String, Integer> map = new HashMap<>();

		for (int i = 1; i <= N; i++) {
			name[i] = br.readLine();
			map.put(name[i], i);
		}

		for (int i = 0; i < M; i++) {
			String input = br.readLine();
			char c = input.charAt(0);
			if (c >= '0' && c <= '9') {
				bw.write(name[Integer.parseInt(input)] + "\n");
			} else {
				bw.write(map.get(input) + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
