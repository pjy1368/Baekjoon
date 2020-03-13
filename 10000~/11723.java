package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int bm = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String command = st.nextToken();

			if (command.equals("add")) {
				int n = Integer.parseInt(st.nextToken()) - 1;
				bm |= (1 << n);
			} else if (command.equals("check")) {
				int n = Integer.parseInt(st.nextToken()) - 1;
				
				bw.write(((bm & (1 << n)) == 0 ? 0 : 1) + "\n");
			} else if (command.equals("remove")) {
				int n = Integer.parseInt(st.nextToken()) - 1;

				bm &= ~(1 << n);
			} else if (command.equals("toggle")) {
				int n = Integer.parseInt(st.nextToken()) - 1;

				bm ^= (1 << n);
			} else if (command.equals("all")) {
				bm |= ((1 << 20) - 1);
			} else if (command.equals("empty")) {
				bm = 0;
			} else {
				continue;
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
