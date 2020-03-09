#include <cstdio>

int main() {
	int N;
	scanf("%d", &N);
	
	int maxBlank = 2 * N - 2;
	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= i; j++) {
			printf("*");
		}
		for (int k = 0; k < maxBlank; k++) {
			printf(" ");
		}
		maxBlank -= 2;
		for (int j = 1; j <= i; j++) {
			printf("*");
		}
		printf("\n");
	}

	maxBlank = 2;
	for (int i = 1; i <= N; i++) {
		for (int j = N; j > i; j--) {
			printf("*");
		}
		for (int k = 0; k < maxBlank; k++) {
			printf(" ");
		}
		maxBlank += 2;
		for (int j = N; j > i; j--) {
			printf("*");
		}
		printf("\n");
	}
	return 0;
}
