import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = "";
		final int MAX = 1000000;
		boolean[] primeList = new boolean[MAX + 1];

		for (int i = 2; i <= MAX; i++) {
			primeList[i] = true;
		}

		for (int i = 2; i * i <= MAX; i += 1) {
			for (int j = i * i; j <= MAX; j += i) {
				primeList[j] = false;
			}
		}

		outer: while (!(input = bf.readLine()).equals("0")) {
			int N = Integer.parseInt(input);

			if (N % 2 != 0) {
				bw.write("Goldbach's conjecture is wrong.\n");
				bw.flush();
				continue outer;
			}

			for (int i = 3; i <= N; i += 2) {
				if (primeList[i] && primeList[N - i]) {
					bw.write(N + " = " + i + " + " + (N - i) + "\n");
					bw.flush();
					continue outer;
				}
			}
		};

		bf.close();
		bw.close();
	}

}
