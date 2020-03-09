import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int P = Integer.parseInt(br.readLine());

		for (int i = 1; i <= P; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();

			int M = Integer.parseInt(st.nextToken());
			if (!Eratos(M)) {
				bw.write(i + " " + M + " " + "NO\n");
				continue;
			}

			if (!isHappy(M)) {
				bw.write(i + " " + M + " " + "NO\n");
				continue;
			}

			bw.write(i + " " + M + " " + "YES\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	public static boolean Eratos(int n) {
		boolean[] primeList = new boolean[n + 1];

		if (n <= 1) {
			return false;
		}

		primeList[0] = false;
		primeList[1] = false;

		for (int i = 2; i <= n; i++) {
			primeList[i] = true;
		}

		for (int i = 2; (i * i) <= n; i++) {
			if (primeList[i]) {
				for (int j = i * i; j <= n; j += i)
					primeList[j] = false;
			}
		}

		return primeList[n];
	}

	public static boolean isHappy(int n) {
		String input = String.valueOf(n);
		Set<String> set = new HashSet<>();

		while (!input.equals("1")) {
			int sum = 0;
			for (int i = 0; i < input.length(); i++) {
				sum += (int) Math.pow(Integer.parseInt(String.valueOf(input.charAt(i))), 2.0);
			}

			input = String.valueOf(sum);

			if (set.contains(input)) {
				return false;
			}
			set.add(input);
		}
		return true;
	}

}
