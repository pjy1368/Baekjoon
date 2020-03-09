#include <cstdio>

int main() {
	int x, y;
	int dif = 0;
	int day = 0;
	scanf("%d %d", &x, &y);

	for (int i = 1; i < x; i++) {
		if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
			dif += 31;
		}
		else if (i == 2) {
			dif += 28;
		}
		else {
			dif += 30;
		}
	}
	dif += y - 1;
	day = dif % 7;

	switch (day) {
	case 0:
		printf("MON\n");
		break;
	case 1:
		printf("TUE\n");
		break;
	case 2:
		printf("WED\n");
		break;
	case 3:
		printf("THU\n");
		break;
	case 4:
		printf("FRI\n");
		break;
	case 5:
		printf("SAT\n");
		break;
	case 6:
		printf("SUN\n");
		break;
	}

	return 0;
}
