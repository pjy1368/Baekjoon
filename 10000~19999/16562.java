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

		// ��Ʈ�� key�� ���� �۴ٸ�, ��Ʈ�� right�� ����.
		if (root.key <= key) {
			// ��������� �������� ������ ����Ʈ���� ��Ʈ
			Pair<TreapNode, TreapNode> rs = split(root.right, key);

			// ���� ��Ʈ�� ������ ����Ʈ���� ��Ʈ���� ũ��, key���� ���� ����Ʈ������ ��ü
			root.setRight(rs.getLeft());

			// key���� ���� ���� �ִ� root�� ū ���� �ִ� rs.getRight�� ��ȯ.
			return new Pair<TreapNode, TreapNode>(root, rs.getRight());
		}

		// ��Ʈ�� key������ ũ�ٸ�, ��Ʈ�� left�� ������.
		if (root.key > key) {
			// ��������� �������� ���� ����Ʈ���� ��Ʈ
			Pair<TreapNode, TreapNode> rs = split(root.left, key);

			// ���� ��Ʈ�� ���� ����Ʈ���� ��Ʈ���� �۰�, key���� ū ����Ʈ������ ��ü.
			root.setLeft(rs.getRight());

			// key���� ���� ���� �ִ� rs.left�� ū ���� �ִ� root�� ��ȯ.
			return new Pair<TreapNode, TreapNode>(rs.getLeft(), root);
		}
		return new Pair<TreapNode, TreapNode>(null, null);
	}

	// root�� ��Ʈ�� �ϴ� Ʈ���� node�� ���� �� ��� Ʈ���� ��Ʈ�� ��ȯ.
	public static TreapNode insert(TreapNode root, TreapNode node) {
		if (root == null) {
			return node;
		}

		// ��Ʈ�� �켱������ �� ����� �켱 ���� ���� ���ٸ� split�� �����Ͽ� ����.
		if (root.priority < node.priority) {
			// �� ����� Ű�� �������� ������ Ʈ��
			Pair<TreapNode, TreapNode> splitted = split(root, node.key);

			// �� ����� ���� Ʈ���� ����
			node.setLeft(splitted.getLeft());

			// �� ����� ������ Ʈ���� ����
			node.setRight(splitted.getRight());

			// ���Ӱ� ��Ʈ�� �� node�� ��ȯ.
			return node;

			// ��Ʈ�� �켱������ �� ����� �켱�������� ���ٸ� ��������� ������ ����.
		} else if (node.key < root.key) {
			root.setLeft(insert(root.left, node));
		} else {
			root.setRight(insert(root.right, node));
		}

		return root;
	}

	// �� Ʈ���� ��Ʈ a, b�� �־����� a�� �ִ��� b�� �ּڰ����� ���� �� ���� ��ĥ �� ����.
	public static TreapNode merge(TreapNode a, TreapNode b) {
		if (a == null) {
			return b;
		}

		if (b == null) {
			return a;
		}

		// b�� ��Ʈ�� �Ǿ���ϴ� ��� ��������� Ʈ���� ���� �� ��ȯ.
		if (a.priority < b.priority) {
			b.setLeft(merge(a, b.left));
			return b;
		}

		// a�� ��Ʈ�� �Ǿ���ϴ� ��� ��������� Ʈ���� ���� �� ��ȯ.
		a.setRight(merge(a.right, b));
		return a;
	}

	// root�� ��Ʈ�� �ϴ� Ʈ������ key���� ������ Ʈ���� ��Ʈ�� ��ȯ.
	public static TreapNode erase(TreapNode root, int key) {
		if (root == null) {
			return root;
		}

		// ������ ���� ã�Ƴ� ��� merge�� �� ����Ʈ���� ��ȯ.
		if (root.key == key) {
			TreapNode ret = merge(root.left, root.right);
			root = null; // �̰��� ���Ŀ� ������ �÷��Ͱ� �����ذ� ����.
			return ret;
		}

		// BST�� �Ӽ��� �����ϵ��� �Ʒ��� ����.
		if (key < root.key) {
			root.setLeft(erase(root.left, key));
		} else {
			root.setRight(erase(root.right, key));
		}

		return root;
	}

	// k��° ��带 ��ȯ.
	public static TreapNode kth(TreapNode root, int k) {
		int leftSize = 0; // ���� ����Ʈ���� ũ��.
		if (root.left != null) {
			leftSize = root.left.size;
		}
		
		// k��° ���� ���� ����Ʈ���� ��ġ��.
		if (k <= leftSize) {
			return kth(root.left, k);
		}
		
		// k��° ���� root �����.
		if (k == leftSize + 1) {
			return root;
		}
		
		// k��° ���� ������ ����Ʈ���� ��ġ��.
		return kth(root.right, k - leftSize - 1);
	}
	
	// key���� ���� ������ ������ ����.
	public static int countLessThan(TreapNode root, int key) {
		if (root == null) {
			return 0;
		}
		
		// root�� key�� key���� ũ�ٸ�, ������ ����Ʈ���� ��� �־��� key���� ŭ.
		if (key <= root.key) {
			return countLessThan(root.left, key);
		}
		
		// root�� key�� key���� �۴ٸ�,
		// �ϴ� root�� ���� ����Ʈ���� ��� �ش��� ��.
		int ls = (root.left != null ? root.left.size : 0);
		
		// �׸��� ������ ����Ʈ�� �߿� key���� ���� ���Ҵ� ��  ������ ���� ��. �߰��� 1�� root ��带 �ǹ�.
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