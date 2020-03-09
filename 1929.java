import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String input = bf.readLine();
		StringTokenizer st = new StringTokenizer(input);
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		ArrayList<Boolean> primeList;

		primeList = new ArrayList<Boolean>(N + 1);
		primeList.add(false);
		primeList.add(false);

		for (int i = 2; i <= N; i++) {
			primeList.add(i, true);
		}

		for (int i = 2; (i * i) <= N; i++) {
			if (primeList.get(i)) {
				for (int j = i * i; j <= N; j += i)
					primeList.set(j, false);
			}
		}

		for (int i = M; i <= N; i++) {
			if (primeList.get(i)) {
				bw.write(i + "\n");
			}
		}

		bw.flush();
		bf.close();
		bw.close();
	}

}
