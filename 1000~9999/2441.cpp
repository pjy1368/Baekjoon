#include <cstdio>

int main() {
	int N;
	scanf("%d", &N);

	for (int i = 1; i <= N; i++) {
		int j = 1;
		int dif = i - j;

		for (int k = 0; k < dif; k++) {
			printf(" ");
		}

		for (int j = N; j >= i; j--) {
			printf("*");
		}
		printf("\n");
	}
	return 0;
}
