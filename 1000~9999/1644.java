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
			bw.write("0");
			bw.flush();
			bw.close();
			br.close();
			return;
		}

		int[] prime = Eratos(N);

		int ans = 0;
		int sum = 0;
		int lo = 0;
		int hi = 0;

		while (true) {
			if (sum >= N) {
				sum -= prime[lo++];
			} else if (hi == prime.length) {
				break;
			} else {
				sum += prime[hi++];
			}

			if (sum == N) {
				ans++;
			}
		}
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static int[] Eratos(int N) {
		int trueNum = 0;
		boolean[] isPrime = new boolean[N + 1];

		isPrime[0] = isPrime[1] = false;

		for (int i = 2; i <= N; i++) {
			isPrime[i] = true;
		}

		for (int i = 2; (i * i) <= N; i++) {
			if (isPrime[i]) {
				for (int j = i * i; j <= N; j += i) {
					isPrime[j] = false;
				}
			}
		}

		for (int i = 2; i <= N; i++) {
			if (isPrime[i]) {
				trueNum++;
			}
		}

		int[] prime = new int[trueNum];
		int index = 0;
		for (int i = 2; i <= N; i++) {
			if (isPrime[i]) {
				prime[index++] = i;
			}
		}

		return prime;
	}

}
