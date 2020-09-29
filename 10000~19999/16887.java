package no.jam1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		System.out.println(Math.sqrt(2562991876L));
		int N = Integer.parseInt(br.readLine());

		long result = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			long temp = Long.parseLong(st.nextToken());

			if (temp >= 1 && temp < 4) {
				temp = 0;
			} else if (temp >= 4 && temp < 16) {
				temp = 1;
			} else if (temp >= 16 && temp < 82) {
				temp = 2;
			} else if (temp >= 82 && temp < 6724) {
				temp = 0;
			} else if (temp >= 6724 && temp < 50626) {
				temp = 3;
			} else if (temp >= 50626 && temp < 2562991876L) {
				temp = 1;
			} else {
				temp = 2;
			}

			result ^= temp;
		}

		bw.write((result != 0) ? "koosaga" : "cubelover");
		bw.flush();
		bw.close();
		br.close();
	}

}