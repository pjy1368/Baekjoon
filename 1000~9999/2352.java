package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int[] lis = new int[N];
		lis[0] = arr[0];
		int idx = 1;
		int tmp = 0;
		for (int i = 1; i < N; i++) {
			if (lis[idx - 1] < arr[i]) { // ū ���� �ڷ� �̾���δ�.
				lis[idx++] = arr[i];
			} else if (lis[0] > arr[i]) { // lis�� ó�� ������ ���� ���� ��ü�Ѵ�.
				lis[0] = arr[i];
			} else { // lis ������ �� �� �ִ� ���� �̺�Ž���� ���� ������ ��ġ�� �־��ش�.
				tmp = Arrays.binarySearch(lis, 0, idx, arr[i]);
				lis[tmp < 0 ? (-tmp - 1) : tmp] = arr[i];
			}
		}

		bw.write(idx + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}