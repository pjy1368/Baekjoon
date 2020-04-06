package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int[] inorder, postorder, idx;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		inorder = new int[n];
		postorder = new int[n];
		idx = new int[n + 1];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			inorder[i] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			postorder[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			idx[inorder[i]] = i;
		}

		preorder(0, n - 1, 0, n - 1);
		bw.write(sb.toString() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static void preorder(int inStart, int inEnd, int postStart, int postEnd) {
		if (inStart > inEnd || postStart > postEnd) {
			return;
		}

		int root = postorder[postEnd];

		sb.append(root + " ");
		preorder(inStart, idx[root] - 1, postStart, postStart - inStart + idx[root] - 1);
		preorder(idx[root] + 1, inEnd, postStart - inStart + idx[root], postEnd - 1);

	}

}