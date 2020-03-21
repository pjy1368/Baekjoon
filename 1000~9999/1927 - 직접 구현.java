package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class MinHeap {
	ArrayList<Integer> heap;

	MinHeap() {
		heap = new ArrayList<>();
		heap.add(Integer.MIN_VALUE); // 인덱스 1부터 시작하기 위함.
	}

	void insert(int val) {
		heap.add(val);
		int p = heap.size() - 1;
		while (p > 1 && heap.get(p / 2) > heap.get(p)) {
			int tmp = heap.get(p / 2);
			heap.set(p / 2, heap.get(p));
			heap.set(p, tmp);

			p = p / 2;
		}
	}

	int delete() {
		if (heap.size() - 1 < 1) {
			return 0;
		}

		int deleteItem = heap.get(1);

		heap.set(1, heap.get(heap.size() - 1));
		heap.remove(heap.size() - 1);

		int pos = 1;
		while ((pos * 2) < heap.size()) {
			int min = heap.get(pos * 2);
			int minPos = pos * 2;

			if (((pos * 2 + 1) < heap.size()) && min > heap.get(pos * 2 + 1)) {
				min = heap.get(pos * 2 + 1);
				minPos = pos * 2 + 1;
			}

			if (heap.get(pos) < min) {
				break;
			}

			int tmp = heap.get(pos);
			heap.set(pos, heap.get(minPos));
			heap.set(minPos, tmp);
			pos = minPos;
		}
		return deleteItem;
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		MinHeap heap = new MinHeap();

		for (int i = 0; i < N; i++) {
			int temp = Integer.parseInt(br.readLine());

			if (temp == 0) {
				bw.write((heap.delete()) + "\n");
			} else {
				heap.insert(temp);
			}
		}
		bw.flush();
		bw.close();
		br.close();
	}

}
