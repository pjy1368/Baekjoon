package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Student implements Comparable<Student> {
	int num;
	int grade;

	Student(int num, int grade) {
		this.num = num;
		this.grade = grade;
	}

	@Override
	public int compareTo(Student o) {
		return grade - o.grade;
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		int[] arr = new int[N + 1];

		int[][] key = new int[M][2];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 2; j++) {
				key[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < M; i++) {
			int A = key[i][0];
			int B = key[i][1];

			arr[A] = Math.min(arr[A] - 1, arr[B] - 1);
		}
		
		for(int i = M - 1; i >= 0; i--) {
			int A = key[i][0];
			int B = key[i][1];
			
			arr[A] = Math.min(arr[A] - 1, arr[B] - 1);
		}

		PriorityQueue<Student> pq = new PriorityQueue<>();
		for (int i = 1; i <= N; i++) {
			pq.offer(new Student(i, arr[i]));
		}

		while (!pq.isEmpty()) {
			bw.write(pq.poll().num + " ");
		}
		bw.write("\n");
		bw.flush();
		bw.close();
		br.close();
	}
}