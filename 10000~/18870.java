package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		Map<Integer, Integer> map = new HashMap<>();

		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] num = arr.clone();
		Arrays.sort(num);

		Set<Integer> set = new HashSet<>();
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			if (!set.contains(num[i])) {
				set.add(num[i]);
				map.put(num[i], cnt++);
			}
		}

		for (int i = 0; i < N; i++) {
			bw.write(map.get(arr[i]) + " ");
		}

		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();
	}

}