import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = bf.readLine();
		StringTokenizer st = new StringTokenizer(input);
		long N = Long.parseLong(st.nextToken());
		long M = Long.parseLong(st.nextToken());

		if (M == 0 || M == N) {
			bw.write("0\n");
			bw.flush();
			bf.close();
			bw.close();
			return;
		}

		long exponent2 = 0;
		long exponent5 = 0;
		long result = 0;

		for (long i = 2; i <= N; i *= 2) {
			exponent2 += N / i - (N - M) / i;
			exponent2 -= M / i;
		}

		for (long i = 5; i <= N; i *= 5) {
			exponent5 += N / i - (N - M) / i;
			exponent5 -= M / i;
		}

		result = Math.min(exponent2, exponent5);
		bw.write(result + "\n");
		bw.flush();
		bf.close();
		bw.close();
	}

}
