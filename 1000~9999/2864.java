import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		String A = st.nextToken();
		String B = st.nextToken();

		// A + B의 최솟값
		// 6 -> 5로 바꾸어야 함.
		String minA = A;
		String minB = B;

		if (minA.contains("6")) {
			minA = minA.replace("6", "5");
		}

		if (minB.contains("6")) {
			minB = minB.replace("6", "5");
		}

		int sum = Integer.parseInt(minA) + Integer.parseInt(minB);
		bw.write(sum + " ");

		// A + B의 최댓값
		// 5 -> 6으로 바꿔야 함.
		String maxA = A;
		String maxB = B;

		if (maxA.contains("5")) {
			maxA = maxA.replace("5", "6");
		}

		if (maxB.contains("5")) {
			maxB = maxB.replace("5", "6");
		}

		sum = Integer.parseInt(maxA) + Integer.parseInt(maxB);
		bw.write(sum + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
