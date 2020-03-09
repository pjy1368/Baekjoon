import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int ans;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		int[] nums = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		ans = Integer.MIN_VALUE;
		perm(nums, 0);
		
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void perm(int[] arr, int pivot) {
		if (pivot == arr.length) {
			int sum = 0;
			for (int i = 0; i < N - 1; i++) {
				sum += Math.abs(arr[i] - arr[i + 1]);
			}
			ans = Math.max(ans, sum);
			return;
		}

		for (int i = pivot; i < arr.length; i++) {
			swap(arr, i, pivot);
			perm(arr, pivot + 1);
			swap(arr, i, pivot);
		}
	}

	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
