package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Pair<L, R> {

	final L left;
	final R right;

	public Pair(L left, R right) {
		this.left = left;
		this.right = right;
	}

	public L getLeft() {
		return left;
	}

	public R getRight() {
		return right;
	}
}

class TreapNode {
	int key;
	double priority;
	int size;
	TreapNode left, right;

	public TreapNode(int key) {
		this.key = key;
		priority = Math.random();
		size = 1;
	}

	public void setLeft(TreapNode newNode) {
		left = newNode;
		calcSize();
	}

	public void setRight(TreapNode newNode) {
		right = newNode;
		calcSize();
	}

	public void calcSize() {
		size = 1;
		if (left != null)
			size += left.size;
		if (right != null)
			size += right.size;
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		TreapNode root = null;
		for (int i = 0; i < 10; i++) {
			root = insert(root, new TreapNode(i));
		}

		inorder(root);
		System.out.println();
		root = erase(root, 1);
		root = erase(root, 6);
		root = erase(root, 5);
		root = erase(root, 8);
		inorder(root);

		bw.flush();
		bw.close();
		br.close();
	}

	public static Pair<TreapNode, TreapNode> split(TreapNode root, int key) {
		if (root == null) {
			return new Pair<TreapNode, TreapNode>(null, null);
		}

		// 루트가 key값 보다 작다면, 루트의 right를 나눔.
		if (root.key <= key) {
			// 재귀적으로 나누어진 오른쪽 서브트립의 루트
			Pair<TreapNode, TreapNode> rs = split(root.right, key);

			// 기존 루트의 오른쪽 서브트립을 루트보다 크고, key보다 작은 서브트립으로 대체
			root.setRight(rs.getLeft());

			// key보다 작은 값만 있는 root와 큰 값이 있는 rs.getRight를 반환.
			return new Pair<TreapNode, TreapNode>(root, rs.getRight());
		}

		// 루트가 key값보다 크다면, 루트의 left를 나눈다.
		if (root.key > key) {
			// 재귀적으로 나누어진 왼쪽 서브트립의 루트
			Pair<TreapNode, TreapNode> rs = split(root.left, key);

			// 기존 루트의 왼쪽 서브트립을 루트보다 작고, key보다 큰 서브트립으로 대체.
			root.setLeft(rs.getRight());

			// key보다 작은 값만 있는 rs.left와 큰 값만 있는 root를 반환.
			return new Pair<TreapNode, TreapNode>(rs.getLeft(), root);
		}
		return new Pair<TreapNode, TreapNode>(null, null);
	}

	// root를 루트로 하는 트립에 node를 삽입 후 결과 트립의 루트를 반환.
	public static TreapNode insert(TreapNode root, TreapNode node) {
		if (root == null) {
			return node;
		}

		// 루트의 우선순위가 새 노드의 우선 순위 보다 낮다면 split을 수행하여 삽입.
		if (root.priority < node.priority) {
			// 새 노드의 키를 기준으로 나눠진 트립
			Pair<TreapNode, TreapNode> splitted = split(root, node.key);

			// 새 노드의 왼쪽 트립을 세팅
			node.setLeft(splitted.getLeft());

			// 새 노드의 오른쪽 트립을 세팅
			node.setRight(splitted.getRight());

			// 새롭게 루트가 된 node를 반환.
			return node;

			// 루트의 우선순위가 새 노드의 우선순위보다 높다면 재귀적으로 삽입을 수행.
		} else if (node.key < root.key) {
			root.setLeft(insert(root.left, node));
		} else {
			root.setRight(insert(root.right, node));
		}

		return root;
	}

	// 두 트립의 루트 a, b가 주어지고 a의 최댓값이 b의 최솟값보다 작을 때 둘을 합칠 수 있음.
	public static TreapNode merge(TreapNode a, TreapNode b) {
		if (a == null) {
			return b;
		}

		if (b == null) {
			return a;
		}

		// b가 루트가 되어야하는 경우 재귀적으로 트립을 수정 후 반환.
		if (a.priority < b.priority) {
			b.setLeft(merge(a, b.left));
			return b;
		}

		// a가 루트가 되어야하는 경우 재귀적으로 트립을 수정 후 반환.
		a.setRight(merge(a.right, b));
		return a;
	}

	// root를 루트로 하는 트립에서 key값을 삭제한 트립의 루트를 반환.
	public static TreapNode erase(TreapNode root, int key) {
		if (root == null) {
			return root;
		}

		// 삭제할 값을 찾아낸 경우 merge된 양 서브트립을 반환.
		if (root.key == key) {
			TreapNode ret = merge(root.left, root.right);
			root = null; // 이것은 이후에 가비지 컬렉터가 수거해갈 것임.
			return ret;
		}

		// BST의 속성을 만족하도록 아래를 수행.
		if (key < root.key) {
			root.setLeft(erase(root.left, key));
		} else {
			root.setRight(erase(root.right, key));
		}

		return root;
	}

	// k번째 노드를 반환.
	public static TreapNode kth(TreapNode root, int k) {
		int leftSize = 0; // 왼쪽 서브트리의 크기.
		if (root.left != null) {
			leftSize = root.left.size;
		}
		
		// k번째 노드는 왼쪽 서브트리의 위치함.
		if (k <= leftSize) {
			return kth(root.left, k);
		}
		
		// k번째 노드는 root 노드임.
		if (k == leftSize + 1) {
			return root;
		}
		
		// k번째 노드는 오른쪽 서브트리의 위치함.
		return kth(root.right, k - leftSize - 1);
	}
	
	// key보다 작은 원소의 개수를 세기.
	public static int countLessThan(TreapNode root, int key) {
		if (root == null) {
			return 0;
		}
		
		// root의 key가 key보다 크다면, 오른쪽 서브트리는 모두 주어진 key보다 큼.
		if (key <= root.key) {
			return countLessThan(root.left, key);
		}
		
		// root의 key가 key보다 작다면,
		// 일단 root의 왼쪽 서브트리는 모두 해당이 됨.
		int ls = (root.left != null ? root.left.size : 0);
		
		// 그리고 오른쪽 서브트리 중에 key보다 작은 원소는 몇  개인지 세면 됨. 중간에 1은 root 노드를 의미.
		return ls + 1 + countLessThan(root.right, key);
	}

	public static void inorder(TreapNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.key + " ");
			inorder(root.right);
		}
	}
}