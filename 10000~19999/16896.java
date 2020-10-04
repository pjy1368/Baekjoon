import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			long N = Long.parseLong(br.readLine());

			if (N % 2 == 0) {
				sb.append("cubelover\n");
			} else {
				N = 2 * (N - 1);
				boolean isOdd = false;

				// N = 2^p + 2^q + 2^r + ... 꼴로 표현할 수 있는데
				// p, q, r, ... 는 항상 짝수가 되어야 함.
				while (N > 0) {
					// 현재 N에 가까운 가장 큰 2^exp를 구함.
					int exp = (int) (Math.log10(N) / Math.log10(2));

					// 지수가 홀수가 되는 경우 cubelover가 이김.
					if (exp % 2 == 1) {
						isOdd = true;
						break;
					}

					N -= Math.pow(2, exp);
				}

				if (isOdd) {
					sb.append("cubelover\n");
				} else {
					sb.append("koosaga\n");
				}
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}