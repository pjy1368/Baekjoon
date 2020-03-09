#include <stdio.h>

int main() {

  int i,j,k;
	int n;
	scanf("%d",&n);
	
	for(i=0;i<n;i++){
		for(j=0;j<i;j++)
			printf(" ");
		
		for(k=2*(n-i-1);k>=0;k--)
			printf("*");
		
		printf("\n");
	}
	
	for(i=2;i<=n;i++){
		
		for(j=1;j<=n-i;j++)
			printf(" ");

		for(k=0;k<=2*(i-1);k++)
				printf("*");
		
		printf("\n");
	}
		
  
  return 0;
}
