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

		int Asize = Integer.parseInt(st.nextToken());
		int A = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int Bsize = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int Csize = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= 100; i++) {
			if (i % 3 == 1) { // A -> B
				if (A + B > Bsize) {
					A = A + B - Bsize;
					B = Bsize;
				} else {
					B = A + B;
					A = 0;
				}
			} else if (i % 3 == 2) { // B -> C
				if (B + C > Csize) {
					B = B + C - Csize;
					C = Csize;
				} else {
					C = B + C;
					B = 0;
				}
			} else { // C -> A
				if (C + A > Asize) {
					C = A + C - Asize;
					A = Asize;
				} else {
					A = A + C;
					C = 0;
				}
			}
		}

		bw.write(A + "\n");
		bw.write(B + "\n");
		bw.write(C + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
