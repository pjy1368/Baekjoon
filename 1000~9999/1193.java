import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int X = Integer.parseInt(br.readLine());

		if (X == 1) {
			bw.write("1/1\n");
			bw.flush();
			bw.close();
			br.close();
			return;
		}

		int index = 1;
		int sum = 0;
		
		while (true) {
			sum = index * (index + 1) / 2;
			if (X <= sum) {
				sum = (index - 1) * index / 2;
				break;
			}

			index++;
		}

		if (X == sum) {
			if (X % 2 != 0) {
				bw.write(index + "/1\n");
			} else {
				bw.write("1/" + index + "\n");
			}
			bw.flush();
			bw.close();
			br.close();
			return;
		}

		if (index % 2 != 0) {
			int cnt = X - sum;
			int up = 0, down = 0;

			for (int i = 0; i < cnt; i++) {
				up = index - i;
				down = i + 1;
			}

			bw.write(up + "/" + down + "\n");
		} else {
			int cnt = X - sum;
			int up = 0, down = 0;

			for (int i = 0; i < cnt; i++) {
				down = index - i;
				up = i + 1;
			}

			bw.write(up + "/" + down + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

}
