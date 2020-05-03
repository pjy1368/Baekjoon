package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		int[] weight = new int[N];
		st = new StringTokenizer(br.readLine());

		Set<Integer> set = new HashSet<>();
		boolean isOne = false;
		for (int i = 0; i < N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
			set.add(weight[i]);

			if (weight[i] == 1) {
				isOne = true;
			}
		}

		if (!isOne) {
			bw.write("1\n");
			bw.close();
			br.close();
			return;
		}

		Arrays.sort(weight);
		int[] psum = new int[N];
		psum[0] = weight[0];
		for (int i = 1; i < N; i++) {
			psum[i] = psum[i - 1] + weight[i];
			set.add(psum[i]);
		}

		int ans = psum[N - 1] + 1;
		for (int i = 1; i < N; i++) {
			int temp = psum[i - 1];

			if (!set.contains(temp + 1) && temp < weight[i]) {
				set.add(temp + 1);
				ans = Math.min(ans, temp + 1);
			}
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
