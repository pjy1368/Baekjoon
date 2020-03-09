#include <iostream>
#include <string>
#include <sstream>
using namespace std;

int main() {
	int num;
	int sum = 0;
	cin >> num;
	getchar();

	for (int i = 0; i < num; i++) {
		string str;
		getline(cin, str);
		str.replace(str.find(","), 1, " ");
		stringstream ss(str);
		string s;
		while (ss >> s) {
			sum += atoi(s.c_str());
		}
		cout << sum << endl;
		sum = 0;
	}


	return 0;
}
