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

		double[] arr = new double[4];
		arr[0] = Double.parseDouble(st.nextToken());
		arr[1] = Double.parseDouble(st.nextToken());

		st = new StringTokenizer(br.readLine());
		arr[2] = Double.parseDouble(st.nextToken());
		arr[3] = Double.parseDouble(st.nextToken());

		double[] ans = new double[4];

		// 1번째
		double A = arr[0];
		double B = arr[1];
		double C = arr[2];
		double D = arr[3];

		ans[0] = A / C + B / D;

		// 2번째
		A = arr[2];
		B = arr[0];
		C = arr[3];
		D = arr[1];

		ans[1] = A / C + B / D;

		// 3번쨰
		A = arr[3];
		B = arr[2];
		C = arr[1];
		D = arr[0];

		ans[2] = A / C + B / D;

		// 4번째
		A = arr[1];
		B = arr[3];
		C = arr[0];
		D = arr[2];

		ans[3] = A / C + B / D;

		int index = -1;
		double max = 0;
		for (int i = 0; i < 4; i++) {
			if (max < ans[i]) {
				max = ans[i];
				index = i;
			}
		}

		bw.write(index + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
