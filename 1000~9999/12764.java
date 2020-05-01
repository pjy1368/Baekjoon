package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Person implements Comparable<Person> {
	int start; // ���� �ð�
	int end; // ���� �ð�
	int num; // ���� �ɾ��ִ� ��ǻ�� �¼� ��ȣ.

	Person(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	public int compareTo(Person o) {
		return end - o.end;
	}

}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		Person[] people = new Person[N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			people[i] = new Person(start, end);
		}

		// ���� �ð��� ���� ������� ����.
		Arrays.sort(people, new Comparator<Person>() {

			@Override
			public int compare(Person o1, Person o2) {
				return o1.start - o2.start;
			}

		});

		int computer = 0;
		int[] peopleNum = new int[100001];

		// ���� �ð��� ���� ���� �������� �켱����ť ����.
		PriorityQueue<Person> pq = new PriorityQueue<>();

		people[0].num = computer; // ���� ���� �¼��� ��ȣ�� �ο�. (�ʱ�ϱ� 0)
		peopleNum[0] = 1; // 0�� �¼��� �ο� �� 1.
		computer++; // ��ǻ�� ���� ����.
		pq.offer(people[0]); // ���� ���� ����� �켱����ť�� ���� ����.

		Set<Integer> set = new TreeSet<>();
		for (int i = 1; i < N; i++) {
			Person person = pq.peek(); // �켱����ť���� ���� �ð��� ���� ���� ���.

			if (set.isEmpty() && people[i].start < person.end) {
				people[i].num = computer;
				peopleNum[people[i].num] = 1;
				computer++;
				pq.offer(people[i]);

			} else { // ���� �ð� >= ���� �ð�
				while (!pq.isEmpty() && people[i].start >= pq.peek().end) {
					set.add(pq.peek().num);
					pq.poll();
				}

				people[i].num = set.iterator().next();
				peopleNum[people[i].num]++;
				pq.offer(people[i]);
				set.remove(people[i].num);
			}
		}

		// �ʿ��� ��ǻ���� ����.
		bw.write(computer + "\n");

		// �¼� �ο� ��.
		for (int i = 0; i < computer; i++) {
			bw.write(peopleNum[i] + " ");
		}
		bw.write("\n");

		bw.flush();
		bw.close();
		br.close();
	}

}
