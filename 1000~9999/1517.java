import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static long swap = 0;
	public static long[] tmp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(bf.readLine());
		tmp = new long[N];
		long[] arr = new long[N];
		
		String input = bf.readLine();
		StringTokenizer st = new StringTokenizer(input);
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		MergeSort(arr, 0, N - 1);

		bw.write(swap + "\n");
		bf.close();
		bw.close();
	}

	public static void MergeSort(long[] arr, int p, int r) {
		if (p < r) {
			int q = (p + r) / 2;
			MergeSort(arr, p, q);
			MergeSort(arr, q + 1, r);
			Merge(arr, p, q, r);
		}
	}

	public static void Merge(long[] arr, int p, int q, int r) {
		int i = p, j = q + 1, k = p;
		
		while (i <= q && j <= r) {
			if (arr[i] <= arr[j]) {
				tmp[k++] = arr[i++];
			} else {
				tmp[k++] = arr[j++];
				swap += (q + 1 - i);
			}
		}

		while (i <= q) {
			tmp[k++] = arr[i++];
		}

		while (j <= r) {
			tmp[k++] = arr[j++];
		}

		for (i = p; i <= r; i++) {
			arr[i] = tmp[i];
		}

	}

}
