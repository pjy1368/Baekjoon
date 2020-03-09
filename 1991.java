import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Node {
	char value;
	Node left;
	Node right;

	Node(char value, Node left, Node right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

}

class Tree {
	Node root;

	void insert(char value, char leftValue, char rightValue) {
		if (root == null) {
			if (value != '.') {
				root = new Node(value, null, null);
			}

			if (leftValue != '.') {
				root.left = new Node(leftValue, null, null);
			}

			if (rightValue != '.') {
				root.right = new Node(rightValue, null, null);
			}
			return;
		}
		find(root, value, leftValue, rightValue);
	}

	void find(Node root, char value, char leftValue, char rightValue) {
		if (root == null) {
			return;
		}

		if (root.value == value) {
			if (leftValue != '.') {
				root.left = new Node(leftValue, null, null);
			}

			if (rightValue != '.') {
				root.right = new Node(rightValue, null, null);
			}
			return;
		}

		find(root.left, value, leftValue, rightValue);
		find(root.right, value, leftValue, rightValue);
	}

	void inorder(Node root) {
		if (root == null) {
			return;
		}

		inorder(root.left);
		System.out.print(root.value);
		inorder(root.right);
	}

	void preorder(Node root) {
		if (root == null) {
			return;
		}

		System.out.print(root.value);
		preorder(root.left);
		preorder(root.right);
	}

	void postorder(Node root) {
		if (root == null) {
			return;
		}

		postorder(root.left);
		postorder(root.right);
		System.out.print(root.value);
	}

}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		char value, leftValue, rightValue;
		Tree tree = new Tree();

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			value = st.nextToken().charAt(0);
			leftValue = st.nextToken().charAt(0);
			rightValue = st.nextToken().charAt(0);
			tree.insert(value, leftValue, rightValue);
		}

		tree.preorder(tree.root);
		System.out.println();
		tree.inorder(tree.root);
		System.out.println();
		tree.postorder(tree.root);

		bw.close();
		br.close();
	}

}
