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

		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		int ans = 1;
		while (B != A) {
			if (B < A) {
				ans = -1;
				break;
			}

			String str = String.valueOf(B);

			if (str.charAt(str.length() - 1) != 1 && B % 2 != 0) {
				ans = -1;
				break;
			}

			if (str.charAt(str.length() - 1) == '1') {
				str = str.substring(0, str.length() - 1);
				B = Long.parseLong(str);
			} else {
				B >>= 1;
			}
			ans++;
		}

		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}