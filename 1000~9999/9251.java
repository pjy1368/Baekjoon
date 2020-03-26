package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String str1 = "0" + br.readLine();
		String str2 = "0" + br.readLine();

		int[][] LCS = new int[str2.length()][str1.length()];
		for (int i = 1; i < str2.length(); i++) {
			for (int j = 1; j < str1.length(); j++) {
				if (str2.charAt(i) == str1.charAt(j)) {
					LCS[i][j] = LCS[i - 1][j - 1] + 1;
				} else {
					LCS[i][j] = Math.max(LCS[i - 1][j], LCS[i][j - 1]);
				}
			}
		}

		bw.write(LCS[str2.length() - 1][str1.length() - 1] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}