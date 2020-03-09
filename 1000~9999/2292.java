import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		if (N == 1) {
			bw.write("1\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}

		N--;

		int i = 2;
		while (true) {
			int n = i - 1;
			int temp = 6 * (n * (n + 1) / 2);

			if (N <= temp) {
				bw.write(String.valueOf(i) + '\n');
				break;
			}

			i++;
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
