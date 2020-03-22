package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Vector;

public class Main {
	static int cnt;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String parent = br.readLine();
		String pattern = br.readLine();

		cnt = 0;
		Vector<Integer> ans = KMP(parent, pattern);

		bw.write(cnt + "\n");
		for (int i = 0; i < ans.size(); i++) {
			bw.write(ans.get(i) + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

	public static Vector<Integer> makeTable(String pattern) {
		Vector<Integer> table = new Vector<>();
		for (int i = 0; i < pattern.length(); i++) {
			table.add(0);
		}

		int j = 0;
		for (int i = 1; i < pattern.length(); i++) {
			while (j > 0 && pattern.charAt(j) != pattern.charAt(i)) {
				j = table.get(j - 1);
			}

			if (pattern.charAt(j) == pattern.charAt(i)) {
				table.set(i, ++j);
			}

		}
		return table;
	}

	public static Vector<Integer> KMP(String parent, String pattern) {
		Vector<Integer> table = makeTable(pattern);
		Vector<Integer> ans = new Vector<>();
		int j = 0;
		for (int i = 0; i < parent.length(); i++) {
			while (j > 0 && parent.charAt(i) != pattern.charAt(j)) {
				j = table.get(j - 1);
			}

			if (parent.charAt(i) == pattern.charAt(j)) {
				if (j == pattern.length() - 1) {
					cnt++;
					ans.add(i - pattern.length() + 2);
					j = table.get(j);
				} else {
					j++;
				}
			}
		}
		return ans;
	}

}
