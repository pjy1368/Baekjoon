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
		int N = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		String result = "";

		if (B < 10) {
			while (N != 0) {
				result = (N % B) + result;
				N /= B;
			}
		} else if (B == 10) {
			bw.write(N + "\n");
		} else {
			while (N != 0) {
				int r = N % B;
				if (r >= 10) {
					result = (char) ('A' - 10 + r) + result;
				} else {
					result = (N % B) + result;
				}
				N /= B;
			}
		}

		bw.write(result + "\n");
		bw.flush();
		bf.close();
		bw.close();
	}

}
