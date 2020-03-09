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

		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int cnt = 0;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if (num < X) {
				if (cnt == 0) {
					sb.append(num);
				} else {
					sb.append(" " + num);
				}
				cnt++;
			}
		}

		bw.write(sb.toString() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
