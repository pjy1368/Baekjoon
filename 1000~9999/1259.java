package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String input = "";
		while (!(input = br.readLine()).equals("0")) {
			StringBuilder sb = new StringBuilder(input);
			sb.reverse();
			if (input.equals(sb.toString())) {
				bw.write("yes\n");
			} else {
				bw.write("no\n");
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
