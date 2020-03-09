import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static String[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		arr = new String[N];

		arr[0] = "  *  ";
		arr[1] = " * * ";
		arr[2] = "*****";

		for (int k = 1; 3 * (int) Math.pow(2, k) <= N; k++) {
			recursion(k);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr[i] + "\n");
		}

		bw.write(sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}

	public static void recursion(int k) {
		int n = 3 * (int) Math.pow(2, k);
		int mid = n / 2;

		for (int i = mid; i < n; i++) {
			arr[i] = arr[i - mid] + " " + arr[i - mid];
		}
		
		String blank = "";
		while(blank.length() < mid) {
			blank += " ";
		}
		
		for(int i = 0; i < mid; i++) {
			arr[i] = blank + arr[i] + blank;
		}
	}

}
