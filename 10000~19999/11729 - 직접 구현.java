package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class MaxHeap {
	// 부모노드의 위치가 p 일 때, 자식 노드의 위치는 각각  p * 2, p * 2 + 1이 된다.
	ArrayList<Integer> heap;

	MaxHeap() {
		heap = new ArrayList<>();
		heap.add(Integer.MAX_VALUE); // 인덱스 1부터 시작하기 위함.
	}

	void insert(int val) {
		heap.add(val);
		int p = heap.size() - 1;
		// 루트까지 이동, 자식 노드가 더 크면 swap
		while (p > 1 && heap.get(p / 2) < heap.get(p)) {
			int temp = heap.get(p / 2);
			heap.set(p / 2, heap.get(p));
			heap.set(p, temp);

			p = p / 2;
		}
	}

	int delete() {
		if (heap.size() - 1 < 1) { // heap이 비어있으면 리턴.
			return 0;
		}

		int deleteItem = heap.get(1); // 부모 노드값 저장.

		heap.set(1, heap.get(heap.size() - 1)); // 부모 노드에 맨 마지막 값을 저장.
		heap.remove(heap.size() - 1); // 맨 마지막 값 삭제.

		int pos = 1; // 첫 부모 인덱스 저장.
		while ((pos * 2) < heap.size()) { // 왼쪽 자식이 heap의 사이즈를 초과하기 전까지 반복.
			int max = heap.get(pos * 2); // 왼쪽 자식 노드의 값.
			int maxPos = pos * 2; // 왼쪽 자식 노드 인덱스
			
			// 오른쪽 자식이 있는지 여부 확인. 오른쪽 노드가 더 크면  max, maxPos로 갱신.
			if (((pos * 2 + 1) < heap.size()) && max < heap.get(pos * 2 + 1)) {
				max = heap.get(pos * 2 + 1);
				maxPos = pos * 2 + 1;
			}

			if (heap.get(pos) > max) { // max가 부모보다 작으면 바꿀 필요 없음.
				break;
			}
			
			// 부모와 자식 노드 교환.
			int temp = heap.get(pos);
			heap.set(pos, heap.get(maxPos));
			heap.set(maxPos, temp);
			
			pos = maxPos; // 왼쪽와 오른쪽 자식 노드 중 더 값이 컸던 위치로 초기화.
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
