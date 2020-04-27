package no.jam;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		if (N == 0) {
			bw.write("1\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}

		int[] plastic = new int[9];
		buySet(plastic);

		int cnt = 1;
		while (N != 0) {
			int temp = N % 10;

			if (temp == 9) {
				temp = 6;
			}

			if (plastic[temp] == 0) {
				buySet(plastic);
				plastic[temp]--;
				cnt++;
			} else {
				plastic[temp]--;
			}

			N /= 10;
		}

		bw.write(cnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void buySet(int[] plastic) {
		for (int i = 0; i < 9; i++) {
			if (i == 6) {
				plastic[i] = 2;
			} else {
				plastic[i] = 1;
			}
		}
	}

}