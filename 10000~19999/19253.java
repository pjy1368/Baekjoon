import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int Z = Integer.parseInt(br.readLine());

		StringBuilder sb = new StringBuilder();
		while (Z-- > 0) {
			int N = Integer.parseInt(br.readLine());

			sb.append(N % 2 == 0 ? "A\n" : "B\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

}