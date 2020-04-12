package noj.am;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Node {
	int data;
	Node left;
	Node right;

	Node() {
		left = right = null;
	}

	Node(int data) {
		this.data = data;
		left = right = null;
	}
}

class BinarySearchTree {
	Node root;
	StringBuilder sb;

	BinarySearchTree() {
		root = null;
		sb = new StringBuilder();
	}

	void insert(int data) {
		if (root == null) {
			root = new Node(data);
			return;
		}

		Node temp = root;
		while (true) {
			if (temp.data > data) {
				if (temp.left == null) {
					temp.left = new Node(data);
					return;
				} else {
					temp = temp.left;
				}
			} else {
				if (temp.right == null) {
					temp.right = new Node(data);
					return;
				} else {
					temp = temp.right;
				}
			}
		}
	}

	public void postorder(Node root) {
		if (root != null) {
			postorder(root.left);
			postorder(root.right);
			sb.append(root.data + "\n");
		}
	}
}

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BinarySearchTree bst = new BinarySearchTree();

		String input = "";
		while ((input = br.readLine()) != null) {
			input = br.readLine();

			int temp = Integer.parseInt(input);
			bst.insert(temp);
		}
		bst.postorder(bst.root);

		bw.write(bst.sb.toString());
		bw.flush();
		bw.close();
		br.close();
	}
}