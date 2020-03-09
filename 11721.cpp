#include <iostream>
#include <string>
#include <queue>
using namespace std;

int main()
{
	string str;
	getline(cin, str);
	queue<char> q;
	for(unsigned int i = 0; i < str.length(); i++) {
		q.push(str.at(i));
	}
	int cnt = 0;
	while (q.size() >= 10) {
		for (int i = 0; i < 10; i++) {
			cout << q.front();
			q.pop();
		}
		cout << endl;
	}

	while (!q.empty()) {
		cout << q.front();
		q.pop();
	}
	return 0;
}
