#include <cstdio>

int main() {
	int N;
	scanf("%d", &N);

	for (int i = 1; i <= N; i++) {
		int j = 0;
		int dif = i - j;
		for (int k = 0; k < N - dif; k++) {
			printf(" ");
		}
		for (int m = 0; m < dif; m++) {
			printf("*");
		}
		printf("\n");
	}
	return 0;
}
