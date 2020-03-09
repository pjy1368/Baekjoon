import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			String str = br.readLine();

			int sum = 0;
			int cnt = 0;
			for (int j = 0; j < str.length(); j++) {
				char c = str.charAt(j);
				if (c == 'O') {
					cnt++;
				} else {
					if (cnt != 0) {
						sum += cnt * (cnt + 1) / 2;
						cnt = 0;
					}
				}
			}

			if (cnt != 0) {
				sum += cnt * (cnt + 1) / 2;
			}
			
			bw.write(sum + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
