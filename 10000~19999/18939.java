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
		int T = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			if (Math.max(N, M) < K * 2) { // 선공이 첫턴에 바로 이기는 경우
				sb.append("Yuto\n");
			} else {
				if ((N * M) % 2 == 0) {
					sb.append("Platina\n");
				} else {
					sb.append("Yuto\n");
				}
			}
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}