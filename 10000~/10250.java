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
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken()); // 세로
			int W = Integer.parseInt(st.nextToken()); // 가로
			int N = Integer.parseInt(st.nextToken()); // N번쨰로 도착한 손님

			if (N % H != 0) {
				if (N / H + 1 >= 10) {
					bw.write((N % H) + "" + ((N / H) + 1) + "\n");
				} else {
					bw.write((N % H) + "0" + ((N / H) + 1) + "\n");
				}
			} else {
				if (N / H >= 10) {
					bw.write(H + "" + (N / H) + "\n");
				} else {
					bw.write(H + "0" + (N / H) + "\n");
				}
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
