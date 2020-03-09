#include <iostream>
#include <queue>
using namespace std;

int main() {
	int num;
	queue<int> q;
	cin >> num;

	int x, y;
	for (int i = 0; i < num; i++) {
		cin >> x >> y;
		q.push(x + y);
	}

	while (!q.empty()) {
		cout << q.front() << endl;
		q.pop();
	}
	
	return 0;
}
