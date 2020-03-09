import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int score = Integer.parseInt(br.readLine());

		if (score == 100) {
			bw.write("A\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}

		int r = score / 10;

		if (r < 6) {
			bw.write("F\n");
		} else {
			int temp = r - 6;
			bw.write((char)('D' - temp) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
