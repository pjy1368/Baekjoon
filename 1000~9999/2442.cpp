#include <cstdio>

int main() {
	int N;
	scanf("%d", &N);
	
	int maxBlank = (2 * N - 1) / 2;
	for (int i = 1; i <= N; i++) {
		for (int k = 0; k < maxBlank; k++) {
			printf(" ");
		}
		maxBlank--;
		for (int j = 1; j <= 2 * i - 1; j++) {
			printf("*");
		}
		printf("\n");
	}
	return 0;
}
