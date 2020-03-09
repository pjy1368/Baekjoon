#include <cstdio>

int main() {
	int N;
	scanf("%d", &N);

	int maxBlank = N - 1;

	for (int i = 1; i <= N; i++) {
		for (int k = 0; k < maxBlank; k++) {
			printf(" ");
		}
		maxBlank--;
		for (int j = 1; j <= i; j++) {
			printf("*");
		}
		printf("\n");
	}
	maxBlank = 1;
	for (int i = 1; i <= N; i++) {
		for (int k = 0; k < maxBlank; k++) {
			printf(" ");
		}
		maxBlank++;
		for (int j = N; j > i; j--) {
			printf("*");
		}
		printf("\n");
	}
	return 0;
}
