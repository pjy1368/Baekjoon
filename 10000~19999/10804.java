import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int[] arr;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken()); // 5
			int f = Integer.parseInt(st.nextToken()); // 10
			
			t--;
			f--;
			reverse(t, f);
		}

		bw.write(String.valueOf(arr[0]));
		for (int i = 1; i < 20; i++) {
			bw.write(" " + arr[i]);
		}

		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void reverse(int t, int f) {
		while (t <= f) {
			int temp = arr[t];
			arr[t] = arr[f];
			arr[f] = temp;
			t++;
			f--;
		}
	}

}
