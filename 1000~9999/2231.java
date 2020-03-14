package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int input = Integer.parseInt(br.readLine());

		for (int i = 1; i <= input; i++) {
			int sum = i;
			int n = i;
			while (n != 0) {
				sum += n % 10;
				n /= 10;
			}

			if (sum == input) {
				bw.write(i + "\n");
				bw.flush();
				bw.close();
				br.close();
				return;
			}
		}

		bw.write("0\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
