import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());

		int res = Integer.parseInt(st.nextToken());
		for (int i = 1; i < N; i++) {
			res ^= Integer.parseInt(st.nextToken());
		}

		bw.write((res == 0) ? "cubelover" : "koosaga");
		bw.flush();
		bw.close();
		br.close();
	}

}