#include <iostream>
using namespace std;

int main() {
	int num;
	int x, y;
	cin >> num;

	for (int i = 0; i < num; i++) {
		cin >> x >> y;
		cout << "Case #" << (i + 1) << ": " << x << " + " << y << " = " << x + y << endl;
	}

	return 0;
}
