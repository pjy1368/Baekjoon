#include <iostream>
#include <sstream>
#include <string>
#include <cstdio>
using namespace std;


int main() {
	int N;
	scanf("%d", &N);
	getchar();

	string str;
	getline(cin, str);

	stringstream ss(str);
	string s;
	
	int* nums = new int[N];
	int size = 0;
	while (ss >> s) {
		nums[size++] = atoi(s.c_str());
	}

	int max = nums[0], min = nums[0];
	for (int i = 0; i < N; i++) {
		max = (max < nums[i]) ? nums[i] : max;
		min = (min > nums[i]) ? nums[i] : min;
	}

	printf("%d %d", min, max);
	delete[] nums;
	return 0;
}
