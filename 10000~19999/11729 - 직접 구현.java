package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class MaxHeap {
	// �θ����� ��ġ�� p �� ��, �ڽ� ����� ��ġ�� ����  p * 2, p * 2 + 1�� �ȴ�.
	ArrayList<Integer> heap;

	MaxHeap() {
		heap = new ArrayList<>();
		heap.add(Integer.MAX_VALUE); // �ε��� 1���� �����ϱ� ����.
	}

	void insert(int val) {
		heap.add(val);
		int p = heap.size() - 1;
		// ��Ʈ���� �̵�, �ڽ� ��尡 �� ũ�� swap
		while (p > 1 && heap.get(p / 2) < heap.get(p)) {
			int temp = heap.get(p / 2);
			heap.set(p / 2, heap.get(p));
			heap.set(p, temp);

			p = p / 2;
		}
	}

	int delete() {
		if (heap.size() - 1 < 1) { // heap�� ��������� ����.
			return 0;
		}

		int deleteItem = heap.get(1); // �θ� ��尪 ����.

		heap.set(1, heap.get(heap.size() - 1)); // �θ� ��忡 �� ������ ���� ����.
		heap.remove(heap.size() - 1); // �� ������ �� ����.

		int pos = 1; // ù �θ� �ε��� ����.
		while ((pos * 2) < heap.size()) { // ���� �ڽ��� heap�� ����� �ʰ��ϱ� ������ �ݺ�.
			int max = heap.get(pos * 2); // ���� �ڽ� ����� ��.
			int maxPos = pos * 2; // ���� �ڽ� ��� �ε���
			
			// ������ �ڽ��� �ִ��� ���� Ȯ��. ������ ��尡 �� ũ��  max, maxPos�� ����.
			if (((pos * 2 + 1) < heap.size()) && max < heap.get(pos * 2 + 1)) {
				max = heap.get(pos * 2 + 1);
				maxPos = pos * 2 + 1;
			}

			if (heap.get(pos) > max) { // max�� �θ𺸴� ������ �ٲ� �ʿ� ����.
				break;
			}
			
			// �θ�� �ڽ� ��� ��ȯ.
			int temp = heap.get(pos);
			heap.set(pos, heap.get(maxPos));
			heap.set(maxPos, temp);
			
			pos = maxPos; // ���ʿ� ������ �ڽ� ��� �� �� ���� �Ǵ� ��ġ�� �ʱ�ȭ.
		}
		return deleteItem;
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());

		MaxHeap heap = new MaxHeap();

		for (int i = 0; i < N; i++) {
			int val = Integer.parseInt(br.readLine());

			if (val == 0) {
				bw.write((heap.delete()) + "\n");
			} else {
				heap.insert(val);
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}
