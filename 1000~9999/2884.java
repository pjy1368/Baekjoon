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
		StringTokenizer st = new StringTokenizer(br.readLine());

		int H = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		if (M >= 45) {
			bw.write(H + " " + (M - 45) + "\n");
		} else {
			if (H > 0) {
				H--;
			} else {
				H = 23;
			}
			
			M = (60 - (45 - M));
			bw.write(H + " " + M + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
