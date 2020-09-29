package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int[] prime = Eratos(2000000); // 200만 이하의 소수의 배열. 약 15만 개

		int T = Integer.parseInt(br.readLine());
		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			long A = Long.parseLong(st.nextToken());
			long B = Long.parseLong(st.nextToken());
			long C = A + B;

			if (C < 4) { // C가 2일 떄와 3일 때는 소수 2개로 분리될 수 없다.
				bw.write("NO\n");
				continue;
			}

			if (C % 2 == 0) { // 골드바흐의 추측에 의하여 무조건 참.
				bw.write("YES\n");
			} else {
				// 홀수인 N = 2 + (N - 2)로 분리할 수 있음.
				// 즉 우리가 할 일은 N - 2가 소수인지 확인만 하면 됨.
				C = C - 2;

				if (isPrime(prime, C)) {
					bw.write("YES\n");
				} else {
					bw.write("NO\n");
				}
			}

		}

		bw.flush();
		bw.close();
		br.close();
	}
	
	// 소수만 담긴 배열을 반환하는 함수. 에라토스테네스의 체 활용.
	public static int[] Eratos(int MAX) {
		int size = 0;
		boolean[] prime = new boolean[MAX + 1];
		prime[0] = prime[1] = false;

		for (int i = 2; i <= MAX; i++) {
			prime[i] = true;
		}

		for (int i = 2; i * i <= MAX; i++) {
			if (prime[i]) {
				for (int j = i * i; j <= MAX; j += i) {
					prime[j] = false;
				}
			}
		}

		for (int i = 2; i <= MAX; i++) {
			if (prime[i]) {
				size++;
			}
		}

		int[] arr = new int[size];
		int index = 0;
		for (int i = 2; i <= MAX; i++) {
			if (prime[i]) {
				arr[index++] = i;
			}
		}

		return arr;
	}
	
	// n이 소수인지 아닌지 확인하는 함수.
	public static boolean isPrime(int[] prime, long n) {
		double sqrt = Math.sqrt(n);
		// 3, 5, 7, 9,... 부터 루트 n까지 홀수만 나누는 것보다 루트 n개 이하의 소수만 나눠보는 것이 더 빠르다.
		// 이 과정에서 Vector를 쓰면 시간 초과가 나서 일부러 배열을 사용하였음.
		for (int i = 0; i < prime.length && prime[i] <= sqrt; i++) {
			if (n % prime[i] == 0) {
				return false;
			}
		}
		return true;
	}
}